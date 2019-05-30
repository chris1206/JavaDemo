package com.chris.arithmetic;

import org.junit.Test;

/**
 * LeetCode 两数相加算法
 */
public class AddTwoNumber {

    @Test
    public void test() {

//        ListNode l1 = new ListNode(2);
//        ListNode l2 = new ListNode(4);
//        ListNode l3 = new ListNode(3);
        ListNode l1 = new ListNode(9);
        ListNode l2 = new ListNode(9);
        ListNode l3 = new ListNode(9);
        l3.next = l2;
        l2.next = l1;

//        ListNode l4 = new ListNode(4);
//        ListNode l5 = new ListNode(6);
//        ListNode l6 = new ListNode(5);
        ListNode l4 = new ListNode(9);
        ListNode l5 = new ListNode(9);
        ListNode l6 = new ListNode(9);
        ListNode l7 = new ListNode(9);
        l7.next = l6;
        l6.next = l5;
        l5.next = l4;

        ListNode result = new Solution().addTwoNumbers(l3,l7);
        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }

    }

    ListNode getNode(){

        ListNode temp = new ListNode(1);
        ListNode result = temp;

        ListNode temp2 = new ListNode(2);
        temp.next = temp2;

        return result;
    }

    int getNum() {
        int temp = 1;
        int result = temp;

        temp += 1;
        return result;
    }



    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            ListNode tmp = null;//保存每位 %10 后的node,相当于指针
            ListNode result = null;

            int carry = 0;//是否有进位 0 或 1
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

        public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {

            //==========预处理,保证计算不出nullpointer错
            if(l1 == null){
                l1 = new ListNode(0);
            }
            if(l2 == null){
                l2 = new ListNode(0);
            }
            //========================================


            if(l1.next==null && l2.next==null){//最小情况
                int val = l1.val+l2.val;
                if(val>9){
                    ListNode node = new ListNode(val%10);//设置第二位
                    node.next = new ListNode(val/10);//设置第一位
                    return node;
                }else
                    return new ListNode(val);
            }else {//可继续迭代的情况
                int val = l1.val+l2.val;
                if(val>9){
                    val = val-10;
                    if(l1.next!=null)  l1.next.val++;
                    else if(l2.next!=null)  l2.next.val++;
                    //else //不存在的，必为上述两种情况之一。
                }

                ListNode node = new ListNode(val);
                //开始迭代
                node.next = addTwoNumbers(l1.next,l2.next);
                return node;
            }
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
