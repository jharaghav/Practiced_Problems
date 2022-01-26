package codingPracticeDSA.linkedList.singlyLinkedList;

import java.util.HashSet;

public class FindStartNodeOfLoop {

    ListNode head;

    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode findStartNodeInLoop(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = head;

        while(current != null){
            if(!hashSet.contains(current)){
                hashSet.add(current);
            }else{
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public static ListNode createLoopInSinglyLinkedlist(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;

        return first;
    }

    public static void main(String... s){
        ListNode node = createLoopInSinglyLinkedlist();

        System.out.println("first Node in Loop is : "+findStartNodeInLoop(node).data);
    }
}
