package org.lyflexi.solutions;

/**
 * @Description:
 * @Author: lyflexi
 * @project: leetcode-java
 * @Date: 2024/12/7 16:46
 */

/**
 * 求解最大公约数
 * 辗转相除法
 */
public class Extra05_HSBC_GCD {
    public static void main(String[] args) {
        int gcd = gcd(4, 2);
        System.out.println(gcd);

    }

    /**
     * 默认a>b
     * @param a
     * @param b
     * @return
     */
    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        while (b != 0) {
            int mod = a % b;
            a = b;
            b = mod;
        }
        return a;
    }
}
