
import java.util.*;

public class LargestRectangularAreaInHistogram {
    //Naive Solution : O(n^2)
    static int LargestArea(int a[], int n)
    {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++)
        {
            int cur = a[i];
            //left
            for(int j = i - 1; j >= 0; j--)
            {
                if(a[i] <= a[j])
                    cur += a[i];
                else
                    break;
            }
            //right
            for(int j = i + 1; j < n; j++)
            {
                if(a[i] <= a[j])
                    cur += a[i];
                else
                    break;
            }
            max = Integer.max(max, cur);
        }
        return max;
    }
    //Efficeint Solution: O(n) 
    //using stack
    //1) initialize res = 0;
    //2) previous smaller element for every element
    //3) next smaller element for every element
    //4) cur = A[i]
    //   cur +=  ( i - ps[i] - 1 ) * A[i];
    //   cur +=  ( ns[i] - i - 1) * A[i]
    //   res = max(res,cur)
    //   return res;
    static void previousSmaller(int a[], int ps[], int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(0);//first index
        ps[0] = -1;//FIRSt item that's why
        
        for(int i = 1; i < n; i++)
        {
            
            while(s.isEmpty() == false && a[i] < a[s.peek()] )
            {
                s.pop();
            }
            ps[i] = (s.isEmpty()) ? -1 : ( s.peek());
            //System.out.println(ps[i]+" " + a[i] + " stack : "+s);
            s.push(i);
        }
        
    }
    static void nextSmaller(int a[], int ns[], int n)
    {
        Stack<Integer> s = new Stack<>();
        s.push(n-1);
        ns[n-1] = n;
        
        for(int i = n - 2; i >= 0 ; i--)
        {
            while(s.isEmpty() == false && a[i] < a[s.peek()] )
            {
                s.pop();
            }
            ns[i] = (s.isEmpty()) ? n : ( s.peek());
            //System.out.println(ns[i]+" " + a[i] + " stack : "+s);
            s.push(i);
        }
    }
    static int largeAreaUsingStack(int a[], int n)
    {
        //previous smaller element for each elements in array,opposite approach of previous greater
        int ps[] = new int[n];
        previousSmaller(a,ps,n);
        
         //next smaller element for each elements in array,opposite approach of next greater
        int ns[] = new int[n];
        nextSmaller(a,ns,n);
        
        int res = 0;
        for(int i = 0; i < n; i++)
        {
            int cur = a[i];
            cur +=  ( i - ps[i] - 1 ) * a[i]; //previous smaller
            cur +=  ( ns[i] - i - 1) * a[i];  //next smaller
      
            res = Integer.max(res, cur);
        }    
        return res;
        
    }
    public static void main(String[] args) {
        int a[] = { 6, 2, 5, 4, 5, 1, 6 }; 
        System.out.println("Maximum area is " + LargestArea(a, a.length)); 
        
        a = new int[]{ 6, 2, 5, 4, 1, 5, 6 }; 
        System.out.println("Maximum area is " + LargestArea(a, a.length)); 
        
        System.out.println("Effiecient approach Using Stack ...");
           System.out.println("Maximum area is " + largeAreaUsingStack(a, a.length)); 
    }
}
