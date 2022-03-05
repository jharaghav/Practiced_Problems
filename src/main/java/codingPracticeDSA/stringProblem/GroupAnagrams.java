package codingPracticeDSA.stringProblem;

import java.util.*;

public class GroupAnagrams {
    public static void main(String... s ){
        String[] strs = {"",""};
        List<List<String>> finalList = new ArrayList<>();

        List<String> listVal = new ArrayList<>();

        Map<String, Integer> hashMap = new HashMap<>();

        for(int i = 0;i<strs.length;i++){
            String val = strs[i];
            hashMap.put(val, findTotalHash(val));
        }

        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
                new LinkedList<>(hashMap.entrySet());

        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });

        // put data from sorted list to hashmap
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            if(!temp.containsKey(aa.getKey())){
                temp.put(aa.getKey(), aa.getValue());
            }else{
                listVal.add(String.valueOf(aa.getKey()));
            }
        }

        int previous = 0;
        int count = 0;
        for(Map.Entry m: temp.entrySet()){
            if(previous == (int)m.getValue() || count == 0){
                listVal.add(String.valueOf(m.getKey()));
                count++;
            } else {
                previous = (int)m.getValue();
                finalList.add(listVal);
                listVal = new ArrayList<>();
                listVal.add(String.valueOf(m.getKey()));
            }
        }

        finalList.add(listVal);

        System.out.println("finalList : "+finalList);

    }

   static int findTotalHash(String val){
        if(val.length() == 1) return 0;
        int hash = 0;
        for(char c: val.toCharArray()){
            hash += Objects.hash(c);
        }

        return hash;
    }
}
