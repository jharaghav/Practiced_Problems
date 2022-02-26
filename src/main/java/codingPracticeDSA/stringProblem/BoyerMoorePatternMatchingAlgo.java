package codingPracticeDSA.stringProblem;
//https://www.youtube.com/watch?v=G-h1Dph9IOE
import java.util.HashMap;

public class BoyerMoorePatternMatchingAlgo {

    public static void main(String... s){
        BoyerMoorePatternMatchingAlgo boyerMoorePatternMatchingAlgo = new BoyerMoorePatternMatchingAlgo();
        System.out.println("First Matching Index : "+boyerMoorePatternMatchingAlgo.findStartMatchingIndex("asdraghdfdfdfRAGHAV","RAGHAV"));
    }

    int findStartMatchingIndex(String target, String pattern){
        HashMap<Character, Integer> map = badMatchTable(pattern);

        int startIndex = 0;

        int endIndex = startIndex + pattern.length() -1;
        while(endIndex < target.length()){
            int i = endIndex;
            int patternLengthIndex = pattern.length()-1;
            while(i>startIndex && patternLengthIndex>0){

                if(target.charAt(i) == pattern.charAt(patternLengthIndex)){
                    i--;
                    patternLengthIndex-- ;
                } else {
                    if (map.containsKey(target.charAt(i))) {
                        startIndex = (startIndex) + map.get(target.charAt(i));
                        break;
                    } else {
                        startIndex = (startIndex ) + map.get('*');
                        break;
                    }
                }
            }

            if(i == startIndex){
                return i;
            }
            endIndex = startIndex + pattern.length() -1;
        }
        return -1;
    }


    HashMap<Character, Integer> badMatchTable(String pattern){
        HashMap<Character, Integer> map = new HashMap<>();
        //Formula for bad match table index valeu : (length - index - 1)
        int length = pattern.length();
        int i =0;
        while(i<pattern.length()){
            int value = (length - i - 1);
            if(i < pattern.length()){
                map.put(pattern.charAt(i++), value);
            }
        }
        if(i == pattern.length()){
            map.put('*',length);
        }
        return map;
    }
}
