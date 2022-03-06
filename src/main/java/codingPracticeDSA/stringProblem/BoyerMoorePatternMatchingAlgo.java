package codingPracticeDSA.stringProblem;
//https://www.youtube.com/watch?v=4Oj_ESzSNCk -- Best Video
//https://www.youtube.com/watch?v=G-h1Dph9IOE
import java.util.HashMap;

public class BoyerMoorePatternMatchingAlgo {

    public static void main(String... s){
        BoyerMoorePatternMatchingAlgo boyerMoorePatternMatchingAlgo = new BoyerMoorePatternMatchingAlgo();
        System.out.println("First Matching Index : "+boyerMoorePatternMatchingAlgo.findStartMatchingIndex("asdraghavRAGHAVdfdfdfRAGHAV","RAGHAV"));
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
                    if (map.containsKey(target.charAt(i))) { //If we found the key in map, then shift the startIndex according to the Bad match table value
                        startIndex = (startIndex) + map.get(target.charAt(i));
                        break;
                    } else { //If we don't found the key in map, then shift the startIndex, according to "*" key in map
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

    //Bad match table is for traversing the pattern in targer string
    HashMap<Character, Integer> badMatchTable(String pattern){
        HashMap<Character, Integer> map = new HashMap<>();
        //Formula for bad match table index valeu : (length - index - 1)
        int length = pattern.length();
        int i =0;
        char ch = pattern.charAt(length-1); //Last character of pattern
        map.put(ch,length);//last character value in given pattern as a key in map should be length of pattern in map, we will not override it's value
        while(i<pattern.length()){
            int value = (length - i - 1);
            char c = pattern.charAt(i);
            if(c != ch){ //Here we will not override the last pattern char key in map
                map.put(c, value);
            }
            i++;
        }
        if(i == pattern.length()){
            map.put('*',length);
        }
        return map;
    }
}
