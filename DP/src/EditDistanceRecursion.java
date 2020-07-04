import java.util.*;

/*
    I : str1 = "cat" , str2 = "cut"
    O : 1, we can convert str1 into str2 by replacing 'a' with 'u'
  
    I : str1 = "sunday",  str2 = "saturday"
    O : 3, 1) replace 'n' with 'r'
           2) insert 't'
           3) insert 'a'
*/
//Application of LCS

public class EditDistanceRecursion
{
    
    static int minimum(int a, int b, int c)
    {
        return Integer.min(Integer.min(a, b), c);
    }      
      
    static int ed(String str1, String str2, int m, int n)
    {
        if(m == 0)
           return n; //n insert operation needed{n character will ne inserted into str1}
        if(n == 0)   //n delete operation needed{there is m extra character so we need to delete them}
            return m;
        if(str1.charAt(m-1) == str2.charAt( n-1)) //if character are matching ,no need to perform any operation
        {
            return ed(str1, str2, m - 1, n - 1);
        }
        else
        {
            int insertOp = ed(str1, str2, m, n-1);//insertion
            int removeOp = ed(str1, str2, m - 1, n); //remove
            int replaceOp = ed(str1, str2, m - 1, n -1);//replace
            return 1 + minimum(insertOp, removeOp, replaceOp);//which one gives minimum we consider that, add 1 to it
            //1 : we perform one operation any of them
        }
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
