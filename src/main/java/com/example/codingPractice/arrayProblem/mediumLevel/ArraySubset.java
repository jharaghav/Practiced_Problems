package com.example.codingPractice.arrayProblem.mediumLevel;

import java.util.ArrayList;

public class ArraySubset {
    public static void main(String... s){
        System.out.println("Array 2 is Subset of Array 1 :  "+isSubset(new long[]{11, 1, 13, 21, 3, 7},new long[]{11, 3, 7, 1},6,4));
    }
    public static String isSubset( long a1[], long a2[], long n, long m) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0;i<a1.length;i++){
            list.add(Integer.valueOf((int)a1[i]));
        }

        for(int i=0;i<a2.length;i++){
            if(!list.contains(Integer.valueOf((int)a2[i])))
            {
                return "No";
            }
        }
        return "Yes";

    }
}
