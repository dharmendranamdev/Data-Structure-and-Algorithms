
public class HeapSort {
    static void print(int a[])
    { 
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            
        }
        System.out.println("");
    }
    static void swap(int a[], int i, int j)
    {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    static void MaxHeapify(int a[], int n, int index)
    {
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        int largest = index;
        if(lc < n && a[lc] > a[index])
            largest = lc;
        if(rc < n && a[rc] > a[largest])
            largest = rc;
        if(largest != index)
        {
            swap(a, largest, index);
            MaxHeapify(a, n, largest);
        }
    }
    static void heapsort(int a[]){
        //Build max Heapify
        int n = a.length;
        for(int i = n / 2 - 1; i >= 0; i--)
        {
            MaxHeapify(a,n,i);
        }
        
        //Delete a node one by one from heap
        for(int j = n - 1; j >= 0; j--)
        {
            swap(a, j, 0);
            MaxHeapify(a, j, 0);
        }
        
    }
    public static void main(String[] args) {
        int a[] = {5,63,2,4,54,13,42,1};
        print(a);
        heapsort(a);
        print(a);
    }
}
