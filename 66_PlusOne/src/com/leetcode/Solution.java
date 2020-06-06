package com.leetcode;

/**
 * 66. Plus One
 *
 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
 *
 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
 *
 * You may assume the integer does not contain any leading zero, except the number 0 itself.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 *
 * Example 2:
 *
 * Input: [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 */
public class Solution {

    public int[] plusOne(int[] digits) {

        for (int i = digits.length - 1; i >= 0; --i) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            digits[i] = 0;
        }

        int newNum[] = new int[digits.length + 1];
        newNum[0] = 1;

        return newNum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] result = solution.plusOne(new int[]{9});

        for (int i : result) {
            System.out.print(i + " ");
        }
    }
}
