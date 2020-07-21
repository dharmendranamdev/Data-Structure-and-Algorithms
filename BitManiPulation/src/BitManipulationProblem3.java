//counting number of set bits
//Brian Kernighan’s Algorithm
//Time complexity : O(no of set bits) or O(logn)
public class BitManipulationProblem3 {
    
    static int getNoOfSetBits(int n)
    {
        int res = 0;
        while(n > 0)
        {
            n = ( n & (n - 1) );
            res++;
            //System.out.println(n);
        }
        return res;
    }
    public static void main(String[] args) {
        
        int n = 89;
        System.out.println("no of set bits in "+n+" is : "+getNoOfSetBits(n));
        n = 13;
        System.out.println("no of set bits in "+n+" is : "+getNoOfSetBits(n));
        
    }
}
