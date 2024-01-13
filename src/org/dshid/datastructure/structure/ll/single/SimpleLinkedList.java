package org.dshid.datastructure.structure.ll.single;

public class SimpleLinkedList {

    private Node head;
    private int length;

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
        }
    }

    public SimpleLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        length = 1;
    }

    public Node getHead() {
        return head;
    }

    public int getLength() {
        return length;
    }

    public void printList() {
        Node temp = head;
        if (temp == null) {
            System.out.println("empty");
        } else {
            while (temp != null) {
                System.out.print(temp.value);
                temp = temp.next;
                if (temp != null) {
                    System.out.print(" -> ");
                }
            }
            System.out.println();
        }
    }

    public void makeEmpty() {
        head = null;
        length = 0;
    }

    public void append(int value) {
        Node newNode = new Node(value);
        if (length == 0) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        length++;
    }

    // Define the binaryToDecimal method for the SimpleLinkedList class
    public int binaryToDecimal() {
        // Initialize an integer variable 'num' to 0.
        // This variable will hold the decimal value of the binary number.
        int num = 0;

        // Initialize a Node variable 'current' to point to the head of the LinkedList.
        // We will use 'current' to traverse through the LinkedList.
        var current = head;

        // Begin a while loop that continues as long as 'current' is not null.
        // A null 'current' would mean we've reached the end of the LinkedList.
        while (current != null) {

            // For each node, shift the existing 'num' value one binary place to the left
            // by multiplying it by 2. Then, add the value of the current node to it.
            // This will build our binary number into its decimal equivalent,
            // one bit at a time.
            // Преобразование методом Горнера
            num = num * 2 + current.value;

            // Move to the next node in the LinkedList.
            // 'current.next' will either point to the next node, or to null
            // if we've reached the end of the list.
            current = current.next;
        }

        // After the loop, return the decimal value stored in 'num'.
        return num;
    }


}

