import java.util.*;
import java.lang.*;
public class MinJumpsToEndRecursion {
    static int min = Integer.MAX_VALUE;
    public static int minJumps(int a[], int n, int index, int count)
    {
        if(index == n - 1)
            return count;
        for(int i = 1; i  <= a[index]; i++)
        {
            if(index + i < n)
            {
             int val = minJumps(a, n, index + i, count + 1);
             min = Math.min(min, val);
            }
        }
        return min;
    }
    public static void main(String args[])
    {
        //int a[] = { 1, 3, 6, 3, 2, 3, 6, 8, 9, 5 }; //out : 4
        int a[] = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};//out : 3
        //int a[] = {2,1,2,1,3}; //out : 2
        //int a[] = {2,1,4,1,2,5,1,1,1,1,1};//out  :3
        //int a[] ={10,1,2,4,5,9,10,3,5,10,1,4,6,3,5,6};
        int n = a.length; 
        System.out.println("Minimum number of jumps to reach end is : "+ minJumps(a, n, 0, 0)); 
    }
}
