package com.example.codingPractice.arrayProblem.arrayLogicalMedium;

//Given a sorted array arr[] of distinct integers. Sort the array into a wave-like array and return it
//        In other words, arrange the elements into a sequence such that arr[1] >= arr[2] <= arr[3] >= arr[4] <= arr[5].....
//
//        Example 1:
//
//        Input:
//        n = 5
//        arr[] = {1,2,3,4,5}
//        Output: 2 1 4 3 5
//        Explanation: Array elements after
//        sorting it in wave form are
//        2 1 4 3 5.
public class WaveArray {

    public static void main(String... s){
        convertToWave(new int[]{1,2,3,4,5},5);
    }

    // arr: input array
    // n: size of the array
    //Function to sort the array into a wave-like array.
//    public static void convertToWave(int arr[], int n){
//
//        int arr1[] = new int[n];
//        int arr2[] = new int[n];
//        int arrayFirstSize;
//        int count = 0;
//        for(int i = 1;i<n;i=i+2){
//            arr1[count] = arr[i];
//            count++;
//        }
//        arrayFirstSize = count;
//        int arraySecondSize;
//        count = 0;
//        for(int i=0;i<n;i=i+2){
//            arr2[count] = arr[i];
//            count++;
//        }
//        arraySecondSize = count;
//        int p =0;
//        int q=0;
//
//        for(int i=0;i<n;i++){
//            if(i % 2 == 0 && p<arrayFirstSize){
//                arr[i] = arr1[p];
//                p++;
//            }else if(q<arraySecondSize){
//                arr[i] = arr2[q];
//                q++;
//            }
//        }
//
//    }

    public static void convertToWave(int arr[], int n){
        int k;
        if(n%2==0){
            for(int i=0; i<n-1; i=i+2){
                k=arr[i];
                arr[i]=arr[i+1];
                arr[i+1]=k;
            }
        }
        else{
            for(int i=1; i<n-1; i=i+2){
                k=arr[i]    ;
                arr[i]=arr[i-1];
                arr[i-1]=k;
            }

        }

    }

}
