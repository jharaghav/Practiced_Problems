package codingPracticeDSA.linkedList.singlyLinkedList;

public class RotateLinkedList {

    ListNode head;

    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    public static ListNode createSinglyLinkedlist(){
        ListNode first = new ListNode(9);
        ListNode second = new ListNode(1);
        ListNode third = new ListNode(6);
        ListNode fourth = new ListNode(3);

        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = null;

        return first;
    }

    public static void main(String... s) {
        ListNode list = createSinglyLinkedlist();
        ListNode finalList = rotateRight(list, 2);

    }

    public static ListNode rotateRight(ListNode head, int k) {
        if(k == 0) return head;
        ListNode finalNode = head;
        while(k > 0){
            finalNode = rotateByOne(finalNode);
            k--;
        }

        return finalNode;
    }

    static ListNode rotateByOne(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode slowPrev = head;
        ListNode fastCurrent = head.next;
        while(fastCurrent.next != null){
            slowPrev = slowPrev.next;
            fastCurrent = fastCurrent.next;
        }

        ListNode temp = slowPrev.next;

        slowPrev.next = null;

        temp.next = dummyNode.next;

        return temp;
    }
}
