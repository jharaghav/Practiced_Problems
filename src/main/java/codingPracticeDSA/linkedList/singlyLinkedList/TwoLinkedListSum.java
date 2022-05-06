package codingPracticeDSA.linkedList.singlyLinkedList;

import java.util.HashSet;
import java.util.Stack;

public class TwoLinkedListSum {
    ListNode head;

    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode createFirstSinglyLinkedlist(){
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(6);
//        ListNode fourth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = null;

        return first;
    }

    public static ListNode createSecondSinglyLinkedlist(){
        ListNode first = new ListNode(0);
//        ListNode second = new ListNode(6);
//        ListNode third = new ListNode(4);
//
//
//        first.next = second;
//        second.next = third;
        first.next = null;

        return first;
    }

    public static void main(String... s){
        ListNode first = createFirstSinglyLinkedlist();
        ListNode second = createSecondSinglyLinkedlist();

        addTwoNumbers(first, second);
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while(l1 != null){
            stack1.push(l1.data);
            l1 = l1.next;
        }

        while(l2 != null){
            stack2.push(l2.data);
            l2 = l2.next;
        }

        ListNode l3 = null;

        int rem = 0;
        int sum = 0;

        while(!stack1.isEmpty() || !stack2.isEmpty()){
            sum = 0;
            rem = 0;
            if(!stack1.isEmpty()) sum += stack1.pop();

            if(!stack2.isEmpty()) sum += stack2.pop();

            int data = sum + rem;

            rem = (data > 9) ? (data/10) : data;

            ListNode head = new ListNode(data % 10);

            head.next = l3;

            l3 = head;

        }

        return l3;


//        ListNode prev1 = null;
//        ListNode current1 = l1;
//        ListNode next1 = null;
//
//        while(current1 != null){
//            next1 = current1.next;
//            current1.next = prev1;
//            prev1 = current1;
//            current1 = next1;
//        }
//
//        ListNode prev2 = null;
//        ListNode current2 = l2;
//        ListNode next2 = null;
//
//        while(current2 != null){
//            next2 = current2.next;
//            current2.next = prev2;
//            prev2 = current2;
//            current2 = next2;
//        }
//        ListNode l3 = prev1;
//        ListNode l4 = prev2;
//
//        ListNode l5 = new ListNode(0);
//        ListNode newHead = l5;
//        // ListNode currentHead = l3.next;
//        int rem = 0;
//
//        while(l3 != null || l4 != null){
//
//            if(l3 != null && l4 != null){
//                int data1 = l3.data;
//                int data2 = l4.data;
//                int sum = data1 + data2 + rem;
//                rem = (sum > 9) ? (sum/10):(0);
//                sum = sum % 10;
//                ListNode newNode = new ListNode(sum);
//                l5.next = newNode;
//                l5 = newNode;
//                l3 = l3.next;
//                l4 = l4.next;
//                continue;
//            }
//            if(l3 != null && l4 == null){
//                int data1 = l3.data;
//                int sum = data1 + rem;
//                rem = (sum > 9) ? (sum/10):(0);
//                sum = sum % 10;
//                ListNode newNode = new ListNode(sum);
//                l5.next = newNode;
//                l5 = newNode;
//                l3 = l3.next;
//                continue;
//            }
//            if(l3 == null && l4 != null){
//                int data2 = l2.data;
//                int sum = data2 + rem;
//                rem = (sum > 9) ? (sum/10):(0);
//                sum = sum % 10;
//                ListNode newNode = new ListNode(sum);
//                l5.next = newNode;
//                l5 = newNode;
//                l4 = l4.next;
//                continue;
//            }
//        }
//        if(rem != 0){
//            ListNode newNode = new ListNode(rem);
//            l5.next = newNode;
//        }
//        //Reverse the resultant sum of two linked lists
//
//        ListNode prev3 = null;
//        ListNode current3 = newHead.next;
//        ListNode next3 = null;
//
//        while(current3 != null){
//            next3 = current3.next;
//            current3.next = prev3;
//            prev3 = current3;
//            current3 = next3;
//        }
//
//        return prev3;

    }
}

