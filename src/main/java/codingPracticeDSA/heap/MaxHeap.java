package codingPracticeDSA.heap;

/**
 * https://www.youtube.com/watch?v=KmtpWB8Y_DA&list=PL6Zs6LgrJj3tDXv8a_elC6eT_4R5gfX4d&index=124
 */
public class MaxHeap {
    private int n; //length of Max Heap
    private Integer[] heap;

    public MaxHeap(int capacity){
        heap = new Integer[capacity];
        n = 0;
    }

    private boolean isEmpty(){
        return n==0;
    }

    public int size(){
        return n;
    }

    private void insert(int value){
        if(n == heap.length-1){
            resize(2*heap.length);
        }
        n++;
        heap[n] = value;
        swim(n);
    }
    private void resize(int newCapacity){
        Integer[] newHeap = new Integer[newCapacity];
        for(int i =0;i<heap.length;i++){
            newHeap[i] = heap[i];
        }
        heap = newHeap;
    }
    private void swim(int k){
        while((k>1) && (heap[k] > heap[k/2])){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    private int deleteFromMaxHeap(){
        int max = heap[1];
        swap(1,n);
        heap[n] = null;
        int k = 1;
        while(true){
            int left = heap[2*k]==null?Integer.MIN_VALUE:heap[2*k];
            int right = heap[2*k+1]==null?Integer.MIN_VALUE:heap[2*k+1];
            if((heap[k] < left || heap[k] < right) && (k<n)){
            int swappedIndex = (left > right) ? 2 * k : 2 * k + 1;
            swap(k, swappedIndex);
            k = swappedIndex;
            }else{
                break;
            }
        }
        return max;
    }

    private void swap(int i,int j){
        int temp = heap[j];
        heap[j] = heap[i];
        heap[i] = temp;
    }

    private void printMaxHeap(){
        for(Integer val:heap){
            System.out.print(val +" ---> ");
        }
    }

    public static void main(String... s){
        MaxHeap maxHeap = new MaxHeap(4);
        System.out.println("size of max heap "+maxHeap.size());
        System.out.println("Max Heap is Empty: "+maxHeap.isEmpty());
        maxHeap.insert(4);
        maxHeap.insert(6);
        maxHeap.insert(10);
        maxHeap.insert(9);
        maxHeap.insert(15);
        maxHeap.insert(20);
        System.out.println("Max heap before deletion ");
        maxHeap.printMaxHeap();
        System.out.println("\nDeleted Element from Max Heap is :"+maxHeap.deleteFromMaxHeap());
        System.out.println("Max heap after deletion ");
        maxHeap.printMaxHeap();
    }
}
