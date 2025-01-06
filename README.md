公司面试coding

题目搜集不限于leetcode

题型总结

经验总结

1. if条件尽可能的简短，这样else也会更加清晰
2. 递归recursion 有三要素a终止条件/b递归调用（递）/c返回结果（归），具体表现有`ab|bc|ac`合并，甚至是`abc`合并。但是要特别注意的是递归中禁止复用变量引用，这会导致在某轮递归结束之前，上轮递归的原引用内容被修改，造成混乱
3. 迭代for/while 推荐`while/if`搭配德摩根定律`while(b1||b2||b3) + !b1&&!b2&&!b3 == 1`。有趣的是迭代程序和递归程序可以相互转换，虽然他们属于完全不同的解决范式
4. 字符串String/StringBuffer 求字符`charAt(index)`/求数值`charAt(index)-'0'`
5. 双指针tp `while|if|continue|break`，二分查找法/快慢指针法/滑动窗口法/跨数组指针
6. 哈希表 `HashMap`
7. 栈Stack `push/pop`
8. 队列Queue `offer/poll`
9. 动态规划dp 推导转移方程并填充`dp[]`数组
10. 树节点三叉戟 递归遍历/层序遍历/BST必然叶子插入/BTS按出度`0|1|2`删除算法
11. 广度优先bfs 层序遍历
12. 深度优先dfs 树递归遍历
13. 堆 `PriorityQueue`
