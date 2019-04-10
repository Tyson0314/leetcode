/**
 * Copyright (C), 2018-2018
 * FileName: ReverseBetween
 * Author:   Tyson
 * Date:     2018/12/27/0027 10:01
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Tyson
 * @create 2018/12/27/0027 10:01
 * @since 1.0.0
 */
public class ReverseBetween {
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null) {
            return null;
        }
        if(m == n) {
            return head;
        }
        ListNode newHead = new ListNode(0);
        newHead.next = head;

        ListNode pre;
        ListNode cur = null;
        ListNode next = null;
        ListNode mPre = newHead;

        for(int i = 0; i < m - 1; i++) {
            mPre = mPre.next;
            if(mPre == null) {
                return null;
            }
        }

        pre = mPre.next;

        if(pre != null) {
            cur = pre.next;
        }

        for(int j = 0; j < n - m; j++) {
            if(pre == null || cur == null) {
                return null;
            }
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        mPre.next.next = next;
        mPre.next = pre;

        return newHead.next;

    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode head1 = new ListNode(2);
        ListNode head2 = new ListNode(3);
        ListNode head3 = new ListNode(4);
        head.next = head1;
        head1.next = head2;
        head2.next = head3;

        ListNode h = reverseBetween(head, 1, 4);

        System.out.println(h.val);
        System.out.println(h.next.val);
        System.out.println(h.next.next.val);
        System.out.println(h.next.next.next.val);
    }
}