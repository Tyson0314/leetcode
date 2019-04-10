/**
 * Copyright (C), 2018-2019
 * FileName: DetectCircle
 * Author:   Tyson
 * Date:     2019/4/10/0010 15:21
 * Description: 环形链表
 */
package leetcode;

/**
 * @author Tyson
 * @create 2019/4/10/0010 15:21
 * @since 1.0.0
 */
public class DetectCycle {
    public ListNode detectCycle(ListNode head) {
        if(head == null) {
            return null;
        }
        //快慢指针找出环的大小
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(slow == fast) {
                break;
            }
        }
        if(fast == null || fast.next == null) {
            return null;
        }
        int sizeOfCycle = 0;
        while(true) {
            slow = slow.next;
            sizeOfCycle++;
            if(slow == fast) {
                break;
            }
        }
        //快慢指针重新从链表首部出发，快指针先走sizeOfCycle步
        //然后两个指针同时一起走，步长为1，相遇节点即是环的入口
        slow = head;
        fast = head;
        while(sizeOfCycle-->0) {
            fast = fast.next;
        }
        while(true) {
            if(fast == slow) {
                return fast;
            }
            fast = fast.next;
            slow = slow.next;
        }
    }
}