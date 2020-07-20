import java.math.*;
public class NoOfDigits {
    
    static int getDigitByFormula(int n)
    {
        double val = Math.log10(n) + 1;
        return (int)Math.floor(val);
    }
    static int getNoOfDigits(int n)
    {
        int count = 0;
        while(n != 0)
        {
            n = n / 10;
            count++;
        }
        return  count;
    }
    static int recDigits(int n)
    {
        if( n == 0)
            return n;
        return 1 + recDigits( n / 10);
    }
    public static void main(String[] args) {
        //iteration
        System.out.println("Using Iteration--------->");
        int n = 123;
        System.out.println("Digit in "+n+ " number : "+getNoOfDigits(n));
       
        n = 12;
        System.out.println("Digit in "+n+ " number : "+getNoOfDigits(n));
        
        n = 9;
        System.out.println("Digit in "+n+ " number : "+getNoOfDigits(n));
        
        //Recursion
        System.out.println("Using Recursion--->");
        n = 1234;
        System.out.println("Digit in "+n+ " number : "+recDigits(n));
        n = 4;
        System.out.println("Digit in "+n+ " number : "+recDigits(n));
        
        //By Formula
        System.out.println("--->Using Formula");
       
        n = 1234;
        System.out.println("Digit in "+n+ " number : "+ getDigitByFormula(n));
        n = 123;
        System.out.println("Digit in "+n+ " number : "+ getDigitByFormula(n));
        n = 12;
        System.out.println("Digit in "+n+ " number : "+ getDigitByFormula(n));
        n = 4;
        System.out.println("Digit in "+n+ " number : "+ getDigitByFormula(n));
        
    }
}
