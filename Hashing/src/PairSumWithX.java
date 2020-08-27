import java.util.*;
public class PairSumWithX {
    static boolean pairsum(int a[], int n, int x)
    {
        HashSet<Integer>hs = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            if(hs.contains(x - a[i]))
                return true;
            else
                hs.add(a[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        
        int a[] = {3,5,2,8,11,7};
        int x = 16;
        System.out.println("is present : "+pairsum(a,a.length,x));
    }
}
