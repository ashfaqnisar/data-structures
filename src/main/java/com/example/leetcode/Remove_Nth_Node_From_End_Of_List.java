package com.example.leetcode;

import java.util.ArrayList;
import java.util.List;

//  Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> sample = new ArrayList<>();
        while(head != null){
            sample.add(head.val);
            head = head.next;
        }

        sample.remove(sample.size() - n);

        ListNode result;
        if (sample.size() == 0){
            result = null;
        } else {
            result = new ListNode(sample.get(0));
            ListNode current = result;
            for (int i = 1; i < sample.size(); i++){
                current.next = new ListNode(sample.get(i));
                current = current.next;
            }
        }

        return result;
    }
}

public class Remove_Nth_Node_From_End_Of_List {
    public static void printListNode(ListNode node) {
        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        printListNode(solution.removeNthFromEnd(new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5))))), 2));
    }
}


