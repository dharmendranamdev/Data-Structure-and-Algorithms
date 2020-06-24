import java.lang.*;
import java.util.*;
public class MinJumpsToReachEndSequence {
    public static int minJumps(int a[] ,int n)
    {
        int jumps[] = new int[n]; //used to keep track of minimum jumps to reach at ith index
        int index[] = new int[n];//for getting the sequence
        
        for(int i = 0; i < n; i++){
          jumps[i] = Integer.MAX_VALUE;  
        }
        
        jumps[0] = 0; //min jumps to reach at index 0 from 0 is : 0
        
        for(int i = 1; i < n; i++){
            for(int j = 0; j < i; j++){
                
                if(a[j] + j >= i && jumps[j] + 1 < jumps[i]){
                    
                    jumps[i] = jumps[j] + 1;
                    index[i] = j;
                    //System.out.println(index[i] + " i-->" + i + " j --> " + j);
                }
            }
        }
        
        for(int i = 0; i < n; i++)
        {
            System.out.print(index[i] + " ");
        }
        System.out.println();
        
        
        
        System.out.println("Jumps are....(Read right to left)");
        System.out.print(a[n-1] + " <-- ");
        int ind = index[n - 1];
        
        while(ind != 0)
        {
            System.out.print(a[ind] + " <-- ");
            ind = index[ind];
        }
        System.out.print(a[0]);
        
        System.out.println();
        
        return jumps[n-1];
    }
    public static void main(String args[])
    {
        int arr[] = {2,3,1,1,2,4,2,0,1,1}; //4
        //int arr[] = {1,5,6,8,3,0,5,1}; //3
        //int arr[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; //out : 4
        //int arr[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int n = arr.length;
        System.out.println("Min Jumps to reach end of array : " + minJumps(arr,n));
    }
}
