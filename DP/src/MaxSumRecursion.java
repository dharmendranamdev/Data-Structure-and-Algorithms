import java.util.*;

public class MaxSumRecursion {
    static int maxsumRec(int a[], int n)
    {
        if(n == 1) //if n =1 then maximum sum will be first element itself
            return a[0];
        else if(n == 2)//here we can't take consequtive, we have to take maximum out of them
            return Integer.max(a[0], a[1]);
        else
            return Integer.max(maxsumRec(a, n-1), maxsumRec(a, n-2) + a[n-1]); //either exclude the no or include
    }
    public static void main(String[] args) {
        int a[] = {10,5,15,20,2,30}; //10,20,30
        int n = a.length;
        
        System.out.println("Maximum sum with no consecutive number : "+maxsumRec(a,n));
        
        a = new int[]{10,20,30}; //10,30
        n = a.length;
        System.out.println("Maximum sum with no consecutive number : "+maxsumRec(a,n));
        
        a = new int[]{8,7,6,10}; //8,10
        n = a.length;
        System.out.println("Maximum sum with no consecutive number : "+maxsumRec(a,n));
    
    }
}
