package codingPracticeDSA.linkedList.singlyLinkedList;

public class MergeTwoSortedLinkedList {

    private ListNode head;

    private static class ListNode{
        private int data;
        private ListNode next;

       public ListNode(int data){
            this.data = data;
            this.next = null;
        }

        public ListNode(){}
    }

    public static ListNode createFirstSortedSinglyLinkedlist(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(4);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(9);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;


        return first;
    }

    public static ListNode createSecondSortedSinglyLinkedlist(){
        ListNode first = new ListNode(3);
        ListNode second = new ListNode(5);
        ListNode third = new ListNode(7);
        ListNode fourth = new ListNode(10);
        ListNode fifth = new ListNode(11);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;


        return first;
    }

    public static ListNode mergeTwoSortedLinkedList(ListNode firstHead,ListNode secondHead){



        if(firstHead == null) return secondHead;
        if(secondHead == null) return firstHead;
        ListNode firstCurrentNode = firstHead;

        ListNode secondCurrentNode = secondHead;

        ListNode mergedList = new ListNode();

        while(firstCurrentNode != null && secondCurrentNode != null){
            if(firstCurrentNode.data < secondCurrentNode.data){
                mergedList = insertAtEnd(mergedList,firstCurrentNode.data);
                firstCurrentNode = firstCurrentNode.next;
            }else{
                mergedList = insertAtEnd(mergedList,secondCurrentNode.data);
                secondCurrentNode = secondCurrentNode.next;
            }

        }

        if(firstCurrentNode != null){
            while(firstCurrentNode != null){
                mergedList = insertAtEnd(mergedList,firstCurrentNode.data);
                firstCurrentNode = firstCurrentNode.next;
            }
        }
        if(secondCurrentNode != null){
            while (secondCurrentNode != null){
                mergedList = insertAtEnd(mergedList,secondCurrentNode.data);
                secondCurrentNode = secondCurrentNode.next;
            }
        }

        return mergedList;

    }

    //Best approach to merge two sorted singly linked list
    public static ListNode mergeLinkedList(ListNode node1, ListNode node2){
        ListNode newNode = new ListNode(0);
        ListNode currentNode = newNode;
        while(node1 != null && node2 != null){
            if(node1.data <= node2.data){
                currentNode.next = node1;
                node1 = node1.next;
            }else{
                currentNode.next = node2;
                node2 = node2.next;
            }
            currentNode = currentNode.next;
        }

        if(node1 != null){
            currentNode.next = node1;
        }
        if(node2 != null){
            currentNode.next = node2;
        }

        return newNode.next;
    }


    public static ListNode insertAtEnd(ListNode head, int data){
        ListNode currentNode = head;
        ListNode newNode = new ListNode(data);
        while(currentNode.next != null){
            currentNode = currentNode.next;
        }
        currentNode.next = newNode;
        return head;
    }

    public static void main(String... s){
        ListNode firstNode = createFirstSortedSinglyLinkedlist();

        ListNode secondNode = createSecondSortedSinglyLinkedlist();

        System.out.println("Merged List is : ");
        ListNode mergedList = mergeLinkedList(firstNode,secondNode);

        ListNode currentNode = mergedList;

        while(currentNode != null){
            System.out.print(currentNode.data + "-->");
            currentNode = currentNode.next;
        }
    }

}
