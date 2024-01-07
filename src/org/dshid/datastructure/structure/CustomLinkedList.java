package org.dshid.datastructure.structure;


public class CustomLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int length;

    public CustomLinkedList(T value) {
        var node = new Node<>(value);
        this.head = node;
        this.tail = node;
        this.length = 1;
    }

    public void printList() {
        var temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    class Node<V> {
        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void printHead() {
        System.out.println("Head: " + head.value);
    }

    public void printTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void printLength() {
        System.out.println("Length: " + length);
    }
}
