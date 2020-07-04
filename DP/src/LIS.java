import java.util.*;

public class LIS {
    
    static int LisAlgo(int a[], int n)    
    {
        int lis[] = new int[n];
        lis[0] = 1; //for first and only character lis length at least will be 1
        
        for(int i = 1; i < n; i++)
        {
            lis[i] = 1;//initially assign 1 at each index
            for(int j = 0; j < i; j++)
            {
                if(a[j] < a[i] && lis[i] < lis[j] + 1) //all left element of i is less 
                {
                    lis[i] = lis[j] + 1;
                }
            }
                
        }
        
        int max = lis[0];
        for(int i = 1; i < n; i++)
        {
            if(max < lis[i])
                max = lis[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]= {6,3,8,4,5};
        int n = a.length;
        
        System.out.println("longest increasing subsequence length : "+LisAlgo(a,n));
        
    }
}
