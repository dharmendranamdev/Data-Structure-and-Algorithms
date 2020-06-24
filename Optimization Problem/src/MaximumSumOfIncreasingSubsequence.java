import java.util.*;
import java.lang.*;
public class MaximumSumOfIncreasingSubsequence {
    
    public static int maxSumIS(int a[], int n)
    {
        int msis[] = new int[n]; // keep track of max sum of incresing subsequence till ith index
        
        int max = 0;
        for(int i = 0; i < n; i++)//at ith index, maximum sum of Incresing subsequence will be at least a[i]
        {
            msis[i] =  a[i];
        }
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(a[j] >= a[i])
                    continue;
                if(a[j] < a[i] && msis[j] + a[i] > msis[i])
                {
                    msis[i] =  msis[j] + a[i];
                }
            }
        }
        
        max = msis[0];
        for(int i = 1; i < n; i++)
        {
            if(max < msis[i])
            {
                max = msis[i]; 
            }
        }
       
        return max;
    }
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5}; 
        //int arr[] = {6,3,8,4,5};
        int n = arr.length; 
        System.out.println("Maximum sum of Increasing Subsequence : "+ maxSumIS(arr, n)); 
    }
}
