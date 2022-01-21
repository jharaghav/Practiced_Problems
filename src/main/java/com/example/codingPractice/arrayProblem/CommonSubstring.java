package com.example.codingPractice.arrayProblem;

import java.util.*;

public class CommonSubstring {
    public static void main(String... str)
    {
        List l1 = new ArrayList<String>();
        l1.add("abc");
        l1.add("pqr");
        List l2 = new ArrayList<String>();
        l2.add("a");
        l2.add("r");
        commonSubstring(l1,l2);
    }
    public static void commonSubstring(List<String> a, List<String> b){

//        for(int i=0;i<a.size();i++){
//            Map<Character,Integer> map = new HashMap<>();
//            boolean flag = false;
//            String s1 = a.get(i);
//            for(int j = 0 ;j<s1.length();j++)
//            {
//                if(map.containsKey(s1.charAt(j))){
//                    map.put(s1.charAt(j),map.get(s1.charAt(j))+1);
//                }else{
//                    map.put(s1.charAt(j),1);
//                }
//            }
//            String s2 = b.get(i);
//            for(int k=0;k<s2.length();k++)
//            {
//                if(map.containsKey(s2.charAt(k)))
//                {
//                    flag = true;
////                    break;
//                }
//            }
//            System.out.println(map);
//            if(flag)
//            {
//                System.out.println("YES");
//            }else{
//                System.out.println("NO");
//            }
//        }
        for(int i=0;i<a.size();i++)
        {
            boolean flag = false;
            String s1 = a.get(i);
            String s2 = b.get(i);
            for(Character c : s1.toCharArray()){
                if(s2.indexOf(c)>-1){
                    flag = true;
                    break;
                }
            }
            if(flag)
            {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}
