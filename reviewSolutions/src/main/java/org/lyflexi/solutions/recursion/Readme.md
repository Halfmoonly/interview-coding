递归, 通过函数调用自身来解决问题，从实现角度来看，它包括三要素：
1. 终止条件
2. 递归调用（递），程序不断深入的调用自身，通常传入更小或更简化的参数，直至达到上述的终止条件
3. 返回结果（归），由递达到终止条件之后，程序开始由最深层次的递函数开始逐层返回（归），汇聚每一层的结果

如求1+2+3+...+n的和，见以下代码：
```java
public int recur(int n){
    //终止条件
    if (n==1){
        return 1;
    }
    //递归调用（递）
    int rec = recur(n-1);
    //返回结果（归）
    return n+rec;
}
```

一般而言，递归与迭代可以相互转换，它们代表着完全不同的解决范式： 迭代算法如下
```java
public int recur(int n){
    int res = 0;
    if (n==0){
        return 0;
    }
    for (int i = 1; i <=n; i++) {
        res = res + i;
    }
    return res;
}
```