import java.util.*;

public class Equal_0s1s {
    
    
    
    // TC : O(n) and SC : O(n)
    static int maxLenSubArray(int a[], int n)
    {
        //convert 0 to -1
        for(int i =0 ; i < n; i++)
        {
            if(a[i] == 0)
                a[i] = -1;
        }
        HashMap<Integer,Integer>hm = new HashMap<>();
        int sum = 0;
        int maxlen = 0;
        int endindex = -1;
        
        for(int i = 0; i < n; i++)
        {
            sum += a[i];
            
            if(sum == 0)
            {
                maxlen = i + 1;
                endindex = i;
            }
             // If this sum is already occured before, 
            // then update max_len if required
            if(hm.containsKey(sum+n))
            {
                if(maxlen < i - hm.get(sum + n))
                {
                    maxlen = i - hm.get(sum + n);
                    endindex = i;
                }
            }
            else
                hm.put(sum+n, i);
        }
        int startindex = endindex - maxlen + 1;
        System.out.println(startindex + " to " + endindex);
        return maxlen;
        
    }
    public static void main(String[] args) {
        int a[] = { 1, 0, 0, 1, 0, 1, 1 };
        System.out.println("Max Length : "+maxLenSubArray(a,a.length));
        
        a = new int[]{1,1,1,1,1,0,0,0,1,1,0,0,1};
        System.out.println("Max Length : "+maxLenSubArray(a,a.length));
    }
}
