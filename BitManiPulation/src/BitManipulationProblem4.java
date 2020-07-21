//
//  Generate Power set
//
import java.math.*;
public class BitManipulationProblem4 {
    
    static void GeneratePowerset(String str)
    {
        int count = (int)Math.pow(2, str.length());
        for(int i = 0; i < count; i++)
        {
            System.out.println((i+1) + " th power set");
            for(int j = 0; j < str.length(); j++)
            {
                //check jth bit of i is set, print s[j]
                if((i & (i << j)) != 0)
                    System.out.print(str.charAt(j) + "");
            }
            System.out.println();
                
        }
    }
    public static void main(String[] args) {
       
        String str = "ABC";
        System.out.println("power set of "+str+" are :");
        GeneratePowerset(str);
        
        str = "ABCD";
        System.out.println("power set of "+str+" are :");
        GeneratePowerset(str);
        
        
   }
}
