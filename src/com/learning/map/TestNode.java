package com.learning.map;

public class TestNode {


    public static void main(String[] args) {
        Node head = new Node(new Object(),null);
        Node firstNode = new Node(new Object(),null);
        head.next=firstNode;
    }

    static class Node {
        private Object content;
        private Node next;

        public Node(Object content, Node next) {
            this.content = content;
            this.next = next;
        }
    }
}

