package com.example.codingPractice.queue;

public class QueueImplementationThroughLinkedList {
    private ListNode front;
    private ListNode rear;
    private int length;

    public static class ListNode{
        private ListNode next;
        private int data;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }

    /**
     * Enqueue method is to insert the element at Rear Side
     * @param data
     */
    public void enqueue(int data){
        ListNode newNode = new ListNode(data);

        if(front == null && rear == null){
            front = newNode;
            rear = newNode;
        }else{
            rear.next = newNode;
            rear = newNode;
        }
        length++;
    }

    /**
     * Dequeue method is to remove the element from the front side
     * @return
     * @throws Exception
     */
    public int dequeue() throws  Exception{
        if(isEmpty()){
            throw new Exception();
        }
        ListNode temp = front;
        front = front.next;
        temp.next = null;
        length--;
        return temp.data;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public void printQueue(){
        ListNode currentNode = front;
        while(currentNode != null){
            System.out.print(currentNode.data+" -->");
            currentNode = currentNode.next;
        }
    }

    public static void main(String... s)throws Exception{
        QueueImplementationThroughLinkedList queue = new QueueImplementationThroughLinkedList();
        queue.enqueue(30);
        queue.enqueue(12);
        queue.enqueue(25);
        queue.printQueue();
        System.out.println("\nValues after deque");
        queue.dequeue();
        queue.printQueue();

    }
}
