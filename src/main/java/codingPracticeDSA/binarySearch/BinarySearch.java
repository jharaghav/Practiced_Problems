package codingPracticeDSA.binarySearch;

public class BinarySearch {

    public static void main(String... s){
        int arr[] = {4,7,10,15,22,50,55,60};
        System.out.println("Value found in the given array or not : "+binarySearch(arr,500,0,7));
    }
    private static boolean binarySearch(int[] arr, int key,int low,int high){
        if(low<high){
            if(arr[low] == key || arr[high] == key){
                return true;
            }
            int med = (low+high)/2;
            if(arr[med] == key)return true;
            if(key<arr[med]){
                return  binarySearch(arr,key,low,med-1);
            }else{
                return binarySearch(arr,key,med+1,high);
            }
        }
        return false;
    }

}
