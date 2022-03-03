package codingPracticeDSA.stringProblem;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/minimum-window-substring/
public class MinWidowSubString {

    public  static void main(String... s){
        MinWidowSubString minWidowSubString = new MinWidowSubString();
        String requiredSubString = minWidowSubString.minWindow("ADOBECODEBANC","ABC");

        System.out.println("requiredSubString: "+requiredSubString);
    }
    public String minWindow(String s, String t) {
        int requiredFirstIndex = -1;
        int requiredLastIndex = Integer.MAX_VALUE-1;

        Map<Character, Integer> needMap = new HashMap<>();

        for(int i = 0; i<t.length(); i++){
            char c = t.charAt(i);
            needMap.put(c, needMap.getOrDefault(c, 0)+1);
        }

        int count = needMap.size(); // Size of map where key is not zero

        int startWindow = -1;

        for(int endWindow = 0;endWindow<s.length();endWindow++){
            char c1 = s.charAt(endWindow);
            if(needMap.containsKey(c1)){
                needMap.put(c1, needMap.get(c1)-1);
                if(needMap.get(c1) == 0){
                    count--;
                }
                if(count == 0){
                    startWindow++;
                    while(count == 0 && startWindow < endWindow) {
                        char c2 = s.charAt(startWindow);
                        if (needMap.containsKey(c2)) {
                            needMap.put(c2, needMap.get(c2) + 1);

                            if ((int) needMap.get(c2) > 0) {
                                count++;
                            }
                        }

                        if (count > 0) break;

                        startWindow++;
                    }
                    if((requiredLastIndex - requiredFirstIndex) >  (endWindow - startWindow)){
                        requiredFirstIndex = startWindow;
                        requiredLastIndex = endWindow;
                    }

                }

            }
        }
         System.out.println("requiredFirstIndex "+requiredFirstIndex);
         System.out.println("requiredLastIndex "+requiredLastIndex);
        if(requiredFirstIndex == -1) return "";
        return s.substring(requiredFirstIndex, requiredLastIndex+1);
    }
}
