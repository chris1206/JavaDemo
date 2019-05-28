package com.chris.arithmetic;

import org.junit.Test;

/**
 * LeetCode 两数相加算法
 */
public class AddTwoNumber {

    @Test
    public void test() {

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        l3.next = l2;
        l2.next = l1;

        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(6);
        ListNode l6 = new ListNode(5);
        l6.next = l5;
        l5.next = l4;

        ListNode result = new Solution().addTwoNumbers(l3,l6);
//        while (result.next!= null)
        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);

    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tmp = null;
            ListNode result = null;

            int carry = 0;
            while (l1 != null || l2 != null || carry != 0) {
                int sum = (l1 == null ? 0 : l1.val) + (l2 == null ? 0 : l2.val) + carry;
                carry = sum / 10;

                ListNode node = new ListNode(sum % 10);
                if (tmp == null) {
                    tmp = node;
                    result = tmp;
                } else {
                    tmp.next = node;
                    tmp = tmp.next;
                }

                l1 = l1 == null ? null : l1.next;
                l2 = l2 == null ? null : l2.next;
            }

            return result;
        }
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
