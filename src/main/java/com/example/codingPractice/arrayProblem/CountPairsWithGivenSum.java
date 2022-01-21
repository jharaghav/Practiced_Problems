package com.example.demo.arrayProblem;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPairsWithGivenSum {

    public static void main(String... s){
        System.out.println("Min SubArray Size "+ getPairsCount(new int[]{1, 5,3, 7, 1,3},4,6));

        System.out.println("Pairs of Array that sum is 6 are : ");
        getPairs(new int[]{1, 5,3, 7, 1,3},4,6);
    }

    private static int getPairsCount(int[] arr, int n, int k) {
        // code here
        int countPairs = 0;
        HashMap<Integer,Integer> map = new HashMap();
        for(int i = 0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        for(int i=0;i<arr.length;i++){
            if(arr[i]>k)continue;
            if(map.containsKey(k-arr[i])){
                countPairs += map.get(k-arr[i]);
            }
            if((k-arr[i])==arr[i]){
                countPairs--;
            }
        }
        return countPairs/2;
    }

    private static void getPairs(int arr[],int n,int k){
        List<String> pairs = new ArrayList();

        Map<Integer,Integer> frequencyCount = new HashMap<>();

        for(int i=0;i<n;i++){
            if(frequencyCount.containsKey(arr[i])){
                frequencyCount.put(arr[i],frequencyCount.get(arr[i])+1);
            }else{
                frequencyCount.put(arr[i],1);
            }
        }

        for(int i = 0;i<n;i++){
            if(frequencyCount.containsKey(k-arr[i])){
                if(!pairs.contains(arr[i] +"-"+(k-arr[i]))){
                    pairs.add(arr[i] +"-"+(k-arr[i]));
                }
            }
        }
        for(String pair:pairs){
            System.out.println(pair);
        }

    }
}
