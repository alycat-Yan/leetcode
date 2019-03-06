package cn.alycat.leetcode.AddTwoNumbers;

/**
 * Definition for singly-linked list.
 * class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        boolean hasNext = true;
        int upCount = 0;
        ListNode resultNode = l1;
        //定义l1为长链表
        //当l2长度大于l1时 将l2 追加到l1后面
        // 当最后一个元素为0时 去掉
        // 进位
        while (hasNext) {
            if (l2 == null) {
                l2 = new ListNode(0);
            }
            l1.val = l1.val + upCount + l2.val;
            if (l1.val / 10 > 0) {
                l1.val = l1.val % 10;
                upCount = 1;
            } else {
                upCount = 0;
            }
            if (l1.val == 0 && !hasNext) {
                l1 = null;
            }
            if (l1.next == null && l2.next != null) {
                l1.next = l2.next;
                l2 = null;
            } else {
                l2 = l2.next;

            }
            if (l1.next == null && upCount == 1) {
                l1.next = new ListNode(upCount);
                upCount = 0;
            }
            l1 = l1.next;
            if (l1 == null && l2 == null) {
                hasNext = false;
            }

        }
        return resultNode;
    }


}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}