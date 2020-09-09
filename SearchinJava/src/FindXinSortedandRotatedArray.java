
public class FindXinSortedandRotatedArray {
    static int search(int arr[], int l, int r, int key) 
    { 
        if (l > r) 
            return -1; 
  
        int mid = (l + r) / 2; 
        if (arr[mid] == key) 
            return mid; 
  
        /* If arr[l...mid] first subarray is sorted */
        if (arr[l] <= arr[mid]) { 
            /* As this subarray is sorted, we  
               can quickly check if key lies in  
               half or other half */
            if (key >= arr[l] && key <= arr[mid]) 
                return search(arr, l, mid - 1, key); 
            /*If key not lies in first half subarray,  
           Divide other half  into two subarrays, 
           such that we can quickly check if key lies  
           in other half */
            return search(arr, mid + 1, r, key); 
        } 
        /* If arr[l..mid] first subarray is not sorted,  
           then arr[mid... h] must be sorted subarry*/
        if (key >= arr[mid] && key <= arr[r]) 
            return search(arr, mid + 1, r, key); 
  
        return search(arr, l, mid - 1, key); 
    }
    public static void main(String[] args) {
        int a[] = { 10 ,20, 30, 40 , 5, 7, 8};
        int n = a.length;
        int x = 30;
        System.out.println(x+" element is present at index : "+search(a, 0, n - 1, x));
        x = 7;
        System.out.println(x+" element is present at index : "+search(a, 0, n - 1, x));
        x = 8;
        System.out.println(x+" element is present at index : "+search(a, 0, n - 1, x));
        x = 25;
        System.out.println(x+" element is present at index : "+search(a, 0, n - 1, x));
    }
}
