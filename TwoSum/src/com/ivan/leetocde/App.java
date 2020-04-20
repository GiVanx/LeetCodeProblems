package com.ivan.leetocde;

import java.util.HashMap;
import java.util.Map;

/*
https://leetcode.com/problems/two-sum/

1. Two Sum

Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.

Example:

Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
*/

public class App {

    public void printArray(int [] array) {
        for (int i = 0; i < array.length; ++i) {
            System.out.print(" " + array[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {

        if (nums.length <= 1) {
            throw new IllegalArgumentException("No two sum solution");
        }

        // map (target - current.number) to current.number.index
        Map<Integer, Integer> remainder2Index = new HashMap<>();

        // O(n) time complexity
        // O(n) space complexity (nums.length == remainder2Index.length)
        for (int i = 0; i < nums.length; ++i) {

            // check if there was already a number for which (target - previous.number) = current.number
            if (remainder2Index.containsKey(nums[i])) {
                return new int[] {remainder2Index.get(nums[i]), i};
            } else {
                remainder2Index.put(target - nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args) {

        App app = new App();
        int solution[] = app.twoSum(new int[] {1, 2, 3, 8}, 9);

        app.printArray(solution);
    }
}
