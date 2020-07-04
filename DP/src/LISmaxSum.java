import java.util.*;

public class LISmaxSum {
    
    static int LisAlgo(int a[], int n)    
    {
        int msis[] = new int[n];
        
        msis[0] = a[0]; //for first and only character lis length at least will be 1
        
        for(int i = 1; i < n; i++)
        {
            msis[i] = a[i];//initially assign 1 at each index
            for(int j = 0; j < i; j++)
            {
                if(a[j] < a[i] && msis[i] < msis[j] + a[i]) //all left element of i is less 
                {
                    msis[i] = msis[j] + a[i];
                }
            }
                
        }
        
        int max = msis[0];
        for(int i = 1; i < n; i++)
        {
            if(max < msis[i])
                max = msis[i];
        }
        return max;
    }
    public static void main(String[] args) {
        int a[]= {6,3,8,4,5};//longest increasing subsequence : 3,4,5
                             //But maximum sum of increasing subsequence:6,8
        int n = a.length;
        
        System.out.println("Maximum Sum of increasing subsequence length : "+LisAlgo(a,n));
        
    }
}
