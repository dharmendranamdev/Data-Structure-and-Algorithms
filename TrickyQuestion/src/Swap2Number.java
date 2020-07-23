//swapping 2 number without any temperrory variable;
public class Swap2Number {
    
    static void swap(int a, int b)
    {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a : "+a+" b:"+b);
    }
    static void swapWithXOR(int a, int b)
    {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a : "+a+" b:"+b);
    }
    public static void main(String[] args) {
     
        
        //Both are +ve
        int a = 10, b = 8;
        swap(a, b);
        swapWithXOR(a, b);
        
        //Both are -ve
        a = -10; b = -8;
        swap(a, b);
        swapWithXOR(a, b);
        
        
        //one of them is 0
        a = 10; b = 0;
        swap(a, b);
        swapWithXOR(a, b);
        
        
        
    }
}
