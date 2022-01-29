package codingPracticeDSA.arrayProblem.mediumLevel;

import java.util.ArrayList;
import java.util.List;

public class PrintMatrixSpiral {
    public static void main(String... s){
        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        List<Integer> list = printSpiral(arr);

        for(Integer val:list){
            System.out.print(val+" ");
        }


    }

    private static List<Integer> printSpiral(int arr[][]){
        List<Integer> list = new ArrayList<>();
        int left = 0;
        int right = arr.length-1;

        int top = 0;
        int bottom = arr[0].length-1;

        while (true){
            if(left > right)break;
            for(int i=left;i<=right;i++){
               list.add(arr[top][i]);
            }
            top++;

            if(top > bottom)break;
            for(int i=top;i<=bottom;i++){
                list.add(arr[i][right]);
            }
            right--;

            if(left > right)break;
            for(int i = right;i>=left;i--){
                list.add(arr[bottom][i]);
            }
            bottom--;

            if(top > bottom)break;
            for(int i=bottom;i>=top;i--){
                list.add(arr[i][left]);
            }
            left++;
        }
        return list;
    }
}
