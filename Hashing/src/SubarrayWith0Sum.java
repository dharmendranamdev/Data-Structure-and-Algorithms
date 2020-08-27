import java.util.*;
public class SubarrayWith0Sum {
    
    //O(n^2)
    static boolean naive(int a[], int n)
    {
        for(int i = 0; i < n; i++)
        {
            int sum = 0;
            for(int j = i; j < n; j++)
            {
                sum += a[j];
                if(sum == 0)
                    return true;
            }
        }
        return false;
    }
    //efficeint approach  : O(n)
    //1) continuosly just adding the elements,and keep track of it in prev_Sum variable
    //2) if prev_sum belongs to hashSet that means , 0 sum subarray exist
    static boolean efficeint(int a[], int n)
    {
        HashSet<Integer> hs = new HashSet<>();
        int prev_Sum = 0;
        hs.add(0);// for special cases such as : arr[] = {5, -5, 10}
        for(int i = 0; i < n; i++)
        {
            prev_Sum += a[i];
            
            if(hs.contains(prev_Sum))
                return true;
            
            hs.add(prev_Sum);
        }
        return false;
        
    }
    public static void main(String[] args) {
        int a[] = {5, 6, -4, -2, 8, 10};
        System.out.println(" 0 sum exist or not : "+naive(a,a.length));
        System.out.println(" 0 sum exist or not : "+efficeint(a,a.length));
        
        
        a = new int[]{5,-5,10};
        System.out.println(" 0 sum exist or not : "+naive(a,a.length));
        System.out.println(" 0 sum exist or not : "+efficeint(a,a.length));
        
        a = new int[]{-5,15,10,67,70,-90};
        System.out.println(" 0 sum exist or not : "+naive(a,a.length));
        System.out.println(" 0 sum exist or not : "+efficeint(a,a.length));
    }
}
