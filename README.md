题目搜集不限于leetcode

经验总结，尽量不会成为我们的心智负担

1. 条件分支
   1. 卫语句
      1. 优先考虑失败、异常、中断、退出等直接返回的情况。
      2. if条件尽可能变得简短，这样else也会更加清晰，除非你清楚所有的可能性
   2. 德摩根定律
      1. `if/while(b1||b2||b3) + if/while(!b1&&!b2&&!b3) == 1`
      2. `if/while(b1&&b2&&b3) + if/while(!b1||!b2||!b3) == 1`
2. 递归 `Recursion`：属于“自上而下”的解决问题，由大到小拆解问题
   1. 递归三要素，终止条件、递归调用（子问题）、返回结果（归）
   2. 当递归函数返回值非void，子递归调用必须return，请注意这有别于终止条件的返回
   3. 当递归函数返回值为void，则递归代码不需要显式返回结果，但是返回结果（归）应当蕴含于递归方法的引用变量参数当中，或者类成员变量赋值体现
   4. 禁止自增自减++--，即使不是引用变量，比如++k/k++操作，会导致当前递归层状态丢失。正确的传参姿势是k-1/k+1
   5. 禁止定义局部变量，由于反复递归导致局部变量被反复初始化，最终局部变量将毫无意义
   6. 回溯问题，递归之后需先修正局部价值，方可继续进行下次递归。也可以构造副本传参避免回溯
3. 迭代 `Iteration`
   1. 迭代iteration属于“自下而上”的解决问题，由小到大解决问题
   2. 表现形式：for/while
4. 链表 `ListNode`
   1. 单向链表
   2. 双向链表
   3. 循环链表
5. 二叉树 `TreeNode`
   1. 递归：深度优先dfs递归遍历，需要推演算法但不是根，而是叶子小树林
   2. 迭代：广度优先bfs层序遍历
6. 二叉搜索树 `BST`
   1. 递归：中序遍历天然有序
   2. 迭代：二分查找
   3. 迭代：叶子插入（二分查找+叶子插入）
   4. 迭代+递归：按出度 `0|1|2`删除算法
7. 字符串 `String`
   1. 求字符 `charAt(index)`
   2. 求数值 `charAt(index)-'0'`
8. 双指针
   1. `while|if|continue|break`
   2. 二分查找法
   3. 快慢指针法
   4. 滑动窗口法
   5. 跨数组多指针
9. 哈希表 `HashMap`
   1. 查找
   2. 缓存
10. 栈 `Stack`
    1. `push/pop/peek`
11. 队列 `Queue`
    1. `Queue`是顶级接口，还有子接口阻塞队列 `BlockingQueue`，双向队列 `Deque`
    2. `Queue`的实现类有 `LinkedList`，`PriorityQueue`
    3. `offer/poll`
12. 动态规划dp
    1. 推导转移方程并填充 `dp[]`数组



---



> Reference and Recommend hello-algo By krahets：https://www.hello-algo.com/en
>
> GitHub：https://github.com/krahets/hello-algo
