
//Purchasing Maximum no of item
/*
I: cost[]= {1,12,5,111,200}
 sum = 10;
O: 2

M1: (sorting)
1) sorted array cost[] = {1,5,12,111,200}
res = 0,sum = 10;
i = 0, sum = 9, res = 1
i = 1, sum = 4, res = 2
i = 2, since 12 > sum( 4 ) return res = 2;

M2 : Use MinHeap


*/
public class PurchasingMaxItem {
    static int n;
    static void MinHeapify(int a[], int size, int i)
    {
        int lc = 2 * i + 1;
        int rc = 2 * i + 2;
        int ind = i;
        if(lc < size && a[lc] < a[i])
            ind = lc;
        if(rc < size && a[rc] < a[ind])
            ind = rc;
        if(ind != i)
        {
            swap(a, ind, i);  // swap(a[ind], a[i]) : swapping b/w root and child node has bigger value
            MinHeapify(a, size, ind); //apply MaxHeapify again on its child
        }
    }
    static void swap(int a[], int ind, int i)
    {
        int temp = a[ind];
        a[ind] = a[i];
        a[i] = temp;
    }
    //Task-2
    static void BuildMinHeap(int a[], int k)
    {
        for(int i = k / 2 - 1; i >= 0; i--)
        {
            MinHeapify(a, k, i);
        }
    }
     static int HeapExtractMax(int a[])
    {
        int root = a[0];
        swap(a, 0, n - 1);    //  or     swap(a[0]  , a[cur_size - 1])
        n--;
        MinHeapify(a, n, 0);
        return root;
    }
    public static void main(String[] args) {
        int cost[] = {1,12,5,111,200};
        n = cost.length;
        int sum = 100000;
        
        //Build Min Heap
        BuildMinHeap(cost, n);
        for(int i = 0; i < n; i++)
            System.out.print(cost[i]+" ");
        System.out.println();
        
        int res = 0;
        while(n != 0 && cost[0] <= sum)
        {
            sum = sum - cost[0];
            HeapExtractMax(cost);
            for(int i = 0; i < n; i++)
                System.out.print(cost[i]+" ");
            System.out.println();
            res++;
        }
        System.out.println("Maximum no of item that can be purchased : "+res);
        
    }
}
