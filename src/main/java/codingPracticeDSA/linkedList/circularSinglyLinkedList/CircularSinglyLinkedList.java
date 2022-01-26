package codingPracticeDSA.linkedList.circularSinglyLinkedList;

public class CircularSinglyLinkedList {
    ListNode last;

    public static class ListNode{
        int data;
        ListNode next;

        public ListNode(int data){
            this.data = data;
        }
    }

    public ListNode insertAtEnd(int data,ListNode last){
        ListNode newNode = new ListNode(data);
        newNode.next = newNode;
        if(last == null){
            last = newNode;
            newNode.next = last;
        }else{
            newNode.next = last.next;
            last.next = newNode;
        }
        return last;
    }

    public ListNode createCircularList(){
        ListNode first = new ListNode(10);
        ListNode second = new ListNode(25);
        ListNode third = new ListNode(30);
        ListNode fourth = new ListNode(40);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = first;
        this.last = fourth;
        return last;
    }

    public void printCircularList(ListNode last){
        ListNode currentNode = last;

        while(currentNode.next != last){
            System.out.print(currentNode.data + "-->");
            currentNode = currentNode.next;
        }
        System.out.print(currentNode.data + "-->");
    }

    public static void main(String... s){
        CircularSinglyLinkedList circularSinglyLinkedList = new CircularSinglyLinkedList();

        ListNode newList = circularSinglyLinkedList.createCircularList();
            ListNode first = new ListNode(10);
//            first.next = first;
        ListNode second = circularSinglyLinkedList.insertAtEnd(11,first);
        ListNode third = circularSinglyLinkedList.insertAtEnd(30,second);
        //ListNode createdCircularLinkedList =
        circularSinglyLinkedList.printCircularList(third);
    }
}
