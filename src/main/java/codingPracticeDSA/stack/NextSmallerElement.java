package codingPracticeDSA.stack;

import java.util.Stack;

public class NextSmallerElement {
    public static void main(String... s){
        int arr[] = new int[]{4,8,5,2,25};
        int nextSmallerElement[] = findNextSmallerElement(arr);

        for(int val:nextSmallerElement){
            System.out.println(val);
        }
    }

    static int[] findNextSmallerElement(int arr[]){
        int length = arr.length;
        Stack<Integer> stack = new Stack<>();
        int nextSmaller[] = new int[length];

        //nextSmaller[length-1] = -1;
        //stack.push(arr[length-1]);
        for(int i = length-1;i>=0;i--){
            while(!stack.isEmpty() && stack.peek() > arr[i]){
                stack.pop();
            }

            if(!stack.isEmpty() && stack.peek() < arr[i]){
                nextSmaller[i] = stack.peek();
            }else{
                nextSmaller[i] = -1;
            }

            stack.push(arr[i]);
        }

        return nextSmaller;
    }
}
