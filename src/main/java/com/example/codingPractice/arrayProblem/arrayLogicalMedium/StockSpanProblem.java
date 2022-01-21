package com.example.demo.arrayProblem.arrayLogicalMedium;

//The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days.
//        The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
//        For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.
//
//        Example 1:
//
//        Input:
//        N = 7, price[] = [100 80 60 70 60 75 85]
//        Output:
//        1 1 1 2 1 4 6
//        Explanation:
//        Traversing the given input span for 100
//        will be 1, 80 is smaller than 100 so the
//        span is 1, 60 is smaller than 80 so the
//        span is 1, 70 is greater than 60 so the
//        span is 2 and so on. Hence the output will
//        be 1 1 1 2 1 4 6.
import java.util.Stack;

//https://www.youtube.com/watch?v=-IFmgue8sF0
public class StockSpanProblem {

    public static void main(String... s){
        System.out.println(calculateSpan(new int[]{10, 4, 5, 90, 120, 80 },6));
    }
    //Function to calculate the span of stock price for all n days.
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> s = new Stack<>();
        int span[] = new int[n];

        s.push(0);
        span[0] = 1;

        for(int i= 1;i<n;i++){
            // Pop elements from stack while stack is not
            // empty and top of stack is smaller than
            // price[i]
            while(!s.isEmpty() && price[s.peek()] <= price[i]){
                s.pop();
            }
            // If stack becomes empty, then price[i] is
            // greater than all elements on left of it,
            // i.e., price[0], price[1], ..price[i-1]. Else
            // price[i] is greater than elements after
            // top of stack
            span[i] = (s.isEmpty()) ? (i + 1) : (i - s.peek());

            // Push this element to stack
            s.push(i);
        }
        return span;
    }
}
