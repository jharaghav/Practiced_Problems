package codingPracticeDSA.arrayProblem.arrayLogicalMedium;

/**
 * https://www.youtube.com/watch?v=ijKmiFqjzi4&t=4107s
 */
public class MinimumDiffAmongThreeSortedArrays {

    public static void main(String... s){
        int A[] = {1,4,5,8,10,14};
        int B[] = {6,9,14,15};
        int C[] = {2,3,6,6,15};
        requiredThreeNumbers(A,B,C);
    }

    public static void requiredThreeNumbers(int A[],int B[],int C[]){
        int a=0,b=0,c=0;
        int requiredMinimum = Integer.MAX_VALUE;

        int startFirst = 0;
        int startSecond = 0;
        int startThird = 0;

        while(startFirst < A.length && startSecond < B.length && startThird < C.length){
            int min = min(A[startFirst],B[startSecond],C[startThird]);
            int max = max(A[startFirst],B[startSecond],C[startThird]);
            int minusValue = Math.abs(max-min);
            if(requiredMinimum > minusValue) {
                requiredMinimum = minusValue;
                a = A[startFirst];
                b = B[startSecond];
                c= C[startThird];
            }

            if(A[startFirst] == min) startFirst++;
            else if(B[startSecond] == min) startSecond++;
            else startThird++;
        }
        System.out.println("values are "+a+" : "+b+" : "+c+" ");

    }

    public static int min(int a,int b,int c){
        if(a<=b && a<=c) return a;
        else if(b<=a && b<=c) return b;
        else return c;
    }

    public static int max(int a,int b,int c){
        if(a>=b && a>=c) return a;
        else if(b>=a && b>=c) return b;
        else return c;
    }

}
