package cn.alycat.leetcode.LinkedListCycle;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ListNode a1 = new ListNode(-1);
        ListNode a2 = new ListNode(-7);
        a1.next = a2;
        ListNode a3 = new ListNode(7);
        a2.next = a3;
        ListNode a4 = new ListNode(-4);
        a3.next = a4;
        ListNode a5 = new ListNode(19);
        a4.next = a5;
        ListNode a6 = new ListNode(6);
        a5.next = a6;
        ListNode a7 = new ListNode(-9);
        a6.next = a7;
        ListNode a8 = new ListNode(-5);
        a7.next = a8;
        ListNode a9 = new ListNode(-2);
        a8.next = a9;
        ListNode a0 = new ListNode(-5);
        a9.next = a0;
        a0.next = a6;
        System.out.println(new Solution().hasCycle2(a1));
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        Map<ListNode, Integer> map = new HashMap<>();
        while (head != null) {
            if (map.containsKey(head)) {
                return true;
            } else {
                map.put(head, head.val);
                head = head.next;
            }
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        if (head == null) return false;
        ListNode faster = head;
        ListNode slower = head;
        while (faster.next != null && faster.next.next != null) {
            faster = faster.next.next;
            slower = slower.next;
            while (faster == slower) {
                return true;
            }
        }
        return false;
    }

}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}