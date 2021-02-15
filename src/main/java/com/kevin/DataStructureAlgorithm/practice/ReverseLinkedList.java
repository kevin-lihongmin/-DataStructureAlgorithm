package com.kevin.DataStructureAlgorithm.practice;


import java.util.Stack;

/**
 *  单链表反转 Leet Code 206
 *
 *  Input ： 1 -> 2 -> 3 -> 4 -> 5 -> null
 *  Output： 5 -> 4 -> 3 -> 2 -> 1 -> null
 *
 * @author kevin
 * @date 2021/2/7 17:25
 * @since 1.0.0
 */
public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        listNode.addNode(2)
        .addNode(3)
        .addNode(4)
        .addNode(5);

        ListNode listNode1 = ReverseLinkedList.reverseList(listNode);

    }

    /*public static ListNode reverseListByStack(ListNode listNode) {
        if (listNode == null) {
            return listNode;
        }
        Stack stack = new Stack();
        while (listNode.next != null) {
            stack.add(listNode.value);
            listNode.
        }
    }*/

    public static ListNode reverseList(ListNode listNode) {
        if (listNode == null) {
            return listNode;
        }
        ListNode dummy = new ListNode(-1);

        dummy.next = listNode;
        ListNode prev = dummy.next;
        ListNode pCur = prev.next;
        while (pCur != null) {
            prev.next = pCur.next;
            pCur.next = dummy.next;
            dummy.next = pCur;
            pCur = prev.next;
        }
        return dummy.next;
    }

    /** 单链表 对象 */
    public static class ListNode {
        /** 当前节点值 */
        private int value;

        /** 下一个节点指针 */
        private ListNode next;

        public ListNode(int value) {
            this.value = value;
        }

        public ListNode(int value, ListNode next) {
            this.value = value;
            this.next = next;
        }

        public void loop(ListNode listNode) {
            if (listNode == null || listNode.next == null) {
                System.out.print("null");
                return;
            }

        }

        /** 在当前节点后面添加一个新的节点，并且将当前节点的后继指针指向新节点 */
        public ListNode addNode(int value) {
            ListNode newNode = new ListNode(value);
            this.next = newNode;
            return newNode;
        }
    }
}