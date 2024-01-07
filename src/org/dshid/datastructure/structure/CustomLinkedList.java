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

    /**
     * Note:
     * <p>
     * In this problem, you should use the slow and fast pointer technique (also known as Floyd's Tortoise and Hare algorithm)
     * to find the middle element of the linked list efficiently.
     * The key idea is to have two pointers, one that moves twice as fast as the other.
     * By the time the fast pointer reaches the end of the linked list, the slow pointer will be at the middle.
     */
    public T findMiddleNodeValue() {
        // Initialize slow pointer to the head of the linked list
        var slow = head;

        // Initialize fast pointer to the head of the linked list
        var fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;
        }

        assert slow != null;
        // Return the Node object representing the middle node of the linked list
        return slow.value;

    }

    /**
     * The method should be able to detect if there is a cycle or loop present in the linked list.
     */
    public boolean hasLoop() {
        // Initialize slow pointer to the head of the linked list
        var slow = head;

        // Initialize fast pointer to the head of the linked list
        var fast = head;

        // Traverse the linked list with two pointers: slow and fast
        // slow moves one node at a time, while fast moves two nodes at a time
        while (fast != null && fast.next != null) {
            // Move slow pointer to the next node
            slow = slow.next;

            // Move fast pointer to the next two nodes
            fast = fast.next.next;

            // If slow pointer meets fast pointer, then there is a loop in the linked list
            if (slow == fast) {
                return true;
            }
        }

        // If the loop has not been detected after the traversal, then there is no loop in the linked list
        return false;
    }

    /**
     * Note:
     * <p>
     * In this problem, you should use the two-pointer technique to efficiently find the k-th node from the end of the linked list.
     */
    public T findKthFromEnd(int k) {
        // This is a common technique in computer science known as the 'fast-pointer / slow-pointer' or 'runner' technique,
        // and it's a neat way of finding a position relative to the end of a list in a single pass.
        var slow = head;
        var fast = head;
        for (int i = 0; i < k; i++) {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        assert slow != null;
        return slow.value;
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
