package com.ds.linkedlist;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

/**
 * Created by abhijit.singh on 18-09-2015.
 *
 * Reference: http://geeksquiz.com/linked-list-set-2-inserting-a-node/
 */

@Slf4j
@Log
public class InsertNode {


    /* Given a reference (pointer to pointer) to the head of a list and an int,
       inserts a new node on the front of the list. */
 private Node push(Node head, int newData)
    {

    /* 1. allocate node */
        Node newNode = new Node();

    /* 2. put in the data  */
        newNode.setData(newData);

    /* 3. Make next of new node as head */
        newNode.setNext(head);

    /* 4. move the head to point to the new node */
        head = newNode;
        return head;
    }

    /* Given a node prev_node, insert a new node after the given prev_node */
    void insertAfter(Node prevNode, int newData)
    {
    /*1. check if the given prev_node is NULL */
        if (prevNode == null)
        {
            System.out.println("the given previous node cannot be NULL");
            return;
        }

    /* 2. allocate new node */
        Node newNode = new Node();

    /* 3. put in the data  */
        newNode.setData(newData);

    /* 4. Make next of new node as next of prev_node */
        newNode.setNext(prevNode.getNext());

    /* 5. move the next of prev_node as new_node */
        prevNode.setNext(newNode);
    }

    /* Given a reference (pointer to pointer) to the head
       of a list and an int, appends a new node at the end  */
    private Node append(Node head, int newData)
    {
    /* 1. allocate node */
        Node newNode = new Node();
    /* 2. put in the data  */
        newNode.setData(newData);

    /* 3. This new node is going to be the last node, so make next of it as NULL*/
       newNode.setNext(null);

    /* 4. If the Linked List is empty, then make the new node as head */
        if(head == null)
        {
           head = newNode;
            return head;
        }

    /* 5. Else traverse till the last node */
        Node last = head;
        while (last.getNext() != null)
            last = last.getNext();

        last.setNext(newNode);
/*
    *//* 6. Change the next of last node *//*
        last.setNext(newNode);*/
        return head;
    }

    // This function prints contents of linked list starting from the given node
   private void printList(Node node)
    {
        StringBuilder sb = new StringBuilder();
        while (node != null)
        {
            if(sb.length() > 0)
                sb.append("-->");
             sb.append(node.getData());
            node = node.getNext();
        }
        System.out.println(sb);
    }

    public static void main(String[] args) {

        InsertNode insertNode = new InsertNode();
          /* Start with the empty list */
        Node head = null;

        // Insert 6.  So linked list becomes 6->NULL
        head = insertNode.append(head, 6);
        insertNode.printList(head);

        // Insert 7 at the beginning. So linked list becomes 7->6->NULL
        head = insertNode.push(head, 7);
        insertNode.printList(head);

        // Insert 1 at the beginning. So linked list becomes 1->7->6->NULL
        head = insertNode.push(head, 1);
        insertNode.printList(head);

        // Insert 4 at the end. So linked list becomes 1->7->6->4->NULL
        head = insertNode.append(head, 4);
        insertNode.printList(head);

        // Insert 8, after 7. So linked list becomes 1->7->8->6->4->NULL
        insertNode.insertAfter(head.getNext(), 8);
        insertNode.printList(head);

        System.out.println("Created Linked list is: ");
        System.out.println(head);
    }
}
