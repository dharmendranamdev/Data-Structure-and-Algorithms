import java.util.*;

public class MaxSumDP {
    static int maxsumDp(int a[], int n)
    {
        int dp[] = new int[n+1];
        dp[1] = a[0]; //max_sum till first elment or n = 1, we need to return only a[0] as maxsum 
        dp[2] = Integer.max(a[0], a[1]); //max_sum till 2nd element or n == 2 then return maximum of first 2 elment
        
        for(int i = 3; i < n + 1; i++)
        {
            dp[i] = Integer.max(dp[i-1], dp[i-2] + a[i-1]);
        }
        return dp[n];
        
    }
    public static void main(String[] args) {
        int a[] = {10,5,15,20,2,30}; //10,20,30
        int n = a.length;
        
        System.out.println("Maximum sum with no consecutive number : "+maxsumDp(a,n));
        
        a = new int[]{10,20,30}; //10,30
        n = a.length;
        System.out.println("Maximum sum with no consecutive number : "+maxsumDp(a,n));
        
        a = new int[]{8,7,6,10}; //8,10
        n = a.length;
        System.out.println("Maximum sum with no consecutive number : "+maxsumDp(a,n));
    
    }
}
