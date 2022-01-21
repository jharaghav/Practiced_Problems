package com.example.codingPractice.arrayProblem.mediumLevel;
//Given an array Arr[] that contains N integers (may be positive, negative or zero). Find the product of the maximum product subarray.
//
//
//        Input:
//        N = 5
//        Arr[] = {6, -3, -10, 0, 2}
//        Output: 180
//        Explanation: Subarray with maximum product
//        is [6, -3, -10] which gives product as 180.
public class MaxProductSubArray {

    public static void main(String... s){
        System.out.println("Max Product Sub Array value is "+maxProduct(new int[]{6, -3, -10, 0, 2},5));
    }

    private  static long maxProduct(int[] arr, int n) {
        // code here
        if(arr.length == 1){
            return arr[0];
        }else{
            long maxProduct = arr[0];

            long product = 1;

            for(int i =0;i<n;i++){
                product *= arr[i];
                if(maxProduct < product){
                    maxProduct = product;
                }
                if(product == 0){
                    product = 1;
                }
            }
            product = 1;

            for(int i=n-1;i>=0;i--){
                product *= arr[i];
                maxProduct = Math.max(maxProduct,product);
                if(product == 0){
                    product =1;
                }
            }

            return maxProduct;
        }

    }
}
