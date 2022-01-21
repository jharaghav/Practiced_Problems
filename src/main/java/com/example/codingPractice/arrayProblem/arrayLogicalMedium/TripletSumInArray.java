package com.example.codingPractice.arrayProblem.arrayLogicalMedium;

import java.util.Arrays;

//Given an array arr of size n and an integer X. Find if there's a triplet in the array which sums up to the given integer X.
//
//
//        Example 1:
//
//        Input:
//        n = 6, X = 13
//        arr[] = [1 4 45 6 10 8]
//        Output:
//        1
//        Explanation:
//        The triplet {1, 4, 8} in
//        the array sums up to 13.
public class TripletSumInArray {
    public static void main(String... s){
        System.out.println("Triplet Sum exists: " +find3Numbers(new int[]{10, 4, 5, 90, 120, 80 },6,89));
    }
    public static boolean find3Numbers(int A[], int N, int X)
    {
        Arrays.sort(A);
        for (int i=0; i < N-2; i++)
        {
            int L=i+1, R=N-1;
            while (L < R)
            {
                if (A[L]+A[i]+A[R] == X)
                    return true;
                if (X < A[L]+A[i]+A[R])
                    --R;
                else /** (A[L]+A[i]+A[R] < X) **/
                    ++L;
            }
        }
        return false;
    }

    //Function to find if there exists a triplet in the
    //array A[] which sums up to X.
//    public static boolean find3Numbers(int A[], int n, int X) {
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//        boolean tripletExisted;
//        for(int i = 0;i<n;i++){
//            if(map.containsKey(A[i])){
//                map.put(A[i],map.get(A[i])+1);
//            }else{
//                map.put(A[i],1);
//            }
//        }
//
//        int sum = 0;
//        int requiredSum = 0;
//        for(int i = 0;i<n;i++){
//            if(A[i] >= X){
//                continue;
//            }
//            for(int j = i+1;j<n;j++){
//                if(A[j] >= X){
//                    continue;
//                }
//                sum = A[i] + A[j];
//                requiredSum = X - sum;
//                if(requiredSum == A[i] || requiredSum == A[j])
//                {
//                    if(map.get(requiredSum) == 2){
//                        return true;
//                    }
//                }
//                else if(map.containsKey(requiredSum)){
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
