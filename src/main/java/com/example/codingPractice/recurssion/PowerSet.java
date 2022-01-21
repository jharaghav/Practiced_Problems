package com.example.demo.recurssion;

public class PowerSet {

    public static void main(String... str)
    {
        findPowerset("abc",0,"");
    }

    static void findPowerset(String s,int i,String cur)
    {
        if(s.length() == i)
            System.out.println( "powerset : "+cur);
        else {
            findPowerset(s, i + 1, cur + s.charAt(i));
            findPowerset(s, i + 1, cur);
        }
    }
}
