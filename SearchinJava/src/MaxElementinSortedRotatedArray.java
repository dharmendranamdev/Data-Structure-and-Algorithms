/*
find the maximum element in Rotated Sorted Array
arr1[] =  {5, 6, 1, 2, 3, 4}; 
ans = 6
 */
public class MaxElementinSortedRotatedArray {
    
    static int findMin(int arr[], int low, int high) 
    { 
        //when array is not rotated at all 
        if (high < low)  
            return arr[0]; 
  
        // If there is only one element left 
        if (high == low) 
            return arr[low]; 
  
        
        int mid = low + (high - low)/2; 
  
        // Check if element (mid-1) is maximum element. Consider 
        // the cases like {4, 5, 1, 2, 3} 
        if (mid > low && arr[mid-1] > arr[mid]) 
            return arr[mid-1]; 
  
        // Check if mid itself is maximum element 
        //consider the case {7,9,15,2,4}
        if (mid < high && arr[mid] > arr[mid +1]) 
            return arr[mid]; 
  
        // Decide whether we need to go to left half or right half 
        //array is sorted only : case --> like {10,20,30,40,50} else part
        if (arr[low] > arr[mid]) 
            return findMin(arr, low, mid-1);
        else
            return findMin(arr, mid+1, high); 
    } 
    public static void main(String[] args) {
        int a[] = {15,20,30,40,50,6,7 ,8};
        int n = a.length;
        System.out.println("minimum : "+findMin(a, 0, n - 1));
        
        a = new int[]{10,20,5,7,8};
        n = a.length;
        System.out.println("minimum : "+findMin(a, 0, n - 1));
        
        
        a = new int[]{10,20,30,40};
        n = a.length;
        System.out.println("minimum : "+findMin(a, 0, n - 1));
        
        
    }
}
