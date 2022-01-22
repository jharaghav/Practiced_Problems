package com.example.codingPractice.stack;

import java.util.EmptyStackException;

/**
 * reverse the string with the help of stack
 */
public class StringReverseThroughStack {
    ListNode top;
    int length;
    public static class ListNode{
        String data;
        ListNode next;

        public ListNode(String data){
            this.data = data;
            this.next = null;
        }
    }

    public void push(String data){
        ListNode newNode = new ListNode(data);

        if(top == null){
            top = newNode;
        }
        else{
            newNode.next = top;
            top = newNode;
        }
        length++;

    }

    public String pop() {
        if(isEmpty()){
            throw new EmptyStackException();
        }
        ListNode temp = top;
        String val = top.data;
        top = temp.next;
        temp.next = null;
        length--;
        return val;
    }


    public boolean isEmpty(){
        return length==0;
    }

    public static void main(String... s){
        String val = "my name is raghav";

        String vals[] = val.split(" ");


        StringReverseThroughStack stringReverseThroughStack = new StringReverseThroughStack();
        for(String value:vals){
            stringReverseThroughStack.push(value);
        }

        StringBuilder stringBuilder = new StringBuilder();

        while(stringReverseThroughStack.length != 0){
            stringBuilder.append(stringReverseThroughStack.pop());
            stringBuilder.append(" ");
        }

        System.out.println(stringBuilder);

    }
}
