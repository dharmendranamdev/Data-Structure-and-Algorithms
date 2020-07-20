import java.math.*;
public class LCM {
    
    static int getLcm(int n1, int n2)
    {
        int max = Math.max(n1, n2);
        //int min = Math.min(n1, n2);
        int i = max;
        while(true)
        {
           if( i % n1 == 0 && i % n2 == 0)
               return i;
           i = i + max;
        }      
    }
    static int gcd(int a, int b)
    {
        if(b == 0)
           return a;
        return gcd(b, a % b);
    }
    static int getLcmByGCD(int n1, int n2)
    {
        return (n1 * n2 )/ gcd(n1, n2);
    }
    public static void main(String[] args) {
        int n1 = 15;
        int n2 = 20;
        System.out.println("LCM of "+n1+" and  "+n2+" is : "+getLcm(n1, n2));
        
        n1 = 60;
        n2 = 26;
        System.out.println("LCM of "+n1+" and  "+n2+" is : "+getLcm(n1, n2));
        
        
        n1 = 60;
        n2 = 26;
        System.out.println("LCM of "+n1+" and  "+n2+" is : "+getLcmByGCD(n1, n2));
        
    }
}
