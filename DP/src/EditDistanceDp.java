import java.util.*;
import javax.accessibility.AccessibleRole;

/*
operation such as  : insert, remove,replace

    I : str1 = "cat" , str2 = "cut"
    O : 1, we can convert str1 into str2 by replacing 'a' with 'u'
  
    I : str1 = "sunday",  str2 = "saturday"
    O : 3, 1) replace 'n' with 'r'
           2) insert 't'
           3) insert 'a'
*/
//Application of LCS

public class EditDistanceDp
{
    
    static int minimum(int a, int b, int c)
    {
        return Integer.min(Integer.min(a, b), c);
    }      
      
    static int ed(String str1, String str2, int m, int n)
    {
        int table[][] = new int[m+1][n+1];
        
        for(int i = 0; i < m + 1; i++)
            table[i][0] = i;
        for(int i = 0; i < n + 1; i++)
            table[0][i] = i;
        
        for (int i = 1; i < m + 1; i++) 
        {
            for(int j = 1; j < n + 1; j++)
            {
                if(str1.charAt(i-1) == str2.charAt(j-1))
                {
                    table[i][j] = table[i-1][j-1];
                }
                else
                {
                    int insertOp = table[i][j-1];//insertion
                    int removeOp = table[i-1][j]; //remove
                    int replaceOp = table[i-1][j-1];//replace
                    table[i][j] = 1 + minimum(insertOp, removeOp, replaceOp);
                }
            }    
        }
        
        return table[m][n];
    }
    public static void main(String[] args) 
    {
        String str1 = "sunday";
        String str2 = "tuesday";
        int m = str1.length();
        int n = str2.length();
        System.out.println("Minimum no of operation(edits) required to convert str1 to str 2 : "+ed(str1,str2,m,n));
        
        str1 = "royele";
        str2 = "royale";
        m = str1.length();
        n = str2.length();
        System.out.println("Minimum no of operation(edits) required to convert str1 to str 2 : "+ed(str1,str2,m,n));
        
        str1 = "dhooni";
        str2 = "dhoni";
        m = str1.length();
        n = str2.length();
        System.out.println("Minimum no of operation(edits) required to convert str1 to str 2 : "+ed(str1,str2,m,n));
        
        str1 = "amazem";
        str2 = "amazon";
        m = str1.length();
        n = str2.length();
        System.out.println("Minimum no of operation(edits) required to convert str1 to str 2 : "+ed(str1,str2,m,n));
        
        
    }
}
