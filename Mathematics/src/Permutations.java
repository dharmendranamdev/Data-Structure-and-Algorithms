import java.util.*;
import java.math.*;
public class Permutations {
    
    static long temp[];
    
    static long fact(int n)
    {
        long res = 1;       
        temp[0] = temp[1] = 1;
        for(int i = 2; i <= n; i++)
        {
            res = res * i;
            temp[i] = res;
        }
        return res;
    }
    //Using Big Integer : as well as we store result on tempArray
    public static BigInteger bigFact(long n) 
    {
        BigInteger num = BigInteger.valueOf(n);  //or     BigInteger num = new BigInteger(n + "" );
        
        BigInteger res = BigInteger.valueOf(1);//   or     res = 1
        
        for (long i = 2; i <= num.longValue(); i++)// 2 to n
        {
            res = res.multiply(BigInteger.valueOf(i)); //   res = res * i;
        }
        return res; //return res;
    }
    
    public static void main(String[] args) {
        int n = 15;
        int r = 5;
        
        temp = new long[n+1];
        long perm = fact(n) / temp[n-r];
        System.out.println(" ✔ Permutation of "+ n +" things taken "+ r+ " at time : "+perm);
        
        n = 20;
        r = 8;
        temp = new long[n+1];
        perm = fact(n) / temp[n-r];
        System.out.println(" ✔ Permutation of "+ n +" things taken "+ r+ " at time : "+perm);
        
        n = 20;            ///Nice Working Till n = 20
        r = 18;
        temp = new long[n+1];
        perm = fact(n) / temp[n-r];
        System.out.println(" ✔ Permutation of "+ n +" things taken "+ r+ " at time : "+perm);
        
        //---------------------------------Not working above 20--------------------
        
        n = 25;
        r = 8;
        temp = new long[n+1];
        perm = fact(n) / temp[n-r];
        System.out.println(" ❌ WRONG! Permutation of "+ n +" things taken "+ r+ " at time : "+perm);
        
        
        
        n = 2000;            ///No Limit
        r = 18;
        
        BigInteger bigCombination = bigFact(n).divide(bigFact(n-r));  //  n! / (n-r)!
        System.out.println(" ✔ Permutation of "+ n +" things taken "+ r+ " at time : "+bigCombination);
        
    }
}
