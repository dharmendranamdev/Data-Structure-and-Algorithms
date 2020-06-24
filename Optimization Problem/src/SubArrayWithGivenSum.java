import java.util.*;
import java.lang.*;

public class SubArrayWithGivenSum {
    
   public static boolean subarrayWithGivenSum(int a[] ,int n, int sum)
   {
       int cur_sum = a[0];
       int start = 0;  //starting point, in algo it is l
       for(int i = 1; i <= n; i++)
       {
           while(cur_sum > sum && start < i - 1 )
           {
               cur_sum = cur_sum - a[start];
               start++;
           }
           
           if(cur_sum == sum)
           {
               int p = i - 1;
               System.out.println("start index : " + start + " lastIndex : " + p);
               return true;
           }
           if(i < n)
               cur_sum += a[i];
               
       }
       System.out.println("No SubArray Found...");
       return false;
   }
   public static void main(String args[])
   {
         //int arr[] = { 15, 2, 4, 8, 9, 5, 10, 23 }; 
         //int sum = 23; 
        
        //int arr[] = {1, 4, 45, 6, 10, 19}; 
        //int sum = 51; 
       
        int arr[] = {1, 10, 5, 2, 7}; 
        int sum = 14;
        
       //int arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}; 
       //int sum = 280;
       
       //int  arr[] = {1, 4, 20, 3, 10, 5};
       //int sum = 33;
       
       //int arr[] = {1, 4, 0, 0, 3, 10, 5};
       //int sum = 300;
       
       
       int n = arr.length; 
        
        if(subarrayWithGivenSum(arr, n, sum))
            System.out.println("SubArray is found...");
   }
}
