package codingPracticeDSA.stack;

import java.util.Stack;

/**
 * Input:  [2, 5, 3, 7, 8, 1, 9]
 * Output: [-1, 2, 2, 3, 7, -1, 1]
 *
 *
 * Input:  [5, 7, 4, 9, 8, 10]
 * Output: [-1, 5, -1, 4, 4, 8]
 */
public class PreviousSmallerElement {
    public static void main(String... s){
        System.out.println("Previous smaller element : ");
        PreviousSmallerElement previousSmallerElement = new PreviousSmallerElement();
        int values[] = previousSmallerElement.previousSmallerElement(new int[]{5, 7, 4, 9, 8, 10});
        for(int val:values){
            System.out.print(val+" ");
        }
    }

    public int[] previousSmallerElement(int[] givenArray){
        int n = givenArray.length;
        Stack<Integer> stack = new Stack<>();
        int pse[] = new int[n];

        for(int i=0;i<n;i++){
            while(!stack.isEmpty() && stack.peek() >= givenArray[i]){
                stack.pop();
            }
            if(i<n){
                if(!stack.isEmpty()){
                    pse[i] = stack.peek();
                }else{
                    pse[i] = -1;
                }
            }
            stack.push(givenArray[i]);
        }

        return pse;

    }
}
