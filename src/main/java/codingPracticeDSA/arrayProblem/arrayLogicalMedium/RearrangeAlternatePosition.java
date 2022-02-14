package codingPracticeDSA.arrayProblem.arrayLogicalMedium;

/**
 * https://www.youtube.com/watch?v=5MeI5Kk8KTQ
 *
 * Given an array of positive and negative numbers, arrange them in an alternate fashion
 * such that every negative number is followed by positive and vice-versa maintaining the order of appearance.
 *
 * Rearrange array in alternating negative & positive items with O(1) extra space
 *
 * Brefore Rearrangement of the Arrays values
 * INPUT : -5 ==> 1 ==> 2 ==> 3 ==> 10 ==> 11 ==> -4 ==> 5 ==> -2 ==>
 * After Rearranged the Arrays values with Negative and Positive alternate Values
 * OUTPUT: -5 ==> 1 ==> -4 ==> 2 ==> -2 ==> 3 ==> 10 ==> 11 ==> 5 ==>
 *
 *
 *  step 1: {-5,1,2,3,10,11,-4,5,-2}
 *  step 2: {-5,1,-4,2,3,10,11,5,-2}
 *  step 3: {-5,1,-4,2,-2,3,10,11,5}
 */

//Time Complexity O(N) space Complexity O(1)
public class RearrangeAlternatePosition {
    public static void main(String... s){
        int arr[] = new int[]{-5,1,2,3,10,11,-4,5,-2};
        System.out.println("Brefore Rearrangement of the Arrays values");
        for(int val:arr){
            System.out.print(val +" ==> ");
        }
        System.out.println("\nAfter Rearranged the Arrays values with Negative and Positive alternate Values ");
        int values[] = findReArrangedArray(arr,arr.length);
        for(int val:values){
            System.out.print(val +" ==> ");
        }
    }

    static int[] findReArrangedArray(int []arr,int n){
        int wrongIndex = -1;

        for(int i =0;i<n;i++){
            if(wrongIndex != -1){
                if((arr[wrongIndex] >= 0 && arr[i] < 0) || (arr[wrongIndex] < 0 && arr[i] >= 0)){// Here we are trying to find out the opposite value of wrongIndex value
                    // If wrongIndex value is negative, then we are trying to find out first positive after the wrongIndex,
                    // If wrongIndex value is positive, then we are trying to find out first negative after the wrongIndex
                    rightRotate(arr,wrongIndex,i);
                    // the new wrongIndex entry is now 2 steps ahead
                    if(i - wrongIndex >= 2){
                        wrongIndex = wrongIndex +2;
                    }else{
                        wrongIndex = -1;
                    }
                }
            }else{
                if((arr[i] <= 0 && i%2 == 1) ||(arr[i] > 0 && i%2 == 0)){ // checking the conditions,
                    // such as wronIndex will be the index value which does not satisfy the alternate sequence
                    // at odd index, values should be negative and at even index values should be positive
                    // negative, positive, negative -----------
                    wrongIndex = i;
                }
            }
        }
        return arr;
    }

    /**
     * Here we are trying to rotate the array values from wrongIndex to the required value index
     */
    static void rightRotate(int []arr,int from, int to){
        int temp = arr[to];
        for(int i=to;i>from;i--){
            arr[i] = arr[i-1];
        }
        arr[from]  = temp;
    }
}
