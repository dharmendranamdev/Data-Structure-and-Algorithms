//Chech kth bit from right is set or not
public class BilManipulationProblem1 {
    
    
    static void isSet(int n, int k)
    {
         if(( n & (1<<(k -1)) ) != 0)
            System.out.println("True");
        else
            System.out.println("False");
    }
    
    public static void main(String[] args) {
        
        int n = 89; // 1011001
        int k = 4;
        isSet(n, k);
        
        n = 89;
        k = 3;
        isSet(n, k);
    }
}
