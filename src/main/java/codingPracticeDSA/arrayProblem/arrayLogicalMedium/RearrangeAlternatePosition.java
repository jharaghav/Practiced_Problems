package codingPracticeDSA.arrayProblem.arrayLogicalMedium;

/**
 * https://www.youtube.com/watch?v=5MeI5Kk8KTQ
 *
 * Given an array of positive and negative numbers, arrange them in an alternate fashion
 * such that every positive number is followed by negative and vice-versa maintaining the order of appearance.
 *
 * Rearrange array in alternating positive & negative items with O(1) extra space
 *
 * input : {-5,1,2,3,-4,5,-2}
 * output: 1 ==> -5 ==> 2 ==> -4 ==> 3 ==> -2 ==> 5 ==>
 *
 */
public class RearrangeAlternatePosition {
    public static void main(String... s){
        int arr[] = new int[]{-5,1,2,3,-4,5,-2};
        System.out.println("After Rearranged the Arrays values with Negative and Positive alternate Values ");
        int values[] = findReArrangedArray(arr,arr.length);
        for(int val:values){
            System.out.print(val +" ==> ");
        }
    }

    static int[] findReArrangedArray(int []arr,int n){
        int wrongIndex = -1;

        for(int i =0;i<n;i++){
            if(wrongIndex != -1){
                if((arr[wrongIndex] >= 0 && arr[i] < 0) || (arr[wrongIndex] < 0 && arr[i] >= 0)){
                    rightRotate(arr,wrongIndex,i);
                    if(i - wrongIndex >= 2){
                        wrongIndex = wrongIndex +2;
                    }else{
                        wrongIndex = -1;
                    }
                }
            }else{
                if((arr[i] > 0 && i%2 == 1) ||(arr[i] <= 0 && i%2 == 0)){
                    wrongIndex = i;
                }
            }
        }
        return arr;
    }

    static void rightRotate(int []arr,int from, int to){
        int temp = arr[to];
        for(int i=to;i>from;i--){
            arr[i] = arr[i-1];
        }
        arr[from]  = temp;
    }
}
