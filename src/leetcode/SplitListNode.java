/**
 * Copyright (C), 2018-2019
 * FileName: SplitListNode
 * Author:   Tyson
 * Date:     2019/1/21/0021 9:29
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2019/1/21/0021 9:29
 * @since 1.0.0
 */
class SplitListNode {
    public ListNode partition(ListNode head, int x) {
        ListNode smallHead = new ListNode(0);
        ListNode bigHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode big = bigHead;

        while(head != null) {
            if(head.val < x) {
                smallHead.next = head;
                smallHead = smallHead.next;
                head = head.next;
            } else {
                bigHead.next = head;
                bigHead = bigHead.next;
                head = head.next;
            }
        }

        smallHead.next = big.next;
        return small.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l3 = new ListNode(8);
        ListNode l5 = new ListNode(5);
        l1.next = l3;
        l3.next = l5;

        SplitListNode sln = new SplitListNode();
        sln.partition(l1, 3);
    }
}