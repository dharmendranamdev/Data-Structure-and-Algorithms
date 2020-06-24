import java.util.*;
import java.lang.*;
import java.util.*;

public class CountTheTriplets
{
    static int BinarySearch(int a[], int l, int r ,int key)
    {
        if(l > r)
            return - 1;        
        int mid = ( l + r )  / 2;
        
        if(a[mid] < key)
            return BinarySearch(a, mid + 1,r,key);
        else if(a[mid] > key)
            return BinarySearch(a,l,mid - 1,key);
        else
            return 1;
        
    }
    public static int count(int a[] ,int n)
    {
        Arrays.sort(a);
        //ArrayList<Integer> list = new ArrayList<Integer>();
        /*for(int i = 0; i < n; i++){
            list.add(a[i]);
        }*/
        int count = 0;
        for(int i = 0; i < n - 1; i++)
        {
           for(int j = i + 1; j < n; j++)
           {
                if(BinarySearch(a,j + 1, n - 1,a[i] + a[j]) == 1)
                     count++;
           }
        }
        if(count == 0)
            return -1;
        return count;
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int i = 1; i <= T; i++)
        {
           int n = sc.nextInt();
           int a[] = new int[n];
           for(int j = 0; j < n; j++)
           {
               a[j] = sc.nextInt();
           }
           System.out.println(count(a,n));
                   
        }
    }
}
