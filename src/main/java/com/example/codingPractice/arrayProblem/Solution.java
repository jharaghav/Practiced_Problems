package com.example.codingPractice.arrayProblem;

public class Solution {
    public static void main(String... str)
    {
        System.out.println("Value "+ peakElement(new int[]{ 6, 1, 15, 19, 9, 13, 12, 6, 7, 2, 10, 4 ,1 ,14 ,11, 14, 14, 13},18));
    }
    // Function to find the peak element
    // arr[]: input array
    // n: size of array a[]
    public static int peakElement(int[] arr,int n)
    {
        //add code here.
        int val = 0;
        if(n==1){
            return 1;
        } else{
            for(int i = 0;i<=n-1;i++)
            {
                if(i==0){
                    if(arr[i]>arr[i+1]) {
                        val = 1;
                        break;}

                }else if(i==(n-1))
                {
                    if(arr[i]>arr[i-1]) {val = 1;
                        break;}

                }else if(arr[i]>arr[i-1] && arr[i]>arr[i+1])
                {
                    val =1;
                    break;
                }
            }
        }

        return val;

    }
}
