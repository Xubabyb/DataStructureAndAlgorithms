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

    class Node<V> {
        V value;
        Node<V> next;

        Node(V value) {
            this.value = value;
        }

    }
}
