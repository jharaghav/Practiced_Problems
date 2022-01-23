package com.example.codingPractice.queue;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Generate Binary numbers from 1 to n using a Queue
 */
public class GenerateBinaryNumbers {

    public static void main(String... s){
        GenerateBinaryNumbers generateBinaryNumbers = new GenerateBinaryNumbers();
        String values[] = generateBinaryNumbers.generateBinaryNumbers(4);
        System.out.println("Required Binary values ");
        for(String val:values){
            System.out.print(val+" ");
        }
    }

    /**
     * poll() method is for remove the element from the front side
     * offer(element) method is for inserting the element at the rear side
     *
     */
    public String[] generateBinaryNumbers(int n){
        String result[] = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for(int i =0;i<n;i++){
            result[i] = queue.poll();
            String n1 = result[i]+"0";
            String n2 = result[i]+"1";
            queue.offer(n1);
            queue.offer(n2);
        }
        return result;
    }
}
