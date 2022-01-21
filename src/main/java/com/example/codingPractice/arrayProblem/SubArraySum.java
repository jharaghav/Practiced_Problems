package com.example.codingPractice.arrayProblem;
//Sliding window problem
import java.util.ArrayList;
//        N = 5, S = 12
//        A[] = {1,2,3,7,5}
//        Output: 2 4
//        Explanation: The sum of elements
//        from 2nd position to 4th position
//        is 12.
public class SubArraySum {

   public static void main(String... s){
       System.out.println("position of elements for which the sum is equals to given sum : "+subarraySum(new int[]{1,2,3,7,5},5,12));
   }

    //Function to find a continuous sub-array which adds up to a given number.
    static ArrayList<Integer> subarraySum(int[] arr, int n, int s)
    {
        int startWindow = 0;
        int currentWindowSum = 0;
        ArrayList<Integer> arrList = new ArrayList<>();

        for(int endWindow = 0;endWindow < n;endWindow++){
            currentWindowSum += arr[endWindow];
            while(currentWindowSum >= s){
                if(currentWindowSum == s){
                    arrList.add(startWindow+1);
                    arrList.add(endWindow+1);
                    return arrList;
                }
                currentWindowSum -= arr[startWindow];
                startWindow++;
            }
        }
        arrList.add(-1);
        return arrList;
    }
}
