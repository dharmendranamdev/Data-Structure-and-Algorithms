/*

Find Pair with given sum 
for sorted array : 2 pointer technique
for unsorted array : Hashing Technique


find Tripplet with Given Sum
for sorted array : 2 pointer Technique --> O(n^2)
for unsorted array : you can use both technique
                   1) 2 pointer technique : sort array => O(nlogn) + o(n^2)(2 pointer tehnique)  ==  o(n^2) overall
                   2) hashing takes O(n^2) , and O(n) space complexity

                   2 pointer looks gud bcz don't need extra space
 
 */
package FindSum;


public class FindTrippletInSortedArray {
    static boolean findpair(int a[], int l, int r,int sum)
    {
      
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
    static boolean findtripplet(int a[], int n, int sum)
    {
        for(int i = 0; i < n; i++)
        {
            if(findpair(a, i + 1, n - 1, sum - a[i]))
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int a[] = {10,20,30,45,50,60,80,90,100};
        int sum = 250;
        int n = a.length;
        System.out.println(" tripplet with given sum 250 exist : "+findtripplet(a,n,sum));
        
    }
}
