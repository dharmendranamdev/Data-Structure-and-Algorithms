import java.util.*;
public class MatrixChainMulltiplication 
{
    static int dp(int di[], int n)
    {
        int table[][] = new int[n][n];
        int result[][] = new int[n][n];
        
        for(int i = 0; i < n; i++)
        {
            table[i][i] = 0;//diagonal
            table[0][i] = 0;//first row
            table[i][0] = 0;//first col
        }
        
        for(int gap = 1; gap < n - 1; gap++)
        {
            for(int i = 1; i < n - gap; i++)
            {
                int j = i + gap;
                int min = Integer.MAX_VALUE;
                for(int k = i; k <= j - 1 ; k++)
                {
                    int val = table[i][k] + table[k+1][j] + di[i-1] * di[k] * di[j];
                    if(min > val)
                    {
                        min = val;
                        result[i][j] = k;
                    }
                }
                table[i][j] = min;
            }
        }
        /*
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        */
        /*
        int a = result[1][n-1]; // 3 ---> (A1.A2.A3).A4
        int b = result[1][a];
        System.out.println(b);// 1---> (A1.(A1.A2)).A4
         
        */
        return table[1][n-1];
             
    }
    public static void main(String[] args) 
    {
        int dimensions[] = new int[]{5,4,6,2,7};
        int n = dimensions.length;
        System.out.println("Minimum No of Multiplication required : "+ dp(dimensions, n));
        
       
    }
}
