package com.epam.cdp.cnta2016.module4.lecture2.saples.collections;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String args[]) {

        /* Linked List Declaration */
        LinkedList<String> linkedlist = new LinkedList<String>();

        /*add(String Element) is used for adding 
         * the elements to the linked list*/
        for (int i=1; i<=5; i++){
        	linkedlist.add(String.format("Item%s", i));
        }

        /*Display Linked List Content*/
        System.out.println("Linked List Content: " + linkedlist);

        /*Add First and Last Element*/
        linkedlist.addFirst("First Item");
        linkedlist.addLast("Last Item");
        System.out.println("LinkedList Content after addition: " +linkedlist);

        /*This is how to get and set Values*/
        System.out.println("First element: " + linkedlist.get(0));
        linkedlist.set(0, "Changed first item");
        System.out.println("First element after update by set method: " + linkedlist.get(0));
        System.out.println(" Updated Content : " +linkedlist);

        /*Remove first and last element*/
        linkedlist.removeFirst();
        linkedlist.removeLast();
        System.out.println("LinkedList after deletion of first and last element: " +linkedlist);

        /* Add to a Position and remove from a position*/
        linkedlist.add(0, "Newly added item");
        linkedlist.remove(2);
        System.out.println("Content: " +linkedlist);  
        
        System.out.println("Polled First: " + linkedlist.pollFirst());
        System.out.println("Content after polling the first element: " +linkedlist); 
        
        System.out.println("Polled Last: " + linkedlist.pollLast());
        System.out.println("Content after polling the last element:" +linkedlist); 
    }

}
