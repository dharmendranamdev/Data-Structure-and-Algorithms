
import javafx.scene.control.Tab;


public class LCSDp {
    
    //you can start from right side of string as well,
    //but here i will start from end
    static int lcs(String str1, String str2, int m, int n)
    {
        int table[][] = new int[m+1][n+1];
        
        for(int i = 0; i < m; i++) //m rows are there
        {
            table[i][0] = 0;//first col
        }
        for(int i = 0; i < n; i++) // n no of clumns are there
        {
            table[0][i] = 0;//first row
        }
        for(int i = 1; i < m + 1; i++)
        {
            for(int j = 1; j < n + 1; j++)
            {
                if(str1.charAt(i-1) ==  str2.charAt(j - 1))
                {
                    table[i][j] = 1 + table[i-1][j - 1]; //just put the , 1 + diagonal value(curent max len) 
                                                        //now max len = 1 + diagonal value
                }
                else
                {
                    table[i][j] =  Integer.max(table[i-1][j], table[i][j-1]); // max (above cell, left cell) 
                    //ignore last character of str1  : above cell value
                    //ignoring last character of str2 : left cell value
                }
            }
        }
        return table[m][n];
    } 
    public static void main(String[] args) {
        String str1 = "AGGTAB"; 
        String str2 = "GXTXAYBBB";  
        int m = str1.length();
        int n = str2.length();
        System.out.println("(Recursion)Longest common substring length : "+lcs(str1,str2,m,n));
    }
    
}
