package com.leetcode;

public class Solution {

    public int reverse(int x) {
        long longResult = 0;
        int coef = 10;
        int sign = 1;
        if (x < 0) {
            sign = -1;
            x = Math.abs(x);
        }

        while (x != 0) {
            longResult = longResult * 10 + (x % coef);
            x = x / coef;
        }
        int intResult = (int) longResult;

        // detect overflow
        if (intResult != longResult) {
            return 0;
        }
        return sign * intResult;
    }

    public static void main(String[] args) {

        Solution sol = new Solution();
        System.out.println(sol.reverse(1534236469));
    }
}
