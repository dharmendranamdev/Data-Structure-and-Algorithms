import java.util.*;
//Time complexity :    O ( Time to print 1 permutation * no of permutation )
//          1) Time to print 1 permutation  = Depth of Tree = length of string = n
//          2) no of permutation of string with length n =  n!
//          so Time complexity : O(n * n! )
public class StringPermutation {
    
    static int count = 0;
    static void swap(char str[], int i, int j)
    {
        char temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
    static void permute(char str[], int n, int ind)
    {
        if(ind + 1 == n)
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
        System.out.println("\nNo of permutations:"+count);
        System.out.println();
        
        
        
        str = new char[]{'A', 'B' ,'C'};
        len = str.length;
        count = 0;
        permute(str, len, 0);     
        System.out.println("\nNo of permutations:"+count);
        System.out.println();
        
    }
}
