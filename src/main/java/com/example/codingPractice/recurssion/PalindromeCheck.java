package com.example.demo.recurssion;

public class PalindromeCheck {
    public  static void main(String... s)
    {
        System.out.println("shikha is palindrome : "+ checkPalindrome("shikha"));
    }
    static boolean checkPalindrome(String val)
    {
        if(val.length() == 1)
            return true;
        char arr[] = new char[val.length()];
        for(int i = 0;i<val.length();i++)
        {
            arr[i] = val.charAt(i);
        }
        return recCheck(0,arr.length-1,arr);
    }
    static boolean recCheck(int i,int j, char[] arr)
    {
        if(i == j)
            return true;
        else if(arr[i] == arr[j])
            return recCheck(i+1,j-1,arr);
        else
            return false;
    }
}
