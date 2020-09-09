
public class BubbleSort {
    
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
    //pair wise comparison
    static void bubbleSort(int a[])
    {
       int n = a.length;
       for(int i = 0; i < n - 1; i++)
       {
           for(int j = 0; j < n - i - 1; j++)
           {
               if(a[j] > a[j + 1])
                   swap(a,j + 1,j);
           }
       }
    }
    public static void main(String[] args) {
        int a[] = {5,63,2,4,54,13,42,1};
        print(a);
        bubbleSort(a);
        print(a);
    }
}

