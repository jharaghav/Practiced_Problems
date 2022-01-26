package codingPracticeDSA.stack;

import java.util.EmptyStackException;
public class StackImplementationByLinkedList {
    ListNode top;
    int length;
    public static class ListNode{
        int data;
        ListNode next;

        ListNode(int data){
            this.data = data;
            this.next = null;
        }
    }
    public void push(int data){
        ListNode newNode = new ListNode(data);
        newNode.next = top;
        top = newNode;
        length++;
    }
    public int pop(){
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ListNode tempNode = top;
        top = top.next;
        tempNode.next = null;
        length--;
        return tempNode.data;
    }
    public boolean isEmpty(){
        return length==0;
    }
    public void printStack(ListNode top){
        ListNode currentNode = top;
        System.out.print("TOP --> ");
        while(currentNode != null){
            System.out.print(currentNode.data+"-->");
            currentNode = currentNode.next;
        }
    }
    public static void main(String... s) throws EmptyStackException{
        StackImplementationByLinkedList stackImplementationByLinkedList = new StackImplementationByLinkedList();
        stackImplementationByLinkedList.push(10);
        stackImplementationByLinkedList.push(30);
        stackImplementationByLinkedList.printStack(stackImplementationByLinkedList.top);
        System.out.println("Popped data from stack: "+stackImplementationByLinkedList.pop());
    }
}
