import java.util.*;
//
//       string which doesn't start with 'A' and 'B' --> AB
//
public class StringPermutation1 {
    
    static int count = 0;
    static void swap(char str[], int i, int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    static void permute(char str[], int n, int ind)
    {
        if(ind + 1 == n && str[0] !='A' && str[1] != 'B') //only one character left and 1st and 2nd character respectevely A,B
        { 
            System.out.print(str);
            System.out.print(" ");
            count++;
            return;
        }
        for(int i = ind; i < n; i++)
        {
            swap(str, ind, i); //combination
            permute(str, n, ind + 1);
            swap(str, ind, i); //backtracking
        }
    }
    public static void main(String[] args) {
        
        char str[] = {'A', 'B' ,'C', 'D'}; //string ABC
        int len = str.length;
        count = 0;
        permute(str, len , 0);
        System.out.println("\nNo of permutations which doesn't start with AB:"+count);
        System.out.println();
        
        
        
        str = new char[]{'A', 'B' ,'C'};
        len = str.length;
        count = 0;
        permute(str, len, 0);     
        System.out.println("\nNo of permutations which doesn't start with AB:"+count);
        System.out.println();
        
    }
}
