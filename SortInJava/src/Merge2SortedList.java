
public class Merge2SortedList {
    static void print(int a[])
    { 
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");        
        }
        System.out.println("");
    }
    static int[] merge2list(int a[], int b[], int m, int n)
    {
        int c[] = new int[m + n];
        int i=0,j=0,k=0;
        while(i < m && j < n)
        {
            if(a[i] < b[j])
                c[k++] = a[i++];
            else
                c[k++] = b[j++];
        }
        while(i < m)
            c[k++] = a[i++];
        while(j < n)
            c[k++] = b[j++];
        return c;
    }
    public static void main(String[] args) {
        int a[] = {2,5,7,9,11}; //m
        int b[] = {3,4,6,8}; //n
        //result  => 2,3,4,5,6,7,8,9,11
        
        int result[] = new int[a.length + b.length];
        
        print(a);
        print(b);
        
        result = merge2list(a,b, a.length, b.length);
        
        print(result);
    }
}
