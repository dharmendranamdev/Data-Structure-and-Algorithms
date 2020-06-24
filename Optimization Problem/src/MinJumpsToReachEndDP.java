import java.lang.*;
import java.util.*;
public class MinJumpsToReachEndDP {
    public static int minJumps(int a[] ,int n)
    {
        int jumps[] = new int[n]; //used to keep track of minimum jumps to reach at ith index from 0th index
        
        for(int i = 0; i < n; i++)
        {
          jumps[i] = Integer.MAX_VALUE;  
        }
        jumps[0] = 0; //min jumps to reach at index 0 from 0 is : 0
        
        for(int i = 1; i < n; i++)
        {
            for(int j = 0; j < i; j++)
            {
                if(a[j] + j >= i && jumps[j] + 1 < jumps[i])
                {
                    jumps[i] = jumps[j] + 1;
                }
            }
        }
        return jumps[n-1];
    }
    public static void main(String args[])
    {
        //int arr[] = {2,3,1,1,2,4,2,0,1,1}; //4
        //int arr[] = {1,5,6,8,3,0,5,1}; //3
        int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; //out : 4
        int n = arr.length;
        System.out.println("Min Jumps to reach end of array : " + minJumps(arr,n));
    }
}
