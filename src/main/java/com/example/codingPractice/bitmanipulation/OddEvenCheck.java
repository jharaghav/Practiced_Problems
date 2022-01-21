package com.example.demo.bitmanipulation;

public class OddEvenCheck {
    public static void main(String[] args) {

        System.out.println("value 5 is: "+checkEvenOrOdd(5));
    }

    //if we AND "&" any number with 1 then it gives the same value such as "A & 1 = A"
    private static String checkEvenOrOdd(int val){
        return ((val & 1) == 1)?"odd":"even";
    }
}
