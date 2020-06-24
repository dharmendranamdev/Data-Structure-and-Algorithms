import java.util.*;
import java.lang.*;
public class LongestIncresingSubsequenceLength {
    
    public static int longestIncreasingSubsequence(int a[] ,int n)
    {
        int lis[] = new int[n]; //Long.Incre.Subsequence length till index i
        for(int i = 0; i < n; i++)//Initially, LIS length for every indices at least will be 1
        { 
            lis[i] = 1;
        }
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(a[j] >= a[i]) // if previous element is bigger than A[i],simply ignore them
                    continue;
                if(a[j] < a[i] && lis[j] + 1 > lis[i])
                {
                    lis[i] = lis[j] + 1;
                   
                }
            }
        }
        
       
        int max = lis[0];
        int maxIndex = 0;
        for(int i = 1; i < n; i++)
        { 
            if(lis[i] > max)
            {
                max = lis[i];
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        int a[] = {6,3,8,4,5}; // 3
        //int a[] = { 10, 22, 9, 33, 21, 50, 41, 60 };// 5
        //int a[] = {3, 10, 2, 1, 20}; //3
        //int a[] = {3,2};  //1
        //int a[] = {50, 3, 10, 7, 40, 80}; //out : 10
        int n = a.length;
        
        System.out.println("Longest Increasing Subsequence Length : " + longestIncreasingSubsequence(a,n));
    }
}
