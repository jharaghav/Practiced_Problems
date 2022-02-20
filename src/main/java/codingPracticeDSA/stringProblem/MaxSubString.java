package codingPracticeDSA.stringProblem;

//Split the binary string into substrings with equal number of 0s and 1s
//        Input: str = “0100110101”
//        Output: 4
//        The required substrings are “01”, “0011”, “01” and “01”.
//        Input: str = “0111100010”
//        Output: 3
//
//        Input: str = “0000000000”
//
//        Output: -1

public class MaxSubString {
    public static void main(String... s){
        System.out.println("The required substrings are: ");
        System.out.println(findTotalSubstrings("001100110"));
    }

    static int findTotalSubstrings(String str){
        int count0 = 0;
        int count1 = 0;
        int totalCount = 0;

        for(int i =0;i<str.length();i++){
            if(str.charAt(i) == '0') count0++;

            if(str.charAt(i) == '1') count1++;

            if(count0 == count1) totalCount++;
        }
        return totalCount;
    }
}
