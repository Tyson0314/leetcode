/**
 * Copyright (C), 2018-2019
 * FileName: ReorderList
 * Author:   Tyson
 * Date:     2019/4/10/0010 16:57
 * Description: 重排链表
 */
package leetcode;

/**
 * @author Tyson
 * @create 2019/4/10/0010 16:57
 * @since 1.0.0
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) {
            return;
        }
        //从链表中间拆分成两条链
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        ListNode head1 = head;
        ListNode head2 = slow.next;
        //链表head1链尾置为null
        slow.next = null;

        //翻转链表head2
        ListNode pre;
        ListNode cur = head2.next, next = head2;
        while(cur != null) {
            pre = cur.next;
            cur.next = next;
            next = cur;
            cur = pre;
        }
        head2.next = null;
        head2 = next;

        //合并链表
        while(head2 != null) {
            next = head1.next;
            head1.next = head2;
            head1 = head1.next;
            head2 = head2.next;
            head1.next = next;
            head1 = head1.next;
        }
    }
}