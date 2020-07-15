/*
                         Time Complexity :O( n * k * log k), 
Insertion and deletion in a Min Heap requires log k time. So the Overall time compelxity is O( n * k * log k)

                         Space Complexity :O(k), 
If Output is not stored then the only space required is the Min-Heap of k elements.So space Comeplexity is O(k).
*/

public class MergeKSortedArrayOfDiffSize {
    static class List{
        public int size;
        public int pointer;
        public int cur_val;
    }
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
    static void BuildMinHeap(int a[], int k)
    {
        for(int i = k / 2 - 1; i >= 0; i--)
        {
            MinHeapify(a, k, i);
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
            System.out.print(a[i] + " ");
        System.out.println();
    }
    static int HeapMin(int a[])
    {
        return a[0];
    }
    static void MergeKSortedArray(int a[], int n, int b[], int k) {
        int setLimit[] = new int[k];//it is used to get last index of each list.
        
        for(int i = 0; i < k; i++)
            setLimit[i] = b[i];
        for(int i = 1; i < k ; i++)
            setLimit[i] = setLimit[i] + setLimit[i-1];
        //print(setLimit, k);
        
        List list[] = new List[k];    //how many sorted we have = k . each list have its SIZE, POINTER, CUR_VALUE
        int heapArray[] = new int[k]; //Main Operation wil be performed on this array( such as BuildHeap, Heapify)
        int temp[] = new int[n]; //final result
        
        
        for(int i = 0; i < k; i++)
        {
            list[i] = new List();
            list[i].size = b[i]; // Assign the size
            list[i].pointer = setLimit[i] - b[i];   //set the pointers to first element of each list
            list[i].cur_val = a[list[i].pointer];  //assign pointer value
            heapArray[i] = list[i].cur_val;
        }
        
        //Build min Heap of size k
        BuildMinHeap(heapArray, k);
        
        for(int i = 0; i < n; i++)  //o(n)  :    overall --------> [ n * k * log(k) ]
        {
            int min = HeapMin(heapArray); //return heapArray[0]
            temp[i] = min;
            for(int j = 0; j < k; j++) //O(k)
            {
                //we check the list in which the removed element belonged.
                //update it size, pointer and  cur_value
                if(list[j].size > 0 && list[j].cur_val == min)    //log(k)
                {
                    list[j].size--;
                    list[j].pointer++;
                    if(list[j].pointer >= setLimit[j]) //if list is over then just assign INF
                        list[j].cur_val = Integer.MAX_VALUE;
                    else                               //otherwise assign next elment of that list
                        list[j].cur_val = a[list[j].pointer];
                    
                    heapArray[0] = list[j].cur_val; //put that element on top of heap
                    
                    MinHeapify(heapArray, k, 0);  //again calll heapify for making heapArray MinHeap
                    break;
                }
            }
            
        }
        
        print(temp, n);
    }
    
    public static void main(String[] args) {
        int a[] = {25,30,35,   15,20,26,34,   17,28};
        //There are k = 3 sorted array of different size respectively 3 , 4, 2
        int b[] = {3,4,2}; 
        int n = a.length;
        int k = b.length;
        
        MergeKSortedArray(a, n, b, k);
        
        a = new int[]{2, 6, 12, 34,     1, 9, 20, 1000,     23, 34, 90, 2000}; 
        b = new int[]{4, 4, 4};
        n = a.length;
        k = b.length;
        
        MergeKSortedArray(a, n, b, k);
        
        
        a = new int[]{2, 6, 12, 341,     1, 9,     34, 90, 2000}; 
        b = new int[]{4, 2, 3};
        n = a.length;
        k = b.length;
        
        MergeKSortedArray(a, n, b, k);
    }
}
