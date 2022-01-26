package codingPracticeDSA.arrayProblem;
//
//Input:
//        N = 5
//        A[] = {1,2,3,5}
//        Output: 4
public class MissingNumber {
    public static void main(String... s){
        System.out.println("Missing Number is "+findMissingNumber(new int[]{1,3,5,2},5));
    }
    private static int findMissingNumber(int arr[],int n){
        int missingValue =0;
        int totalSum = Integer.valueOf(n*(n+1)/2);

        int givenSum = 0;
        for(int i=0;i<arr.length;i++){
            givenSum +=arr[i];
        }
        missingValue = totalSum - givenSum;
        return missingValue;
    }
}
