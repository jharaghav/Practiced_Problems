package codingPracticeDSA.stack;

import java.util.Stack;

public class NextGreaterElementWithCirculation {
    public static void main(String... s){
        System.out.println("Next Greater Element arrays: ");
        int values[] = findNGE(new int[]{4,7,3,4,8,1});
        for(int val:values){
            System.out.print(val+" ");
        }
    }
    //peek method returns the top element of stack
    // we can fetch the first index from last with (arr[i%n] where n is array length)
    public static int[] findNGE(int []arr){
        Stack<Integer> stack = new Stack<>();
        int values[] = new int[arr.length];
        int n = arr.length;
        for(int i = 2*n-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() <= arr[i%n]){
                stack.pop();
            }
            if(i<n){
                if(stack.isEmpty() == false){
                    values[i] = stack.peek();
                }else{
                    values[i] = -1;
                }
            }
            stack.push(arr[i%n]);
        }
        return values;
    }
}
