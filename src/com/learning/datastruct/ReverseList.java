package com.learning.datastruct;

import java.util.LinkedList;

/**
 * 反转列表
 */
public class ReverseList {

    public static void main(String[] args) {
        Node before = structNodeList();
        Node after = method_011(before);
        System.out.println(after.getNext());
    }

    /**
     * 方式一：处理每个节点，让每个节点的next指针指向前面一个元素
     */
    public static Node method_01(Node head) {
        Node pre = null;
        Node currentNode = head;
        while (currentNode != null) {
            Node next = currentNode.next;
            currentNode.next = pre;
            pre = currentNode;
            currentNode = next;

        }
        return pre;
    }


    public static Node method_011(Node head) {
        Node currentNode = head;

        while (currentNode.next != null) {
            Node nextNode = currentNode.next;
            nextNode.next = currentNode;
            currentNode = nextNode;
        }
        return currentNode;
    }


    public static void method_02(Node head) {

    }


    static Node structNodeList() {
        Node head = new Node(0, null);
        Node node_01 = new Node(1, null);
        head.next = node_01;

        Node node_02 = new Node(2, null);
        node_01.next = node_02;

        Node node_03 = new Node(3, null);
        node_02.next = node_03;

        Node node_04 = new Node(4, null);
        node_03.next = node_04;

        return head;
    }


    static class Node {

        private Integer value;
        private Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Integer getValue() {
            return value;
        }

        public void setValue(Integer value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}


