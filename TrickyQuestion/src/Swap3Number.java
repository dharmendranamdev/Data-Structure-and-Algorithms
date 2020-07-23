//swapping 3 number without any temperrory variable;
public class Swap3Number {
    
    static void swap(int a, int b, int c)
    {
        a = a + b + c;
        b = a - (b + c);
        c = a - (b + c);
        a = a - (b + c);
        System.out.println("a : "+a+" b:"+b+" c:"+c);
    }
    static void swapWithXOR(int a, int b, int c)
    {
        a = a ^ b ^ c;
        b = a ^ b ^ c;
        c = a ^ b ^ c;
        a = a ^ b ^ c;
        System.out.println("a : "+a+" b:"+b+" c:"+c);
    }
    public static void main(String[] args) {
        int a,b,c;
        
        //all +ve
        a = 10; b = 9; c= 4;
        swap(a, b, c);
        swapWithXOR(a, b, c);
        
        //all -ve
        a = -10; b = -7; c= -4;
        swap(a, b, c);
        swapWithXOR(a, b, c);
        
        //if some of them are 0
        a = 0; b = -6; c= -4;
        swap(a, b, c);
        swapWithXOR(a, b, c);
        
        
    }
}
