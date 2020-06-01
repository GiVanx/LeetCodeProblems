package com.leetcode;

/**
 * 11. Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 *
 * Example:
 *
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 */
public class Solution {

    public int maxArea(int[] height) {

        int i = 0;
        int j = height.length - 1;
        int maxComputedHeight = 0;
        int maxArea = 0;

        while (i != j) {
            int min = Math.min(height[i], height[j]);
            maxComputedHeight = Math.max(min, maxComputedHeight);
            maxArea = Math.max(maxArea, min * (j - i));

            if (height[i] == min) {
                while (height[i] <= maxComputedHeight && i != j) {
                    ++i;
                }
            } else {
                while (height[j] <= maxComputedHeight && i != j) {
                    --j;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        int height[] = new int[]{1,8, 20, 6, 30, 4};
        System.out.println(s.maxArea(height));
    }
}
