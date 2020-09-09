//given an infinite size array and element x, find x in infinite sorted array
//for the large size of array General Binary search algorithm is not benefecial
//we use modified binary search
public class InfiniteSortedArray {
    static int binarysearch(int a[], int x, int l, int r)
    {
        if(l > r)
            return -1;
        int mid = l + (r - l) / 2;
        
        if(a[mid] == x)
            return mid;
        else if(a[mid] > x)
            return binarysearch(a, x, l, mid - 1);
        else
            return binarysearch(a, x, mid + 1, r);
    }
    static int infiniteSearching(int a[], int n, int x)
    {
        if(a[0] == x)
            return 0;
        int i = 1;
        while(a[i] < x)
            i = i * 2;
        return binarysearch(a, x, i / 2, i);
    }
    public static void main(String[] args) 
    {
        int a[] = {1,2,4,5,6,8,9,11,12,13,15,17,19,20,22,25,26,29,30,32,33,37,38,39,40,41,42,45,47,49,50,55,56,57,58,59};
        int n = a.length;
        int x = 45;
        System.out.println(" element is present at index : "+infiniteSearching(a, n, 45));
        
    }
}
