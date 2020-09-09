
public class InsertionSort {

    static void print(int a[])
    { 
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            
        }
        System.out.println("");
    }
    static void insertionsort(int a[])
    {
        int n = a.length;
        for(int i = 1; i < n; i++)
        {
            int j = i;
            while(j > 0 && a[j] < a[j-1])
            {
                int temp = a[j];
                a[j] = a[j-1];
                a[j-1] = temp;
                j--;
            }
        }
    }
    public static void main(String[] args) {
        
        int a[] = {5,63,2,4,54,13,42,1};
        print(a);
        insertionsort(a);
        print(a);
    }
}
