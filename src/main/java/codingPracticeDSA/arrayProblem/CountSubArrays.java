package codingPracticeDSA.arrayProblem;

import java.util.HashMap;
import java.util.Map;

/**
 * Input : arr[] = {1, 0, 0, 1, 0, 1, 1}
 * Output : 8
 * The index range for the 8 sub-arrays are:
 * (0, 1), (2, 3), (0, 3), (3, 4), (4, 5)
 * (2, 5), (0, 5), (1, 6)
 */
public class CountSubArrays {
    public static void main(String... s){
        int arr[] = {1, 0, 0, 1, 0, 1, 1};
        System.out.println("Total SubArrary with equal o and 1 :"+findCountOfSubArrays(arr));
    }

    private static int findCountOfSubArrays(int arr[]){
        HashMap<Integer,Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        for(int i =0;i<arr.length;i++){
            if(arr[i] == 0)arr[i] = -1;
            sum +=arr[i];
            if(sum == 0){
                count++;
            }
            if(map.containsKey(sum)){
                count += map.get(sum);
            }
            if(map.containsKey(sum)){
                map.put(sum,map.get(sum)+1);
            }else{
                map.put(sum,1);
            }
        }
        return count;
    }
}
