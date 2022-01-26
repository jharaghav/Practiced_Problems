package codingPracticeDSA.bitmanipulation;

public class FindNonRepeatedNumber {

    public static void main(String[] args) {
        //Find non repeated number and all other numbers appearing thrice
        int[] arr = {4,5,4,4,6,5,5,6,7,7,7};
        System.out.println("first non repeated number: "+checkNonRepeated(arr));
    }


    static int checkNonRepeated(int[] arr)
    {
        int sum = 0;

        for(int val:arr){
            sum +=val;
        }
        return sum%3;

    }

}

