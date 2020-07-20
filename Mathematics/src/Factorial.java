import java.util.*;
import java.math.*;
public class Factorial {
    
    //Recursion Approach : O(2^n)
    static int fact1(int n)
    {
        if(n == 0 || n == 1)
            return 1;
        return n * fact1(n-1);
    }
    static long fact2(long n)
    {
        return (n == 0 || n == 1) ? 1 : n * fact2(n-1);
    }
    
    //Iteration  : o(n)
    static int fact3(int n)
    {
        int res = 1;
        for(int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
    static long fact4(long n)
    {
        long res = 1;
        for(int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
    
    //Using Big Integer
    public static BigInteger fact5(long n) 
    {
        BigInteger num = BigInteger.valueOf(n);  //or     BigInteger num = new BigInteger(n + "" );
        
        BigInteger res = BigInteger.valueOf(1);//   or     res = 1
        
        for (long i = 2; i <= num.longValue(); i++)// 2 to n
        {
            res = res.multiply(BigInteger.valueOf(i)); //   res = res * i;
        }
        return res; //return res;
    }
    
    //Using Formula : 
    public static void main(String[] args) {
        
        //Time : Exponenetially
        System.out.println("Recursion int : "+fact1(12));//Recursion int will give the correct factorial up to " n = 12 "
        System.out.println("Recursion long : "+fact2(20)+"\n");//Reacursion long will give the correct factorial up to " n = 20 "
        
        //Time : O(n)
        System.out.println("Iteration int : "+fact3(12));   //Iteration int will give the correct factorial up to " n = 12 "
        System.out.println("Iteration long :"+fact4(20)+"\n"); //Iteration long will give the correct factorial up to " n = 20 "
        
        
        System.out.println("Big Integer 10: "+fact5(20));  //No Limit
        System.out.println("Big Integer 20: "+fact5(100)+"\n");
    }
}
