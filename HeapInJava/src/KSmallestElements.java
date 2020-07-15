//k Smallest elements in an array Using MaxHeap

/*
Method 1 (Use Bubble k times)
1) Modify Bubble Sort to run the outer loop at most k times.
2) Print the last k elements of the array obtained in step 1.
Time Complexity: O(nk)

Method 2 (sorting)
1) Sort the elements in increasing order in O(nLogn)
2) Print the first k numbers of the sorted array O(k).
Time complexity: O(nlogn)

Method 3 (Use Min Heap)
1) Build a Min Heap tree in O(n)
2) Use Extract Min k times to get k minimum elements from the Min Heap O(klogn)
Time complexity: O(n + klogn)

Method 4 (Use Max Heap)      Efficient
1) Build a Max Heap MH of the first k elements (arr[0] to arr[k-1]) of the given array     :  O(k)
2) For each element, after the kth element (arr[k] to arr[n-1]), compare it with root of MH.
……a) If the element is smaller than the root then make it root and call heapify(0) for MH
……b) Else ignore it.
// The step 2 is O((n-k)*logk)

3) Finally, MH has k smallest elements and root of the MH is the kth smallest element.

Time Complexity: O(k + (n-k)Logk) without sorted output. If sorted output is needed then O(k + (n-k)Logk + kLogk)

*/

public class KSmallestElements {
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
    static void BuildMaxHeap(int a[], int k)
    {
        for(int i = k / 2 - 1; i >= 0; i--)
        {
            MaxHeapify(a, k, i);
        }
    }
    
    static void swap(int a[], int ind, int i)
    {
        int temp = a[ind];
        a[ind] = a[i];
        a[i] = temp;
    }
    static void print(int a[], int size)
    {
        System.out.println();
        for(int i = 0; i < size; i++)
        {
            System.out.print(a[i] + " ");
            
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        int a[] = { 11, 3, 2, 1, 15, 5, 4, 
                           45, 88, 96, 50, 45 }; 
        int n = a.length;
        int k = 3;
        
        //Building a MaxHeap of size k 
        BuildMaxHeap(a, k);                      //    O(k)
        //print(a, 3);
        
        for(int i = k ; i < n; i++)          //     (n - k) * lon(k)
        {
            if(a[i] < a[0]) //if element is smaller than its root , then swap then and apply MaxHeapify on Root
            {
                a[0] = a[i];
                MaxHeapify(a,k,0);
            }
        }
        
        //over all :  o( k + (n-k) * log(k) )
        
        System.out.println("Heap of "+ k + " Smallest Elements : ");
        print(a, k);
    }
}
