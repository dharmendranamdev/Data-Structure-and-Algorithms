// check a given number is a power of 2 or not
//
//
public class BitManipulationProblem2 {
    public static void main(String[] args) {
        int n = 16;
        if(n != 0 && ( n & (n - 1)) == 0)
            System.out.println("True");
        else
            System.out.println("False");
    }
}
