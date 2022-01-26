package codingPracticeDSA.arrayProblem.mediumLevel;

public class QuickSort {

    public static void main(String... s)
    {
        int[] arr = new int[]{2,13,1,8,3,10,9};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low<high){
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
    }
//this is tricky one
    private static int partition(int[] arr,int low,int high){
        int pivot = arr[high];
        int i = low -1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }
//swapping the ith index element with jth index element
    private static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
