package com.example.codingPractice.stringProblem;

//Given a list of words followed by two words, the task to find the minimum distance between the given two words in the list of words
//
//
//        Example 1:
//
//        Input:
//        S = { "the", "quick", "brown", "fox",
//        "quick"}
//        word1 = "the"
//        word2 = "fox"
//        Output: 3
//        Explanation: Minimum distance between the
//        words "the" and "fox" is 3
import java.util.ArrayList;

public class ClosestStrings {
    public static void main(String... str)
    {
        ArrayList<String>  list = new ArrayList<>();
        list.add("the");
        list.add("quick");
        list.add("brown");
        list.add("fox");
        list.add("quick");
        int val = shortestDistance(list,"the","fox");
        System.out.println("value "+val);
    }

    static int shortestDistance(ArrayList<String> s, String word1, String word2) {
        int firstIndex = 0;
        int secondIndex = s.size() - 1;
        int min = Integer.MAX_VALUE;
        boolean firstWordRepeat = false;
        for (int i = 0; i < s.size(); i++) {
            if (s.get(i).equals(word1)) {
                firstIndex = i;
                min = Math.min(min, Math.abs(secondIndex - firstIndex));

            }
            if (s.get(i).equals(word2)) {
                secondIndex = i;
                min = Math.min(min, Math.abs(secondIndex - firstIndex));
            }
        }

        return min;
    }

}
