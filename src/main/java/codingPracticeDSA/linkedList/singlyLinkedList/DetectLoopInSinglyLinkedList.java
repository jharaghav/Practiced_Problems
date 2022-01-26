package codingPracticeDSA.linkedList.singlyLinkedList;

import java.util.HashSet;

public class DetectLoopInSinglyLinkedList {
    ListNode head;

    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    //floyd's cycle -finding algorithm

    public static boolean loopContains(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr !=null && fastPtr.next != null){
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;
            if(slowPtr == fastPtr){
                return true;
            }
        }
        return false;
    }

    //Hashing technique to find the loop

    public static boolean loopContainsByAnotherWay(ListNode head){
        HashSet<ListNode> hashSet = new HashSet<>();
        ListNode current = head;

        while(current != null){
            if(!hashSet.contains(current)){
                hashSet.add(current);
            }else{
                return true;
            }
            current = current.next;
        }

        return false;
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
        sixth.next = null;

        return first;
    }

    public static void main(String... s){
        ListNode node = createLoopInSinglyLinkedlist();

        System.out.println("Loop Contains : "+loopContainsByAnotherWay(node));
    }
}
