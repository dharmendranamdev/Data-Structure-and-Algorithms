

public class FindNoOf1inBinarySortedOrder {
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
        
        int a[] = {0,0,1,1,1,1};
        int n = a.length;
        
        int left_most_index = binarysearch(a, 1, 0, n - 1);
        
        int count = n - left_most_index;
        
        System.out.println(" no of 1's : "+count);
        
        
        a = new int[]{0,0,1,1,1,1,1,1};
        n = a.length;
        left_most_index = binarysearch(a, 1, 0, n - 1);
        count = n - left_most_index;
        System.out.println(" no of 1's : "+count);
        
        a = new int[]{1,1,1,1};
        n = a.length;
        left_most_index = binarysearch(a, 1, 0, n - 1);
        count = n - left_most_index;
        System.out.println(" no of 1's : "+count);
        
        
        a = new int[]{0,0,0,0};
        n = a.length;
        left_most_index = binarysearch(a, 1, 0, n - 1);
        
        if(left_most_index == -1)
            count = 0;
        else
            count = n - left_most_index;
        System.out.println(" no of 1's : "+count);
    
    }
    
}
