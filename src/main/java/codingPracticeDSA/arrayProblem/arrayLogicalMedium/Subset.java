package codingPracticeDSA.arrayProblem.arrayLogicalMedium;

//https://leetcode.com/problems/subsets/submissions/
import java.util.ArrayList;
import java.util.List;

public class Subset {

    public static void main(String... s){
        Subset subset = new Subset();

        List<List<Integer>> requiredList  = subset.subsets(new int[]{1,2,3});
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> input = new ArrayList<>();

        for(int val: nums){
            input.add(val);
        }

        List<Integer> output = new ArrayList<>();
        List<List<Integer>> requiredList = new ArrayList<>();

        findSubset(input, output, requiredList);

        return requiredList;
    }

    void findSubset(List<Integer> input, List<Integer> output, List<List<Integer>> requiredList){
        if(input.size() == 0){
            requiredList.add(output);
            return ;
        }
        // Do not pick
        List<Integer> output1 = new ArrayList<>(output);

        // Pick the item at index 0
        List<Integer> output2 = new ArrayList<>(output);
        output2.add(input.get(0));

        // Get the new reduced Input
        List<Integer> newInput = new ArrayList<>(input);
        newInput.remove(0);

        // call recursively
        findSubset(newInput, output1, requiredList);
        findSubset(newInput, output2, requiredList);

    }
}
