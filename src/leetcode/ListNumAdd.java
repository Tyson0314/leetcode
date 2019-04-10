package leetcode; /**
 * Copyright (C), 2018-2018
 * FileName: com.tyson.leetcode.ListNumAdd
 * Author:   Tyson
 * Date:     2018/7/23/0023 22:45
 * Description: two num add
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */

/**
 * @author Tyson
 * @create 2018/7/23/0023
 * @since 1.0.0
 */
public class ListNumAdd {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int length1 = 0;
            int length2 = 0;
            ListNode node1 = l1;
            ListNode node2 = l2;

            while(node1 != null) {
                node1 = node1.next;
                length1++;
            }
            while(node2 != null) {
                node2 = node2.next;
                length2++;
            }

            node1 = l1;
            node2 = l2;

            int num1 = 0;
            int num2 = 0;
            for(int i = 0; i < length1; i++) {
                num1 += node1.val * (int)Math.pow(10, i);
                node1 = node1.next;
            }
            for(int j = 0; j < length2; j++) {
                num2 += node2.val * (int)Math.pow(10, j);
                node2 = node2.next;
            }
            System.out.println(num1);
            System.out.println(num2);

            int sum = num1 + num2;

            ListNode result = node1;

            int num = 0;
            while(sum > 0) {
                num = sum % 10;
                System.out.println(sum);

                if(node1 == null) {
                    node1 = new ListNode(num);
                } else
                    node1.val = num;

                node1 = node1.next;
                sum /= 10;
            }

            return result;
        }

        public static void main(String [] args) {
            ListNode l1 = new ListNode(5);
            //com.tyson.leetcode.ListNode l2 = new com.tyson.leetcode.ListNode(4);
            //com.tyson.leetcode.ListNode l3 = new com.tyson.leetcode.ListNode(2);

            //l1.next = l2;
            //l2.next = l3;

            ListNode n1= new ListNode(5);
            //com.tyson.leetcode.ListNode n2 = new com.tyson.leetcode.ListNode(6);
            //com.tyson.leetcode.ListNode n3 = new com.tyson.leetcode.ListNode(5);

            //n1.next = n2;
            //n2.next = n3;

            ListNode l = new ListNumAdd().addTwoNumbers(l1, n1);

            while(l != null) {
                System.out.print(l.val + ", ");
                l = l.next;
            }

        }
    }

    class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }