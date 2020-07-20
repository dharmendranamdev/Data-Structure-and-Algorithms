import java.math.*;
public class HCF_or_GCD {
    
    
    static int Hcf_or_gcd(int n1, int n2)
    {
        while(n1 != n2)
        {
            if(n1 > n2)
                n1 = n1 - n2;
            else
                n2 = n2 - n1;
        }
        return n1;
    }
    static int gcd(int a, int b)
    {
        if(b == 0)
           return a;
        return gcd(b, a % b);
    }
    public static void main(String[] args) {
        int n1 = 98;
        int n2 = 56;
        System.out.println("Hcf or GCd of " + n1 + " and "+ n2 +" is : "+ Hcf_or_gcd(n1, n2));
        
        
        n1 = 60;
        n2 = 96;
        System.out.println("Hcf or GCd of " + n1 + " and "+ n2 +" is : "+ Hcf_or_gcd(n1, n2));
        
        n1 = 60;
        n2 = 26;
        System.out.println("Hcf or GCd of " + n1 + " and "+ n2 +" is : "+ Hcf_or_gcd(n1, n2));
        
        
    }
}
