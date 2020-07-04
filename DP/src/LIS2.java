import java.util.*;


//Maximum Length Bitonic Sequence

public class LIS2 {
    
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
        
        int lds[] =  new int[n]; //longest decreaing subsequence  = longest incresing subsequence from right side
        
        lds[n-1] = 1;
        for(int i = n - 2 ; i >= 0 ; i--)
        {
            lds[i] = 1;//initially assign 1 at each index
            for(int j = n - 1; j > i; j--)
            {
                if(a[j] < a[i] && lds[i] < lds[j] + 1) //all left element of i is less 
                {
                    lds[i] = lds[j] + 1;
                }
            }
                
        }
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            if(max < lis[i] + lds[i] - 1)
                max = lis[i] + lds[i] - 1;
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]= {6,3,8,4,5};
        int n = a.length;
        System.out.println("Maximum Length of Bitonic Sequence : "+LisAlgo(a,n));
        
        a = new int[]{12, 4, 78, 90, 45, 23}; // {4, 78, 90, 45, 23} of 5 length
        n = a.length;
        System.out.println("Maximum Length of Bitonic Sequence : "+LisAlgo(a,n));
        
        a = new int[]{20, 4, 1, 2, 3, 4, 2, 10}; // {1, 2, 3, 4, 2} of 5th length
        n = a.length;
        System.out.println("Maximum Length of Bitonic Sequence : "+LisAlgo(a,n));
        
        a = new int[]{10,20,40,50}; //  of 4th length
        n = a.length;
        System.out.println("Maximum Length of Bitonic Sequence : "+LisAlgo(a,n));
        
        
        a = new int[]{50,40,20,10}; // of 4th length
        n = a.length;
        System.out.println("Maximum Length of Bitonic Sequence : "+LisAlgo(a,n));
        
        
        
    }
}
