//Fibonacci Series : 0,1,1,2,3,5,8,13,.................
//or   1,1,2,3,5,8,13....................
public class Fibonacci {
    static int memo[];
    static int getFiboNumber(int n)
    {
        int t1 = 0;
        int t2 = 1;
        int t3;
        for (int i = 1; i <= n; ++i)
        {
            //System.out.print(t1+" ");
            if(i == n){
                //System.out.println();
                return t1;
            }
            t3 = t1 + t2;
            t1 = t2;
            t2 = t3;
        }
        return 1;
    }
    static int getFiboRec(int n)
    {
        if(n <= 1)
            return n;
      
        
        return getFiboRec(n - 1) + getFiboRec(n - 2);
    }
    
    static int fiboByMemo(int n)
    {
        if(memo[n] != 0)
            return memo[n];
        if(n <= 1)
            return n;
        memo[n] = fiboByMemo( n - 1) + fiboByMemo(n - 2);
        return memo[n];
    }
    //Using Formula
    //Fn = {[(√5 + 1)/2] ^ n} / √5
    static int fibFormula(int n) 
    { 
        double p = (1 + Math.sqrt(5)) / 2; 
        return (int) Math.round(Math.pow(p, n) / Math.sqrt(5)); 
    } 
    public static void main(String[] args) {
        
        //Recursive:
        int n = 19;
        System.out.println(n+ " th fibonaci series number : "+ getFiboRec(n));
        
        
        //Memoization
        n = 6;
        memo =  new int[n+1];
        System.out.println(n+ " th fibonaci series number : "+ fiboByMemo(n));
        
        //Iterative
        n = 10;
        System.out.println(n+" th number of fibo series :  "+  getFiboNumber(n));
        
        //Using Formula
        n = 18;
        System.out.println(n+" th number of fibo series :  "+ fibFormula(n));
        
        n = 1;
        System.out.println(n+" th number of fibo series :  "+  fibFormula(n));
        
        
    }
}
