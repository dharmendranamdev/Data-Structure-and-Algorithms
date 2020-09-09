
package FindSum;
//Using 2 pointer technique

public class FindPairSumInSortedArray {
    static boolean findsum(int a[], int n, int sum)
    {
        int l = 0;
        int r = n - 1;
        while(l < r)
        {
            if(a[l] + a[r] == sum)
                return true;
            else if(a[l] + a[r] > sum)
                r--;
            else
                l++;
        }
        return false;
    }
    public static void main(String[] args) {
        
        int a[] = {10,20,25,30,46,50,60};
        int sum = 90;
        int n = a.length;
        System.out.println(" 90 exist or not : "+findsum(a, n, sum));
    }
}
