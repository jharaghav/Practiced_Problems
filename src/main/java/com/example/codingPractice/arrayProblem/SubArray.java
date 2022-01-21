package com.example.demo.arrayProblem;

public class SubArray {

    public static void main(String... str)
    {
        System.out.println("SubArray Exists "+ findSubArray(new int[]{ 6, 1, 15, 3,1, 9 },22));
    }

    //naive approach
    private static boolean findSubArray(int arr[],int sumRequired){
        boolean subArrayPresent;
        int sum = 0;
        for(int i=0;i<arr.length;i++){
            sum = arr[i];
            for(int j= i+1;j<arr.length;j++){
                if(sum == sumRequired){
                    System.out.println("SubArray first Index " +i+" Last index "+(j-1));
                    return true;
                }
                if(sum > sumRequired || j == arr.length){
                    break;
                }
                sum += arr[j];
            }
        }
        return false;
    }
}
