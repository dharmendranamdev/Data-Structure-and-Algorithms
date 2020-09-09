public class BinarySearch {    
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
    public static void main(String[] args) {
        int a[] = {1 ,4, 6, 12, 56, 77 ,79,80, 90, 95,101};
        int n = a.length;
        int x = 12;
        int p = binarysearch(a, x, 0, n - 1);
        if(p == -1)
            System.out.println(x +" is not present..");
        else
            System.out.println(x+" is present at "+ p + " index ");
    }
}
