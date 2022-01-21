package com.example.codingPractice.bitmanipulation;

public class FirstNonRepeated {

    public static void main(String[] args) {
        //Find non repeated number and all other numbers appearing twice
        int[] arr = {4,5,6,5,6,7,7};
        System.out.println("first non repeated number: "+checkNonRepeated(arr));
    }

    //XOR property => A ^ A = 0, A^0 = A
    static int checkNonRepeated(int[] arr)
    {
        int unique = 0;
        for(int val:arr){
            unique ^=val;
        }
        return unique;

    }

}
