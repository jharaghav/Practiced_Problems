package codingPracticeDSA.dynamicProgramming;

public class CoinChangeRecurssion {

    public static void main(String... s){
        int n = 18;
        int a[] = {1,19,245};
        System.out.print( "Required minimum coins needed  "+ minCoins(n, a));
    }

    static int minCoins(int n, int a[]){

        if(n==0) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i= 0;i<a.length;i++){
            if(n-a[i] >= 0) {
                int subAns = minCoins(n - a[i], a);
//                if(subAns != Integer.MAX_VALUE && subAns+1< ans){
//                    ans = subAns +1;
//                }
                ans = Math.min(ans, subAns+1);
            }
        }
        return ans;
    }
}
