package codingPracticeDSA.stack;

import java.util.Stack;

public class NextGreaterElementWithoutCirculation {
    public static void main(String... s){
        System.out.println("Next Greater Element arrays: ");
        int values[] = findNGE(new int[]{4,7,3,4,8,1});
        for(int val:values){
            System.out.print(val+" ");
        }
    }
    //peek method returns the top element of stack
    public static int[] findNGE(int []arr){
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int values[] = new int[n];
        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty() == false){
                    values[i] = stack.peek();
                }else{
                    values[i] = -1;
                }
            }
            stack.push(arr[i]);
        }
        return values;
    }
}
