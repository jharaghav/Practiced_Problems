package com.example.codingPractice.arrayProblem.mediumLevel;

import java.util.LinkedList;

//Given an unsorted array Arr of N positive and negative numbers. Your task is to create an array of alternate positive and negative numbers without changing the relative order of positive and negative numbers.
//        Note: Array should start with positive number.
//
//
//        Example 1:
//
//        Input:
//        N = 9
//        Arr[] = {9, 4, -2, -1, 5, 0, -5, -3, 2}
//        Output:
//        9 -2 4 -1 5 -5 0 -3 2
public class AlternatePositiveAndNegativeNumber {

    public static void main(String... s){
        formatGivenArray(new int[]{9, 4, -2, -1, 5, 0, -5, -3, 2},9);
    }

    private static void formatGivenArray(int arr[],int n){
        LinkedList<Integer> positiveList = new LinkedList<>();
        LinkedList<Integer> negativeList = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(arr[i] >=0){
                positiveList.add(arr[i]);
            }else{
                negativeList.add(arr[i]);
            }
        }

        int i=0;int j=0;int k=0;
        while(i<n){
            if(!positiveList.isEmpty() && j<positiveList.size()){
                arr[i++] = positiveList.get(j++);
            }
            if(!negativeList.isEmpty() && k<negativeList.size()){
                arr[i++] = negativeList.get(k++);
            }
        }

        for(int l =0;l<n;l++){
            System.out.print(arr[l]+" ");
        }

    }


}
