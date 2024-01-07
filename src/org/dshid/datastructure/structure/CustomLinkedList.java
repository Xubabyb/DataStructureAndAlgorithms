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

    public void append(T value) {
        var newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
        } else {
            tail.next = newNode;
        }
        tail = newNode;
        length++;
    }

    public void prepend(T value) {
        var newNode = new Node<>(value);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public T removeLast() {
        if (length == 0) {
            return null;
        }

        var temp = head;
        if (length == 1) {
            head = null;
            tail = null;
            length--;
            return temp.value;
        }

        var pre = head;

        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }

        tail = pre;
        tail.next = null;
        length--;
        return temp.value;
    }

    public T removeFirst() {
        if (length == 0) {
            return null;
        }
        var temp = head;
        head = head.next;
        temp.next = null;
        length--;
        if (length == 0) {
            tail = null;
        }
        return temp.value;
    }

    public T get(int index) {
        var node = getNode(index);
        return node != null ? node.value : null;
    }

    public boolean set(int index, T value) {
        var node = getNode(index);
        if (node != null) {
            node.value = value;
            return true;
        }
        return false;
    }

    public boolean insert(int index, T value) {
        if (index == 0) {
            prepend(value);
            return true;
        }
        if (index == length) {
            append(value);
            return true;
        }
        var newNode = new Node<>(value);
        var temp = getNode(index - 1);
        if (temp != null) {
            newNode.next = temp.next;
            temp.next = newNode;
            length++;
            return true;
        }
        return false;
    }

    public T remove(int index) {
        if (index == 0) {
            return removeFirst();
        }
        if (index == length - 1) {
            return removeLast();
        }
        var prev = getNode(index - 1);
        if (prev == null) {
            return null;
        }
        var temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;
        return temp.value;
    }

    public void reverse() {
        var temp = head;
        head = tail;
        tail = temp;
        var after = temp.next;
        Node<T> before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public void printList() {
        System.out.println("\nCustomLinked List:");
        var temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public int getLength() {
        return length;
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

    class Node<V> {

        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }

    }

    private Node<T> getNode(int index) {
        if (index < 0 || index >= length) {
            return null;
        }
        var temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp;
    }
}
