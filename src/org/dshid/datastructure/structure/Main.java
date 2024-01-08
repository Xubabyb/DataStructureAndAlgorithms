package org.dshid.datastructure.structure;

import org.dshid.datastructure.misc.classes.Cookie;

public class Main {
    public static void main(String[] args) {
        var customLinkedList = new CustomLinkedList<>(new Cookie("orange"));
        customLinkedList.append(new Cookie("green"));
        customLinkedList.append(new Cookie("red"));

        customLinkedList.printList();
        System.out.println("#####################################################################################");

        System.out.println("Removed: " + customLinkedList.removeLast());
        customLinkedList.printList();
        System.out.println("#####################################################################################");

        customLinkedList.prepend(new Cookie("brown"));
        customLinkedList.printList();
        System.out.println("#####################################################################################");
        System.out.println("Removed: " + customLinkedList.removeFirst());
        customLinkedList.printList();
        System.out.println("#####################################################################################");

        customLinkedList.set(1, new Cookie("red"));
        customLinkedList.printList();
        System.out.println("#####################################################################################");

        customLinkedList.insert(1, new Cookie("blue"));
        customLinkedList.printList();
        System.out.println("#####################################################################################");

        System.out.println("Middle: " + customLinkedList.findMiddleNodeValue());
        System.out.println("#####################################################################################");

        System.out.println("Has loop: " + customLinkedList.hasLoop());
        System.out.println("#####################################################################################");
        customLinkedList.append(new Cookie("grey"));
        customLinkedList.append(new Cookie("black"));
        customLinkedList.append(new Cookie("white"));
        customLinkedList.append(new Cookie("yellow"));
        customLinkedList.append(new Cookie("violet"));

        System.out.println("Value: " + customLinkedList.findKthFromEnd(3));
        System.out.println("#####################################################################################");


        //Не самый наглядный (с печеньками :-)) вызов partitionList(T value), но решение верное.
        customLinkedList.printList();
        System.out.println("_____________________________________________________________________________________");

        customLinkedList.partitionList(new Cookie("grey"));

        customLinkedList.printList();
        System.out.println("#####################################################################################");

        //Запустим все с Integer :-)

        var intLL = new CustomLinkedList<>(100);
        intLL.append(50);
        intLL.append(88);
        intLL.append(12);
        intLL.append(48);
        intLL.append(26);
        intLL.append(3);
        intLL.append(63);
        intLL.partitionList(48); // 48 -> 12,26,3,100,50,88,48,63
        intLL.printList();
        System.out.println("#####################################################################################");

        customLinkedList.append(new Cookie("black"));
        customLinkedList.append(new Cookie("white"));
        customLinkedList.printList();
        System.out.println("_____________________________________________________________________________________");
        customLinkedList.removeDuplicates();
        customLinkedList.printList();
        System.out.println("#####################################################################################");

        customLinkedList.printList();
        System.out.println("______________________reverseBetween__________________________________________________");

        customLinkedList.reverseBetween(2,6);
        customLinkedList.printList();
        System.out.println("#####################################################################################");

    }
}
