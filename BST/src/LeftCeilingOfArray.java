import java.util.*;
public class LeftCeilingOfArray {
    
    
    //naive approach : O(n^2) 
    //space complexity : O(1)
    static void CeilingOnLeftSide(int a[], int n)
    {
        System.out.print("-1 ");
        for(int i = 1; i < n; i++)
        {
            int diff = Integer.MAX_VALUE;
            for(int j = 0; j < i; j++)
            {
                if(a[i] <= a[j])
                    diff = Math.min(diff, a[j] - a[i]);
            }
            if(diff == Integer.MAX_VALUE)
                System.out.print("-1 ");
            else
                System.out.print(a[i] + diff + " ");
        }
    }
    //self balancing(Red Black Tree) BST Approach : using TreeSet(internally uses Red Black Tree)
    //Time complexity : O(nlogn) and Space Complexity : O(n)
    static void printCeiling(int a[], int n)
    {
        TreeSet<Integer> ts = new TreeSet<>();
        ts.add(a[0]);
        System.out.print("-1 ");
        for(int i = 1; i < n; i++)
        {
            Integer max = ts.ceiling(a[i]);
            if(max != null)
                System.out.print(max +" ");
            else
                System.out.print("-1 ");
            ts.add(a[i]);
        }
        
    }
    public static void main(String[] args) {
        int a[] = new int[]{2,8,30,15,25,12};
        int n = a.length;
        CeilingOnLeftSide(a, n);
        System.out.println();
        printCeiling(a, n);
        
        System.out.println();
        
        a = new int[]{ 50, 20, 200, 100, 30 }; 
        n = a.length;
         CeilingOnLeftSide(a, n);
        System.out.println();
        printCeiling(a, n);
    }
}
