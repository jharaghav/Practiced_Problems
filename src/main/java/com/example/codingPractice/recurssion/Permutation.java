package com.example.demo.recurssion;

public class Permutation {
    public static void main(String... str)
    {
        permute("pqrs",0,3);
    }

    static void permute(String s,int l,int r)
    {
        if(l==r)
        {
            System.out.println(s);
            return;
        }
        for(int i=l;i<=r;i++)
        {
            s = swap(s,l,i);
            permute(s,l+1,r);
            s = swap(s,l,i);
        }
    }

    static String swap(String s,int l,int i)
    {
        StringBuilder sb = new StringBuilder(s);
        char temp = sb.charAt(l);
        sb.setCharAt(l,sb.charAt(i));
        sb.setCharAt(i,temp);
        return sb.toString();
    }
}
