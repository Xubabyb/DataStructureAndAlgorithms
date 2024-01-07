package org.dshid.datastructure.structure;

import org.dshid.datastructure.misc.classes.Cookie;

public class Main {
    public static void main(String[] args) {
        var customLinkedList = new CustomLinkedList<>(new Cookie("orange"));
        customLinkedList.append(new Cookie("green"));
        customLinkedList.append(new Cookie("red"));

        customLinkedList.printList();

        System.out.println("Removed: " + customLinkedList.removeLast());

        customLinkedList.printList();

        customLinkedList.prepend(new Cookie("brown"));

        customLinkedList.printList();

        System.out.println("Removed: " + customLinkedList.removeFirst());
        customLinkedList.printList();

        customLinkedList.set(1, new Cookie("red"));
        customLinkedList.printList();

        customLinkedList.insert(1, new Cookie("blue"));
        customLinkedList.printList();

        System.out.println("Middle: " + customLinkedList.findMiddleNodeValue());

        System.out.println(customLinkedList.hasLoop());
    }
}
