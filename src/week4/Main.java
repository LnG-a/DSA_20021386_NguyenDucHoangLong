package week4;

import week5.SLinkedList;

public class Main {
    public static void main(String[] args) {

        SLinkedList SList = new SLinkedList();
        SList.addFirst(2);
        SList.addFirst(1);
        SList.addLast(3);
        SList.delete(5);
        SList.reverse();
        SList.printReverse();
    }
}
