package com.example.codingPractice.Algorithms;

public class KadensAlgorithm {
    public static void main(String... s){
        System.out.println("Max subarray sum is "+ findMaxSumSubArray(new int[]{-100,-5,-6,-7,-10,-12},6));
    }

    static int findMaxSumSubArray(int arr[],int n){
        int currentSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for(int i=0;i<n;i++){
            currentSum += arr[i];
            if(currentSum > maxSum){
                maxSum = currentSum;
            }
            if(currentSum <0){
                currentSum = 0;
            }
        }
        return maxSum;
    }
}
