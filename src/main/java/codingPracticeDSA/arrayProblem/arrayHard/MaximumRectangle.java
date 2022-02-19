package codingPracticeDSA.arrayProblem.arrayHard;
//https://leetcode.com/problems/largest-rectangle-in-histogram/
//https://www.youtube.com/watch?v=oaN9ibZKMpA

import java.util.Stack;

public class MaximumRectangle{

    public static void main(String... s){
        char matrix[][] = {{ '0','1'}};
        MaximumRectangle maximumRectangle = new MaximumRectangle();
        maximumRectangle.maximalRectangle(matrix);
    }
    public int maximalRectangle(char[][] givenMatrix) {

        int row = givenMatrix.length;
        int column = givenMatrix[0].length;


        int matrix[][] = new int[row][column];
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(givenMatrix[i][j] == '0'){
                    matrix[i][j] = 0;
                }else{
                    matrix[i][j] = 1;
                }
                System.out.print(matrix[i][j]);
            }
        }

        // if(row == 1 && column == 1 && matrix[0][0] == 1) return 1;
        // if(row == 1 && column == 1 && matrix[0][0] == 0) return 0;
        int currentRow[] = matrix[0];
        int currentArea = maxHistogram(currentRow);
        int maxArea = 0;
        for(int i = 1;i<row;i++){
            for(int j = 0;j<column;j++){
                if(matrix[i][j] == 1){
                    currentRow[j] += 1;
                }else{
                    currentRow[j] = 0;
                }
            }

            currentArea = maxHistogram(currentRow);
            System.out.print("\ncurrentArea "+currentArea);
            maxArea = Math.max(maxArea, currentArea);
        }
        return Math.max(maxArea, currentArea);
    }

    int maxHistogram(int heights[]){
        int n = heights.length;
        int prevSmaller[] = prevSmaller(heights,n);
        int nextSmaller[] = nextSmaller(heights,n);

        // System.out.println("n "+n);
        // for(int pre:prevSmaller){
        //     System.out.println("prevSmaller "+pre);
        // }

        // for(int pre:nextSmaller){
        //     System.out.println("nextSmaller "+pre);
        // }
        int currentArea = 0;
        int area = 0;
        System.out.println("n  "+n);
        for(int i =0;i<n;i++){
            currentArea = (nextSmaller[i] - prevSmaller[i] - 1)*heights[i];
            System.out.println("currentArea  "+currentArea);
            area = Math.max(area, currentArea);
        }
        return area;
    }

    int[] prevSmaller(int heights[],int n){
        int prevSmaller[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i =0;i<n;i++){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }

            if(stack.isEmpty()){
                prevSmaller[i] = -1;
            }else{
                prevSmaller[i] = (int)stack.peek();
            }
            stack.push(i);
        }
        return prevSmaller;
    }

    int[] nextSmaller(int heights[], int n){
        int nextSmaller[] = new int[n];

        Stack<Integer> stack = new Stack<>();

        for(int i=n-1;i>=0;i--){
            while(!stack.isEmpty() && heights[stack.peek()] >= heights[i]){
                stack.pop();
            }
            if(stack.isEmpty()){
                nextSmaller[i] = n;
            }else{
                nextSmaller[i] = (int)stack.peek();
            }
            stack.push(i);
        }
        return nextSmaller;
    }
}
