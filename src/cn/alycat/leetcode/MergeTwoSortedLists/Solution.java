package cn.alycat.leetcode.MergeTwoSortedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 * <p>
 * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Example:
 * <p>
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(3);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(2);
//        l2.next.next = new ListNode(6);
        ListNode listNode = new Solution().mergeTwoLists(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode result = new ListNode(0);
        ListNode tmp = result;
        while (l1 != null || l2 != null) {
           if(l1 == null){
               tmp.next = l2;
               break;
           }else if(l2 == null){
                tmp.next = l1;
                break;
           }else{
               if(l1.val >= l2.val){
                   tmp.next = l2;
                   l2 = l2.next;
               }else{
                   tmp.next = l1;
                   l1 = l1.next;
               }
           }
            tmp = tmp.next;
        }
        return result.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}