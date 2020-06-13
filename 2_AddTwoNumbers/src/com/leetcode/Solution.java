package com.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

/*
2. Add Two Numbers

https://leetcode.com/problems/add-two-numbers/

You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.

 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
        this.val = 0;
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Result {
    ListNode l3;
    int carry;
    ListNode start;
    List<ListNode> nodes;

    void setL3(ListNode node) {
        if (start == null) {
            start = node;
        }
        this.l3 = node;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Result result = new Result();
        result = compute(result, l1, l2);
        l1 = result.nodes.get(0);
        l2 = result.nodes.get(1);

        result = compute(result, l1);
        result = compute(result, l2);

        if (result.carry == 1) {
            result.l3.next = new ListNode(1);
        }

        return result.start;
    }

    Result compute(Result result, ListNode... l) {

        List<ListNode> nodeList = Arrays.asList(l);

        while (nodeList.stream().allMatch(li -> li != null)) {

            result.setL3(getNextNode(result.l3));

            ListNode l3 = result.l3;

            int carry = result.carry;
            for (ListNode node : l) {
                l3.val += node.val;
            }
            l3.val += carry;

            result.carry = 0;
            if (l3.val >= 10) {
                l3.val %= 10;
                result.carry = 1;
            }

            nodeList = nextNodes(nodeList);
        }

        result.nodes = nodeList;
        return result;
    }

    List<ListNode> nextNodes(List<ListNode> nodeList) {
        ListIterator<ListNode> it = nodeList.listIterator();
        ListNode node;
        while (it.hasNext()) {
            node = it.next();
            it.set(node.next);
        }
        return nodeList;
    }

    ListNode getNextNode(ListNode l3) {
        ListNode newNode = new ListNode();
        if (l3 != null) {
            l3.next = newNode;
            l3 = l3.next;
        }
        return newNode;
    }

    ListNode getNode(int... numbers) {
        ListNode node = null;
        ListNode start = null;
        for (int num : numbers) {
            ListNode newNode = new ListNode(num);
            if (node != null) {
                node.next = newNode;
            } else {
                start = newNode;
            }
            node = newNode;
        }
        return start;
    }

    void print(ListNode n) {
        while (n != null) {
            System.out.print(n.val + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode n1 = solution.getNode();
        ListNode n2 = solution.getNode();
        ListNode r = solution.addTwoNumbers(n1, n2);

        solution.print(r);
    }
}