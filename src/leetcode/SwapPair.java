/**
 * Copyright (C), 2018-2018
 * FileName: SwapPair
 * Author:   Tyson
 * Date:     2018/8/6/0006 23:57
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package leetcode;

/**
 * @author Tyson
 * @create 2018/8/6/0006
 * @since 1.0.0
 */
public class SwapPair {
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        head = tmp;

        while(head.next != null && head.next.next != null) {
            ListNode l1 = head.next;
            ListNode l2 = head.next, next;

            l1.next = l2.next;
            l2.next = l1;
            head.next = l2;

            head = l1;
        }

        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;
        new SwapPair().swapPairs(l1);
    }
}