package com.example.demo.recurssion;

public class NumberOfWaysInMatrix {
    public static void main(String... str)
    {
        System.out.println("number of ways in m * n matrix :"+findWays(2,5));
    }

    static int findWays(int m , int n)
    {
        if(m==1 || n==1)
        {
            return 1;
        }
        return findWays(m-1,n)+findWays(m,n-1);
    }
}
