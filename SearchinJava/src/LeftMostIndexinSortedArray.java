/*
Give an sorted array with repeatations, find left most index of element
 */
public class LeftMostIndexinSortedArray {    
    static int binarysearch(int a[], int x, int l, int r)
    {
        if(l > r)
            return -1;
        int mid = l + (r - l) / 2;
        
        if(a[mid] == x && (mid == 0 || a[mid - 1] != x))
            return mid;
        else if(a[mid] >= x)
            return binarysearch(a, x, l, mid - 1);
        else
            return binarysearch(a, x, mid + 1, r);
    }
    public static void main(String[] args) {
        int a[] = {2, 2, 3, 3, 3, 3, 3, 4, 4, 4};
        int n = a.length;
        int x = 2;
        int p;
        p = binarysearch(a, x, 0, n - 1);
        System.out.println("Left most index of "+ x +" is :"+p);
        
        x = 3;
        p = binarysearch(a, x, 0, n - 1);
        System.out.println("Left most index of "+ x +" is :"+p);
        
        x = 4;
        p = binarysearch(a, x, 0, n - 1);
        System.out.println("Left most index of "+ x +" is :"+p);
    }
}
