package com.example.codingPractice.arrayProblem;
//Sliding window technique
//Dynamic variant. Smallest subarray with given sum.
public class MinSubArraySize {

    public static void main(String... s){
        System.out.println("Min SubArray Size "+ minSubArraySize(new int[]{4,2,2,7,1,2},8));
    }

    public static int minSubArraySize(int[] arr,int targetSum){
        int windowStart = 0;
        int currentWindowSum = 0;
        int minSubArraySize = Integer.MAX_VALUE;
        for(int windowEnd = 0;windowEnd<arr.length;windowEnd++){
            currentWindowSum += arr[windowEnd];
            //check the min subArray Size
            while(currentWindowSum >= targetSum){
                minSubArraySize = Math.min(minSubArraySize,windowEnd - windowStart +1);
                currentWindowSum = currentWindowSum - arr[windowStart];
                windowStart++;
            }
        }
        return minSubArraySize;
    }
}
