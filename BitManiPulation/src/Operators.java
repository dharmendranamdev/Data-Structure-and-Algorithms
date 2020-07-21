
public class Operators {
    public static void main(String[] args) {
        
        int a = 9;
        int b = 1;
        System.out.println(a|b);//or
        System.out.println(a&b); //and
        System.out.println(a^b); //XOR
        System.out.println(~a); //Not
        System.out.println(~b); //Not
        
        System.out.println("");
        
        System.out.println(a>>b);//shift right   ceil( a / 2^b )
        System.out.println(a<<b);//shift left   a * 2^b
        System.out.println(a>>>b);
        
    }
}
