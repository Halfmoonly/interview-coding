只是临时的算法调试仓库，主要是下文的经验总结：

> Reference and Recommend hello-algo By krahets：https://www.hello-algo.com/en
>
> GitHub：https://github.com/krahets/hello-algo

## 核心篇

分支判断

* 卫语句
  * 优先考虑失败、异常、中断、退出等直接返回的情况。
  * if条件尽可能变得简短，这样else也会更加清晰，除非你清楚所有的可能性
* 德摩根定律
  * `if/while(b1||b2||b3) + if/while(!b1&&!b2&&!b3) == 1`
  * `if/while(b1&&b2&&b3) + if/while(!b1||!b2||!b3) == 1`

递归问题 `Recursion`

- 属于“自上而下”的解决问题，由大到小拆解问题递归三要素，终止条件、递归调用（子问题）、返回结果（归）
- 当递归函数有返回值，子递归调用必须return，请注意这有别于终止条件的返回
- 当递归函数无返回值，收集结果（归）应当在递归参数当中体现
- 禁止自增自减++--，即使不是引用变量，比如++k/k++操作，会导致当前递归层状态丢失。正确的传参姿势是k-1/k+1
- 禁止定义局部变量，由于反复递归导致局部变量被反复初始化，最终局部变量将毫无意义

回溯问题 `BackTracking`

In Example One, visiting each node starts a "trial". And passing a leaf node or the `return` statement to going back to the parent node suggests "retreat".

- 寻解trial，基于递归函数的共享状态变量 `state `，如当前路径  `path:List<TreeNode>`收集当前状态的答案。注意结果集 `res: List<List<TreeNode>````>` 并不属于trial
- 回溯retreat，伴随着向上归的动作中复原当前状态state，一般回溯retreat语句位于程序末尾
- 剪枝prune，通过return提前返回程序剪掉下面的枝叶，属于优化性能的手段。要注意剪枝语句return和trial语句的相对位置，但当trial语句在return语句之前，return之前必须再次retreat，因为提前trial了节点信息。当trial语句在return语句之后，那就没必要在return之前二次retreat
- 经典应用场景有dfs，permutation

链表迭代 `Listnode`

* 迭代 `iteration`属于“自下而上”的解决问题，由小到大解决问题
* 表现形式 `for/while`
* 单向链表 `ListNode`
* 双向链表
* 循环链表

二叉树 `TreeNode`

* 递归：深度优先dfs递归遍历
* 迭代：广度优先bfs层序遍历

二叉搜索树 `BST`

* 递归：中序遍历天然有序
* 迭代：二分查找
* 迭代：叶子插入（二分查找+叶子插入）
* 迭代+递归：按出度 `0|1|2`删除算法

字符串 `String`

1. 求字符 `charAt(index)`
2. 求数值 `charAt(index)-'0'`

双指针 `Point`

* `while|if|continue|break`
* 二分查找法
* 快慢指针法
* 滑动窗口法
* 跨数组多指针

哈希表 `Hashmap`

* 查找
* 缓存

栈 `Stack`

* `push/pop/peek`

队列 `Queue`

* `Queue`是顶级接口，实现类有 `LinkedList`，`PriorityQueue`
* `offer/poll`

动态规划 `Dynamic Programing`

* 推导转移方程并填充 `dp[]`数组


## 框架篇

回溯框架1：

- state，是trial共享待回溯变量，如共享路径变量
- choices，是输入集合，如树节点集合集合
- res，答案收集器

```java
/* Backtracking algorithm framework */
void backtrack(State state, List<Choice> choices, List<State> res) {
    // Check if it's a solution
    if (isSolution(state)) {
        // Record the solution
        recordSolution(state, res);
        // Stop searching
        return;
    }
    // Iterate through all choices
    for (Choice choice : choices) {
        // Prune: check if the choice is valid
        if (isValid(state, choice)) {
            // Trial: make a choice, update the state
            makeChoice(state, choice);
            backtrack(state, choices, res);
            // Retreat: undo the choice, revert to the previous state
            undoChoice(state, choice);
        }
    }
}
```

回溯框架2：全排列

- 求解不含重复数字的输入数组的所有 **不重复全排列**

```java
/* Backtracking algorithm: Permutation I */
void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
    // When the state length equals the number of elements, record the solution
    if (state.size() == choices.length) {
        res.add(new ArrayList<Integer>(state));
        return;
    }
    // Traverse all choices
    for (int i = 0; i < choices.length; i++) {
        int choice = choices[i];
        // Pruning: do not allow repeated selection of elements
        if (!selected[i]) {
            // Attempt: make a choice, update the state
            selected[i] = true;
            state.add(choice);
            // Proceed to the next round of selection
            backtrack(state, choices, selected, res);
            // Retract: undo the choice, restore to the previous state
            selected[i] = false;
            state.remove(state.size() - 1);
        }
    }
}

/* Permutation I */
List<List<Integer>> permutationsI(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
    return res;
}
```

回溯框架3：全排列Ⅱ

- 求解包含重复数字的输入数组的所有 **不重复全排列**

Although both `selected` and `duplicated` serve as pruning mechanisms, they target different issues:

* **Repeated-choice pruning** (via `selected`): There is a single `selected` array for the entire search, indicating which elements are already in the current state纵向. This prevents the same element from appearing more than once in `state`.
* **Equal-element pruning** (via `duplicated`): Each call to the `backtrack` function uses its own `duplicated` set横向, recording which elements have already been chosen in that specific iteration (`for` loop). This ensures that equal elements are selected only once per round of choices.

```java
/* Backtracking algorithm: Permutation II */
void backtrack(List<Integer> state, int[] choices, boolean[] selected, List<List<Integer>> res) {
    // When the state length equals the number of elements, record the solution
    if (state.size() == choices.length) {
        res.add(new ArrayList<Integer>(state));
        return;
    }
    // Traverse all choices，每次重建意味着递归的每一层duplicated变量是独立的。窥探整个递归树的全貌，同一层节点如果存在相同值，要提前剪枝
    Set<Integer> duplicated = new HashSet<Integer>();
    for (int i = 0; i < choices.length; i++) {
        int choice = choices[i];
        // Pruning: do not allow repeated selection of elements and do not allow repeated selection of equal elements
        if (!selected[i] && !duplicated.contains(choice)) {
            // Attempt: make a choice, update the state
	    // 由于递归回溯时会返回到上一级，而上一级别有自己的 duplicated 集合，因此不需要从duplicated集合中移除元素。对duplicated来说不用回溯retreat
            duplicated.add(choice); // Record selected element values
            selected[i] = true;
            state.add(choice);
            // Proceed to the next round of selection
            backtrack(state, choices, selected, res);
            // Retract: undo the choice, restore to the previous state
            selected[i] = false;
            state.remove(state.size() - 1);
        }
    }
}

/* Permutation II */
List<List<Integer>> permutationsII(int[] nums) {
    List<List<Integer>> res = new ArrayList<List<Integer>>();
    backtrack(new ArrayList<Integer>(), nums, new boolean[nums.length], res);
    return res;
}
```
