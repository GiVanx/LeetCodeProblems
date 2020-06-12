package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/*
118. Pascal's Triangle

https://leetcode.com/problems/pascals-triangle/

Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

In Pascal's triangle, each number is the sum of the two numbers directly above it.

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]
 */
public class Solution {

    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> result = new ArrayList<>(numRows);

        for (int i = 0; i < numRows; ++i) {
            result.add(new ArrayList<>());
        }

        if (numRows > 1) {
            result.get(0).add(1);
        }

        for (int i = 0; i < numRows; ++i) {
            pascal(numRows, i, result);
        }
        return result;
    }

    public Integer pascal(int level, int idx, List<List<Integer>> result) {

        if (idx == 0 || idx == level - 1) {
            List<Integer> levelList = this.getOrCreate(result, level);
            levelList.add(1);
            return 1;
        }
        if (result.size() >= level && result.get(level - 1).size() == idx + 1) {
            return result.get(level - 1).get(idx);
        } else {
            Integer newValue = pascal(level - 1, idx - 1, result) + pascal(level - 1, idx, result);
            List<Integer> levelList = this.getOrCreate(result, level);
            levelList.add(newValue);
            return newValue;
        }
    }

    public List<Integer> getOrCreate(List<List<Integer>> allLists, int level) {
        List<Integer> list = allLists.get(level - 1);

        if (list == null) {
            list = new ArrayList<>();
            allLists.set(level - 1, list);
        }

        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(10);

        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
