package FindSum;
import java.util.HashSet;

public class FindPairSumInUnsortedArray {
 
    static boolean findsum(int a[], int n, int sum)
    {
        
        HashSet<Integer> hs = new HashSet<>();
        for(int i = 0; i < n; i++)
        {
            if(hs.contains(sum-a[i]))
                return true;
            else
                hs.add(a[i]);
        }
        return false;
    }
    public static void main(String[] args) {
        int a[] = {45, 6, 7, 22, 40, 50};
        System.out.println(" 95 is found : "+findsum(a, a.length,95));
    }
}
