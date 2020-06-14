package com.leetcode;

/*
14. Longest Common Prefix

https://leetcode.com/problems/longest-common-prefix/

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".

Example 1:

Input: ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.

Note:

All given inputs are in lowercase letters a-z.
 */
public class Solution {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) return "";
        int stop = strs[0].length();

        for (int i = 0; i < strs.length; ++i) {

            int j = 0;
            for (int k = 0; k < stop && j < strs[i].length() && strs[0].charAt(k) == strs[i].charAt(j); ++k, ++j) {
            }
            if (j == 0) return "";
            stop = Math.min(j, stop);
        }
        return strs[0].substring(0, stop);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String prefix = solution.longestCommonPrefix(new String[]{"car", "carla", "c"});
        System.out.println(prefix);
    }
}
