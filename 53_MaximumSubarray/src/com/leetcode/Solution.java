package com.leetcode;

/*

53. Maximum Subarray

https://leetcode.com/problems/maximum-subarray/

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
public class Solution {

    public int maxSubArray(int[] nums) {
        int start = 0;
        int end = 0;
        int maxEndingHere = nums[0];
        int maxSoFar = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            if (nums[i] > nums[i] + maxEndingHere) {
                start = i;
            }
            maxEndingHere = Math.max(nums[i], nums[i] + maxEndingHere);
            if (maxEndingHere > maxSoFar) {
                end = i;
            }
            maxSoFar = Math.max(maxEndingHere, maxSoFar);
        }

        for (int i = start; i <= end; ++i) {
            System.out.print(nums[i] + " ");
        }
        return maxSoFar;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
