package com.example.codingPractice.linkedList.DoublyLinkedList;

public class DoublyLinkedList {

    private ListNode head;

    private ListNode tail;

    private int length;

    private  static class ListNode{
        private int data;
        private ListNode next;
        private ListNode previous;

        public ListNode(int data){
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }

    public ListNode insert(int data,ListNode head){
        ListNode newNode = new ListNode(data);
        if(head == null){
            return null;
        }else{
            ListNode currentNode = head;
            while(currentNode.next != null){
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
            newNode.previous = currentNode;
        }
        return head;
    }

    public void printLinkedList(ListNode head){
        ListNode currentNode = head;
        while(currentNode != null){
            System.out.print(currentNode.data+"-->");
            currentNode = currentNode.next;
        }
    }

    public ListNode deleteFirstNode(ListNode head){
        if(head == null){
            return null;
        }else{
            head = head.next;
            head.previous = null;
        }
        return head;
    }

    public static void main(String... s){
        ListNode first = new ListNode(11);
        DoublyLinkedList dl = new DoublyLinkedList();
        ListNode second = dl.insert(44,first);
        ListNode third = dl.insert(33,second);
        ListNode deletedList = dl.deleteFirstNode(third);
        dl.printLinkedList(deletedList);

    }


}
