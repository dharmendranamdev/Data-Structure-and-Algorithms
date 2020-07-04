import java.util.*;

//Find LIS in O(nlogn) : 
//1) we take an temp array called tail which is used to store element one by one
//   condition :  if cur_element is greater than previous one then only we insert cur_element in tail array
//                else,  we replace cur_element with ceilIndex th Element
//returrn cur_length of the tail array;                         
public class LIS_nlogn {
    
    static int ceilIdx(int tail[], int l, int r, int x) //takes o(logn)
    {
        while(l < r)
        {
            int m = ( l + r ) / 2;
            if(tail[m] >= x) //if mid element is greater and equal to x the shift 'r' to 'm'
                r = m;
            else             //otherwise shift l to m + 1
                l = m + 1;
        }
        return r;
    }
    static int LisAlgo(int a[], int n)     //O(nlogn) in worst case
    {
        int tail[] = new int[n];
        
        tail[0] = a[0];
        int len = 1;
        
        for(int i = 1; i < n; i++)
        {
            if(a[i] > tail[len - 1])//if cur_element is greater than previous one than just insert cur_element in tail array
            {
                tail[len] = a[i];
                len++;
            }
            else //otherwise, we replace cur_element with ceilIndex th Element
            {
                int c = ceilIdx(tail, 0, len-1, a[i]);
                tail[c] = a[i];
            }
        }
        
        
        return len;
        
        
        
    }
    public static void main(String[] args) {
        int a[]= {6,2,30,4,50,100,7,10};//2,4,7,10 = 4
        int n = a.length;
        
        System.out.println("longest increasing subsequence length : "+LisAlgo(a,n));
        
    }
}
