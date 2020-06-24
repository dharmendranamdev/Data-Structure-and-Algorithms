import java.util.*;
import java.lang.*;
public class MaximumSumOfIncreasingSubsequence_1 {
    
    public static int maxSumIS(int a[], int n)
    {
        int msis[] = new int[n]; // keep track of max sum of incresing subsequence till ith index
        int index[] = new int[n]; // for geting the subsequence
        int max = 0;
        for(int i = 0; i < n; i++)//at ith index, maximum sum of Incresing subsequence will be at least a[i]
        {
            msis[i] =  a[i];
            index[i] = i;
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
                    index[i] = j;
                }
            }
        }
        
        max = msis[0];
        int maxIndex = 0;
        for(int i = 1; i < n; i++)
        {
            if(max < msis[i])
            {
                max = msis[i]; 
                maxIndex = i;
            }
        }
       
        Stack s = new Stack();//storing the element of sequence
        //then we go backward to know the ramaining elements of subsequence
        //and store them in stack so that we can print them left to right
        while(index[maxIndex] != maxIndex)
        {
            //System.out.print(a[maxIndex] + " ");
            s.add(a[maxIndex]); //add them
            maxIndex = index[maxIndex];
        }
        s.add(a[maxIndex]);
        //System.out.print(a[maxIndex]);
        
        System.out.print("Increasing Subsequence which has maximum sum : ");
        while(s.empty() != true)
        {
            System.out.print(s.pop() + " ");
        }
        System.out.println();
        
        
        
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
