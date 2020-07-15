//Here we code the basic operation of Heap ( MaxHeap : root node is bigger than its child nodes )
//1) MaxHeapify  log(n)
//2) BuildHeap   o(n)
//3) Delete Root Node from Min Heap one by one  : n * log(n)
//4) above all three complete operation will give "SORTED ARRAY in INCREASING ORDER"  : n * log(n)
//5) Heap Maximum  : O(1)
//6) extract-Max (Delete Root node) : log(n)
//7) Heap Increase Key in MaxHeap  or Heap Decrease Key in MinHeap  : log(n)
//8) Heap Insert         : log(n)
//9) Heap Delete (any node) : log(n)

public class MaxHeap 
{
    static int cur_size;
    static int total_size;
    //Task - 1
    static void MaxHeapify(int a[], int size, int i)
    {
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        int ind = i;
        if(lc < size && a[lc] > a[i])
            ind = lc;
        if(rc < size && a[rc] > a[ind])
            ind = rc;
        if(ind != i)
        {
            swap(a, ind, i);  // swap(a[ind], a[i]) : swapping b/w root and child node has bigger value
            MaxHeapify(a, size, ind); //apply MaxHeapify again on its child
        }
    }
    //Task-2
    static void BuildMaxHeap(int a[])
    {
        for(int i = cur_size / 2 - 1; i >= 0; i--)
        {
            MaxHeapify(a, cur_size, i);
        }
    }
    //Task - 3 and 4  (Heap Sort) 
    static void HeapSort(int a[])
    {
        BuildMaxHeap(a); //Building a Heap using Heapify  : o(n)
        
        //Delete Root node one by one  : n * log n
        for(int i = cur_size - 1; i >= 0; i--)
        {
            swap(a, i, 0);  //     or        swap(a[i] , a[0])  :  swap last element to its root
            MaxHeapify(a, i, 0);
        }
        
        print(a);
    }
    //Task - 5
    static int HeapMaximum(int a[])
    {
        if(cur_size < 1)
            return -1;
        return a[0];
    }
    //Task - 6
    static int HeapExtractMax(int a[])
    {
        int root = a[0];
        swap(a, 0, cur_size - 1);    //  or     swap(a[0]  , a[cur_size - 1])
        cur_size--;
        MaxHeapify(a, cur_size, 0);
        return root;
    }
    //task - 7
    static void HeapIncreaseKey(int a[], int index, int key)
    {
        if(a[index] >= key)
            System.out.println("Element can't be increased...");
        else{
            a[index] = key;
            int i = index;
            while(i != 0 && a[i] > a[(i - 1) / 2])
            {
                swap(a, i, (i - 1) / 2 );
                i = (i - 1) / 2;
            }
        }
    }
    
    //Task - 8 Heap Insert
    static void HeapInsert(int a[], int key)
    {
        if(cur_size == total_size)
            System.out.println("Insertion Not Possible..");
        else{
            a[cur_size] = key - 1;
            cur_size++;
            HeapIncreaseKey(a, cur_size - 1, key);
        }
        
    }
    //Task - 9 Heap Deletion
    static void HeapDeletion(int a[], int i)
    {
        HeapIncreaseKey(a, i, Integer.MAX_VALUE); // for minHeap, assign Integer.MIN_VALUE so that value can reach on top(root)
        HeapExtractMax(a);
    }
    public static void main(String[] args) {
        int a[] = new int[10];
        a[0] = 4;
        a[1] = 10;
        a[2]= 3;
        a[3] = 5;
        a[4] = 1;
        total_size = 10;
        cur_size = 5;
        
        //task 1-2
        System.out.println("Building a Max Heap Using Max Heapify : ");
        BuildMaxHeap(a);
        print(a);
        
        //task 3 - 4
        System.out.println("Haap Sort( MaxHeap gives Increasing Order)  : ");
        HeapSort(a);
        
        //task-5
        System.out.println("Heap Maximum : ");
        int s = HeapMaximum(a);
        System.out.print(s+"\n");
        
        //task - 6
        System.out.println("\nHeap Extract Max : ");
        s = HeapExtractMax(a);
        System.out.print(s+"\n");
        
        System.out.println("\nAfter extracting max from Heap : ");
        print(a);
        
        //task- 7
        System.out.println("Heap Increse Key");
        HeapIncreaseKey(a, 1, 15);
        print(a);
        
        //task - 8
        System.out.println("Heap Insertion : ");
        HeapInsert(a, 25);
        print(a);
        
        //TAsk - 9 HEap Delete Any node
        System.out.println("heap Deletion : ");
        HeapDeletion(a, 1);
        print(a);
    }
    
    
    static void swap(int a[], int ind, int i)
    {
        int temp = a[ind];
        a[ind] = a[i];
        a[i] = temp;
    }
    static void print(int a[])
    {
        System.out.println();
        for(int i = 0; i < cur_size; i++)
        {
            System.out.print(a[i] + " ");
            
        }
        System.out.println();
    }
}
