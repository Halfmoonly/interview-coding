只是临时的算法调试仓库，主要是下文的经验总结：

> Reference and Recommend hello-algo By krahets：https://www.hello-algo.com/en
>
> GitHub：https://github.com/krahets/hello-algo

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

- 寻解trial，基于递归函数的共享状态变量，如当前路径 `path:List<TreeNode>`收集当前状态的答案。注意结果集 `res: List<List<TreeNode>>` 并不属于trial
- 回溯retreat，伴随着向上归的动作中复原当前状态state，一般回溯retreat语句位于程序末尾
- 剪枝prune，通过return提前返回程序剪掉下面的枝叶，属于优化性能的手段。要注意剪枝语句return和trial语句的相对位置，但当trial语句在return语句之前，return之前必须再次retreat，因为提前trial了节点信息。当trial语句在return语句之后，那就没必要在return之前二次retreat

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
