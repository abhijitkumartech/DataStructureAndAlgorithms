package com.ds.linkedlist;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

/**
 * Representative class for a node
 *
 * Created by abhijit.singh on 18-09-2015.
 */

@Data
@Slf4j
public class Node {
    private int data;
    private Node next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
