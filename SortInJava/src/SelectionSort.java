
public class SelectionSort {
    
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
    //Drawback : maximum no of swap operation
    static void selectionSort(int a[])
    {
       int n = a.length;
       for(int i = 0; i < n-1; i++)
       {
           for(int j = i + 1; j < n; j++)
           {
               if(a[i] > a[j])
                   swap(a,i,j);
           }
       }
    }
    public static void main(String[] args) {
        int a[] = {5,63,2,4,54,13,42,1};
        print(a);
        selectionSort(a);
        print(a);
    }
}
