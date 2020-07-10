import java.util.*;
public class MinHeap
{
    static int maxSize = 50;
    //static int n;
    static void printArray(int a[],int n)
    {
        for(int i = 0; i < n; i++)
	{System.out.print(a[i]+" ");}
        System.out.println();
    }
    static void MinHeapify(int a[],int n,int index)
    {
        int smallest = index;
        int lc = 2 * index + 1;
        int rc = 2 * index + 2;
        if(lc < n && a[smallest] > a[lc])
            smallest = lc;
        if(rc < n && a[smallest] > a[rc])
            smallest = rc;
        if(smallest != index)
        {
            //swapping b/w smallest and index
            int temp = a[smallest];
            a[smallest] = a[index];
            a[index] = temp;
            MinHeapify(a,n,smallest);
        }
        
    }
    static void BuildMinHeap(int a[],int n)
    {
        for(int i = n / 2 - 1; i >= 0; i-- )
        {
            MinHeapify(a,n,i);
        }
        
    }
    static void HeapSort(int a[],int n)
    {
        //Building a Heap :O(n)
        BuildMinHeap(a,n);
        for(int i = n - 1; i >= 1; i--)
        {
            int temp = a[i];
            a[i] = a[0];
            a[0] = temp;
            MinHeapify(a,i,0);
        }
    }
    static int HeapMinimum(int a[],int n)
    {
        if(n < 1)
            return -1;
        else
            return a[0];
    }
    static int DeleteMin(int a[],int n)
    {
        if(n < 1)
        {
            return -1;
        }
        else
        {
            int min = a[0];
            a[0] = a[n-1];
            n--;
            MinHeapify(a,n,0);
            return n;
        }
    }
    static void HeapDecreseKey(int a[] ,int n,int i,int key)
    {
        if(key >= a[i])
        {
            System.out.println("Element Can't be Incresed.....");
            return;
        }
        a[i] = key;
        while(i > 0)
        {
            if(a[i] < a[(i - 1) / 2])
            {
                int temp = a[i];
                a[i] = a[(i - 1) / 2];
                a[(i - 1) / 2] = temp;
            }
            i = (i - 1) / 2;
        }
    }
    static int HeapInsert(int a[],int n,int key)
    {
        if(n == maxSize)
        {
            System.out.println("\nHeapIsFull,No Insertion is Possible..\n");
            return n;
        }
        a[n] = key + 1;
        n++;
        //System.out.println(n);
        HeapDecreseKey(a,n,n-1,key);
        return n;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
	int a[] = new int[maxSize]; //= {27,10,1,5,-4,2};
        
        System.out.print("Enter the size of Min Heap :");
        int n = sc.nextInt();
        
        
        for(int i = 0; i < n; i++)
        {
            a[i] = sc.nextInt();
        }
        System.out.println("Your Given Array:");
	printArray(a,n);
       
        System.out.println("0.Build Min Heap \t 1.HeapSort \t 2. get Min Element\t3.Delete minimum\t4.using HeapDecreaseKey()\t 5.Using HeapInsert()");
        System.out.println("Enter Your choice:");
        int choice = sc.nextInt();
        switch(choice)
        {
            case 0:{
                System.out.println("Your choice is Building A MinHEap");
                BuildMinHeap(a,n);
                printArray(a,n);
                break;
            }
            case 1:
            {
                System.out.println("Your choice is HeapSort......");
                HeapSort(a,n);
                printArray(a,n);
                break;
            }
            case 2:
            {
                //----------------Getting Minimum Element-------
                System.out.println("Your choice is getting min element......");
                BuildMinHeap(a,n);
               int min = HeapMinimum(a,n);
               System.out.println("Minimum Element is :"+min);
               break;
               //----------------------end-------------------
            }
            case 3:
            {//heap delete min
              System.out.println("Your choice is Delete min......");
              BuildMinHeap(a,n);
              printArray(a,n);
              n = DeleteMin(a,n);
              System.out.println("Root Item is Deleted.....");
              printArray(a,n);
              break;
          
            }
            case 4:
            {
                //Heap Decrease Key
                
                System.out.println("Your choice is to play with HeapDecreasekey()......");
                int index = 3;
                int key = -56;
                BuildMinHeap(a,n);
                printArray(a,n);
                System.out.println("Here,we randomly choose an index "+index+" with key " + key);
                System.out.println("Lets Perform HeapDecrease key.....");
                HeapDecreseKey(a,n,index,key);
                printArray(a,n);
                break;
            }
            case 5:
            {
                //-------------HEapInsert------------------
                System.out.println("Your choice is insertion in heap..");
                BuildMinHeap(a,n);
                printArray(a,n);
                n = HeapInsert(a,n,-101);
                printArray(a,n);
                break;
            }
            default:{
                System.out.println("Invalid choice....");
            }               
        }
    }
}
