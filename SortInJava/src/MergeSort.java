
public class MergeSort {
    
    static void print(int a[])
    { 
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
            
        }
        System.out.println("");
    }
    static void merge(int a[], int l, int m, int r)
    {
        int n1 = m - l + 1;
        int n2 = r - m;
        int c[] = new int[n1 + n2];
        int i = l, j = m + 1, k = 0;
        
        int firstLength = i + n1;
        int secondeLength = j + n2;
        
        while(i < firstLength && j < secondeLength)
        {
            if(a[i] < a[j])
                c[k++] = a[i++];
            else
                c[k++] = a[j++];
        }
        while(i < firstLength)
            c[k++] = a[i++];
        while(j < secondeLength)
            c[k++] = a[j++];
        k = 0;
        
        for(i = l; i <= r; i++)
            a[i] = c[k++];
    }
    static void mergeSort(int a[], int l, int r)
    {
        if(l < r)
        {
            int mid =  l + (r - l) / 2;
            mergeSort(a, l, mid);
            mergeSort(a, mid+1, r);
            merge(a, l, mid,r);
        }
    }
    public static void main(String[] args) {
        int a[] = {5,63,2,4,54,13,42,1};
        print(a);
        mergeSort(a,0,a.length - 1);
        print(a);
    }
}
