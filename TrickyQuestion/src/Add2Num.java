//Add 2 number without '+' operator
public class Add2Num {
    public static void main(String[] args) {
        int a,b,c;
        a= 10;
        b = 30;
        c = -(-a-b);
        System.out.println("Sum : "+c);
        
        a= 10;
        b = -30;
        c = -(-a-b);
        System.out.println("Sum : "+c);
        
        a= -10;
        b = -30;
        c = -(-a-b);
        System.out.println("Sum : "+c);
       
    }
}
