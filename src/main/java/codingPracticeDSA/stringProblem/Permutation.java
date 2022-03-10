package codingPracticeDSA.stringProblem;

//https://www.youtube.com/watch?v=mEBEw_xScsE
//Time Complexity: O(n*n!) Note that there are n! permutations and it requires O(n) time to print a permutation.

//Auxiliary Space: O(r – l)
//https://www.geeksforgeeks.org/write-a-c-program-to-print-all-permutations-of-a-given-string/

//Steps:
//1: we will call the recurssive function, where we pass the given string, firstIndex, and last index such as (str, 0, length-1) as (s, l, r)
//2: If l == r, we found the required permutated string, return it
//3: in for loop, we will traverse the string, from l to r, swapping the left element to all of string indices,
// then we will fix the first position and call the recurssive function, and then we will swap it back as backtracking
//4: we will call these functions inf for loop:
//             s = swap(s,l,i);
//            permute(s,l+1,r);
//            s = swap(s,l,i); //backtrack
public class Permutation {

    String givenString = "abc";
    public static void main(String... s){
        System.out.println("permutation of given string are ");
        Permutation permutation = new Permutation();
        permute(permutation.givenString,0,permutation.givenString.length()-1);
    }

    static void permute(String s, int l, int r){
        if(l == r){
            System.out.println(s);
            return;
        }
        for(int i = l;i<=r;i++){
            s = swap(s,l,i);
            permute(s,l+1,r);
            s = swap(s,l,i); //backtrack
        }
    }

    static String swap(String str, int i ,int j){

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();

//        char values[] = str.toCharArray();
//        char temp = values[j];
//        values[j] = values[i];
//        values[i] = temp;
//        return String.valueOf(values);
    }
}
