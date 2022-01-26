package codingPracticeDSA.arrayProblem.mediumLevel;


//https://www.youtube.com/watch?v=UA_Rmjfj4bw


public class QuickSortBestAlgo {

    public static void main(String... s)
    {
        int[] arr = new int[]{4,6,2,5,7,9,1,3};
        quickSort(arr,0,arr.length-1);
        for(int i : arr){
            System.out.print(i+" ");
        }
    }
    static void quickSort(int arr[], int low, int high)
    {
        if(low<high){
            int pivot = partition(arr,low,high);
            quickSort(arr,pivot+1,high);
            quickSort(arr,low,pivot-1);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot = arr[low];
        int i = low + 1;
        int j = high;

        while(i<=j){
            if(arr[i]>pivot && arr[j]<pivot){
                swap(arr,i,j);
            }
            if(arr[i]<pivot){
                i++;
            }
            if(arr[j]>pivot){
                j--;
            }
        }
        swap(arr,low,j);
        return j;
    }

    static void swap(int arr[],int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
