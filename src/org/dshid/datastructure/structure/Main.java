package org.dshid.datastructure.structure;

import org.dshid.datastructure.misc.classes.Cookie;

public class Main {
    public static void main(String[] args) {
        var customLinkedList = new CustomLinkedList<>(new Cookie("orange"));
        System.out.println("\nLinked List:");
        customLinkedList.printList();
    }
}
