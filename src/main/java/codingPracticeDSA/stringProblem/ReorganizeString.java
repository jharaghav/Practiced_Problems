package codingPracticeDSA.stringProblem;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ReorganizeString {
    public static void main(String... s){
        ReorganizeString reorganizeString = new ReorganizeString();
        String val = reorganizeString.reorganizeString("ogccckcwmbmxtsbmozli");
        System.out.println(val);
    }
    public String reorganizeString(String s) {

        int length = s.length();
        Map<Character, Integer> freqMap = new HashMap<>();

        for(int i =0;i<length;i++){
            char c = s.charAt(i);
            int count  = freqMap.getOrDefault(c, 0)+1;
            freqMap.put(c, count);
            if(count > (length+1)/2) return "";//max value entry is present on the tail side of priority queue
        }

        // push all map entry into priority element, by sorting from high frequency to low frequency
        PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>(
                (a, b) -> (b.getValue() - a.getValue())
        );
        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            priorityQueue.offer(entry);
        }

        StringBuilder sb = new StringBuilder(s);
        //int requiredLength = length;

        int carry = 0;
        char carrycharacter = 'a';
        int i =0;
        while(priorityQueue.size() != 0){
            Map.Entry entry = priorityQueue.poll();
            int count = (int)entry.getValue();
            //this is for storing the character at even positions
            while(i<length){
                char c = (char)entry.getKey();
                sb.setCharAt(i, c);
                count--;
                i = i+2;
                if(count == 0) break;
            }

            if(count > 0){
                carry = count;
                carrycharacter = (char)entry.getKey();
                break;
            }
        }

        //Storing the remaining carryCharacter count values at odd position
        int posOdd = 1;
        if(carry != 0){
            int j = posOdd;
            while (j<length){
                sb.setCharAt(j, carrycharacter);
                carry--;
                j= j+2;
                posOdd = j;
                if(carry == 0) break;
            }
        }

        //Once the remaining carryCharacter is filled in the required string at odd position, then we will poll the queue for storing all other characters at the remainaing odd positions
        int m = posOdd;
        while(priorityQueue.size() != 0){
            Map.Entry entry = priorityQueue.poll();
            int count = (int)entry.getValue();

            //this is for storing the character at remaining odd positions
            while(m<length){
                char c = (char)entry.getKey();
                sb.setCharAt(m, c);
                count--;
                m = m+2;
                if(count == 0) break;
            }
        }
        return sb.toString();
    }
}
