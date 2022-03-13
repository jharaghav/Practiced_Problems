package codingPracticeDSA.stringProblem;

//DP problem (Recurssion with Memoization)
//https://leetcode.com/problems/longest-common-subsequence/
//We are allowed to insert  and delete (two operations only)
public class MinOperationToConvert {
    public static void main(String... s){
        String s1 = "heap";
        String s2 = "pea";

        int lcsLength = longestCommonSubsequence(s1, s2);
        System.out.println("lcsLength : "+lcsLength);
        //Here LCS value is : "ea"

        // How we can achieve "ea" from s1
        //By deleting two character 'h' and 'p'

        //How we can get "pea" from LCS string
        //By inserting 'p' at first position

        //Flow like this: [s1 ---Deletion---> lcs string ----Insertion----> s2]

        //Ans would be
        // first for deletion : (s1.length() - lcsLength) : 'h' & 'p'
        // second for insertion : (s2.length() - lcsLength) : "p"

        int requiredMinOperation = (s1.length() - lcsLength) + (s2.length() - lcsLength);

        System.out.println("MinOperationToConvert  :"+ requiredMinOperation);

    }

    static int longestCommonSubsequence(String s1, String s2){
        int row = s1.length();
        int col = s2.length();
        int dp[][] = new int[row][col];
        for(int i =0;i<row;i++){
            for(int j=0;j<col;j++){
                dp[i][j] = -1;
            }
        }
        return lcs(0, 0 , s1, s2, dp);
    }
    static int lcs(int i, int j, String s1, String s2, int dp[][]){
        if(i>= s1.length() || j>= s2.length()) return 0;

        if(dp[i][j] != -1) return dp[i][j];

        if(s1.charAt(i) == s2.charAt(j)){
            return  (1 + lcs(i+1, j+1, s1, s2, dp));
        }else{
            int left = lcs(i+1, j , s1, s2, dp);
            int right = lcs(i, j+1, s1, s2, dp);
            dp[i][j] = Math.max(left, right);
            return dp[i][j];
        }
    }
}
