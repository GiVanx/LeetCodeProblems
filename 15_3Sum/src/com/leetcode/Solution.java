package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 *
 * https://leetcode.com/problems/3sum
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 *
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 *
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 *
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 */

public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; ++i) {
            if ((i == 0) || (i > 0 && (nums[i] != nums[i - 1]))) {
                int sum = 0 - nums[i];
                int l = i + 1;
                int r = nums.length - 1;

                while (l < r) {
                    if (nums[l] + nums[r] == sum) {
                        result.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) l++;
                        while (l < r && nums[r] == nums[r - 1]) --r;
                        ++l;
                        --r;
                    } else if (nums[l] + nums[r] < sum) {
                        ++l;
                    } else {
                        --r;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<Integer>> result = sol.threeSum(new int[]{1, 2, -2, -1});

        System.out.println(result);
    }
}
