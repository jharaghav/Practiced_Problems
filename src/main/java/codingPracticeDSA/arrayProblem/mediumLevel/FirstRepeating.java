package codingPracticeDSA.arrayProblem.mediumLevel;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeating {

    public static void main(String... s){
        System.out.println("First Non repeating Element index is:  "+firstRepeated(new int[]{7, 4, 0, 9, 4, 8, 8, 2, 4, 5, 5, 1},12));
    }
    public static int firstRepeated(int[] arr, int n) {
        // Your code here

        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                map.put(arr[i],map.get(arr[i])+1);
            }else{
                map.put(arr[i],1);
            }
        }
        int index = 1;

        for(Map.Entry mapElement:map.entrySet()){
            if((int)mapElement.getValue()>1){
                return index;
            }
            index++;
        }
        return -1;
    }
}
