package codingPracticeDSA.arrayProblem.mediumLevel;

import java.util.HashMap;

//Input:
//        N = 7
//        a[] = {2,6,1,9,4,5,3}
//        Output:
//        6
//        Explanation:
//        The consecutive numbers here
//        are 1, 2, 3, 4, 5, 6. These 6
//        numbers form the longest consecutive
//        subsquence.
public class LongestConsecutiveSubsequence {

    public static void main(String... s){
        System.out.println("length of longest subsequence is "+findLongestConseqSubseq(new int[]{10, 20, 21, 22, 23},5));
    }

    //Function to return length of longest subsequence of consecutive integers.
    static int findLongestConseqSubseq(int arr[], int N)
    {
        int currMax = 0;
        int longest = 0;
        HashMap<Integer,Integer> hm= new HashMap<Integer,Integer>();
        for(int i:arr){
            if(hm.containsKey(i))
                hm.put(i,hm.get(i)+1);
            else
                hm.put(i,1);
        }
        for(int i:arr){
            if(hm.containsKey(i-1))
                continue;
            int key = i;
            while(hm.containsKey(key)){
                currMax++;
                key++;
            }
            longest = Math.max(currMax,longest);
            currMax=0;
        }
        return longest;
    }
}
