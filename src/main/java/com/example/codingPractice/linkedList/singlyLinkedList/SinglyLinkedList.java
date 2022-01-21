package com.example.demo.linkedList.singlyLinkedList;

public class SinglyLinkedList {

    public ListNode head;

    public static class ListNode{
        int data;

        ListNode next;

        public ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode insertBegining(int data, ListNode head){
        ListNode newNode = new ListNode(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    public static ListNode insertLast(int data,ListNode head){
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        if(head == null){
            head = newNode;
        }else{
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    public static ListNode insertAtPosition(int pos,int data,ListNode head){
        int length = findLength(head);
        ListNode newNode = new ListNode(data);
        if(pos == 1){
            newNode.next = head;
            head = newNode;
        }
        else if(pos >= 1 && pos <= length+1){
            ListNode current = head;
            int currentPos = 1;
            while(currentPos < pos-1){
                current = current.next;
                currentPos++;
            }

            newNode.next = current.next;
            current.next = newNode;
        }else{
            System.out.println("Position is invalid ");
            return null;
        }
        return head;
    }

    public static ListNode delete(int data,ListNode head){
//        if(head == null){
//            return null;
//        }else if(head.data == data) {
//            head = head.next;
//            return  head;
//        }else{
//            ListNode current = head;
//                while(current.next !=null){
//                    if(current.next.data == data){
//                        current.next = current.next.next;
//                    }
//                    current = current.next;
//                }
//            }

        //Second way ----
        ListNode current = head;
        ListNode temp = null;
        while(current != null && current.data != data){
            temp = current;
            current = current.next;
        }

        if(temp == null)
            return null;
        temp.next = current.next;
        return head;
        }

    public static ListNode deleteAtPosition(int pos, ListNode head){
        if(pos == 1){
            ListNode temp = head;
            head = head.next;
            temp.next = null;

        }else{
            ListNode current = head;
            int currentPosition = 1;
            while(currentPosition < pos-1){
                currentPosition++;
                current = current.next;
            }
            ListNode temp = current.next;
            current.next = current.next.next;
            temp.next = null;
        }
        return head;
    }

    public static void printElement(ListNode head){
        ListNode current = head;
        while(current != null){
            System.out.print(current.data+ "---> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static int findLength(ListNode head){
        ListNode current = head;
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }

    //Reverse list
    public static ListNode reverseList(ListNode head){
        if(head.next == null){
            return head;
        }
        ListNode current = head;
        ListNode next = null;
        ListNode previous = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        head = previous;
        return head;
    }

    //Find the middle Node
    public static int findMiddle(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr.data;
    }

    //Find the nth node from the end of singly linked list via using length of List

    public static int findNthNodeFromLast(ListNode head,int position){
        int length = findLength(head);
        int nodeToBeFindFromBeginging = (length - position) +1;
        ListNode current = head;
        int countPosition = 1;
        while(current != null){
            if(countPosition == nodeToBeFindFromBeginging){
                return current.data;
            }
            current = current.next;
            countPosition++;
        }
        return 0;
    }

    //Find the nth node from the end of singly linked list via using two pointers

    public static int findNthNodeFromLastUsingAnotherApproach(ListNode head,int position){
        ListNode mainPtr = head;
        ListNode refPtr = head;
        int count = 0;
        while(count < position){
            refPtr = refPtr.next;
            count++;
        }

        while(refPtr != null){
            refPtr = refPtr.next;
            mainPtr = mainPtr.next;
        }
        return mainPtr.data;
    }

    //duplicate remove from sorted linked list
    public static ListNode removeDuplicates(ListNode head){
        ListNode current = head;
        while(current != null){
            if(current.next != null){
                if(current.data == current.next.data){
                    current.next = current.next.next;
                }else {
                    current = current.next;
                }
            }else{
                current = current.next;
            }
        }
        return head;
    }

    //insert node in soreted linked list
    public static ListNode insertNodeInSortedList(ListNode head,int data){
        ListNode newNode = new ListNode(data);
        ListNode current = head;
        while(current.next != null){
            if(data >= current.data && data <= current.next.data){
                newNode.next = current.next;
                current.next = newNode;
                break;
            }else{
                current = current.next;
            }
        }
        if(current.next == null){
            current.next = newNode;
        }
        return head;
    }

    //Detect Loop in singly linked list

    public  static boolean detectLoop(ListNode head){
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while(fastPtr != null && fastPtr.next != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if(fastPtr == slowPtr){
                return true;
            }
        }
        return false;
    }

    public static void main(String... s){
        ListNode node = new ListNode(10);
        ListNode node2 =  insertLast(20,node);
        ListNode val =  insertLast(30,node2);
        ListNode val2 =  insertLast(40,val);
        ListNode val3 =  insertLast(50,val2);
        ListNode val4 =  insertLast(60,val3);
        ListNode val5 =  insertLast(30,val4);
        int length = findLength(val);
        System.out.println("length of Singly Linked List: "+length);

       //ListNode val5 = insertAtPosition(4,44,val4);
        //ListNode deletedNode = delete(10,val3);
        //printElement(deletedNode);

       // ListNode deletedNode2 = deleteAtPosition(3,val3);
       // ListNode reversedList = reverseList(val3);

        //ListNode insertedInsortedList = insertNodeInSortedList(val5,10);
       //ListNode deletedNode =  delete(55,insertedInsortedList);
        printElement(val5);

        System.out.println("loop found in this linked list : "+detectLoop(val5));
       // System.out.println("removed duplicates ");
        //ListNode removedDuplicates = removeDuplicates(val5);
       // printElement(removedDuplicates);
        System.out.println("The middle node data is: "+findMiddle(val3));

        System.out.println("2nd node from last is: "+findNthNodeFromLastUsingAnotherApproach(val3,2));
    }



    }

