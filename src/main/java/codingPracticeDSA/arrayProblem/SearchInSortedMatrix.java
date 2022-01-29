package codingPracticeDSA.arrayProblem;

public class SearchInSortedMatrix {

    public static void main(String... s){
        int arr[][] = {{10,20,30,40},{15,25,35,45},{27,29,37,48},{32,33,39,50}};
        searchInMatrix(arr,323,4);
    }

    /**
     *https://www.youtube.com/watch?v=4lATqBxapmc&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=115
     */
    private static void searchInMatrix(int arr[][],int value,int n){
        int i = 0;
        int j = n-1;
        while(i<n && j >=0){
            if(arr[i][j] == value){
                System.out.print("Value found at row,column : "+i+","+j);
                return;
            }
            if(value > arr[i][j]){
                i++;
            }
            else if(value < arr[i][j]){
                j--;
            }
        }
        System.out.println("Value not found ");
    }

}
