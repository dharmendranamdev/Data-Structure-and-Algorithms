import java.util.*;
import java.lang.*;

// 0 1 knapsack Problem
public class KnapsackProblem {
    
    static int Knapsack0_1(int weights[], int profits[], int n, int w)
    {
        int table[][] = new int[n+1][w+1];
        
        for(int i = 0; i < w + 1; i++) //1st row, just assign 0 bcz we can put 0 weight in any amounts of beg
            table[0][i] = 0;
        for(int i = 0; i < n + 1; i++) //1st col, can't be filled 0 amount bag by any given weights
            table[i][0] = 0;
        
        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < w+1; j++)
            {
                if(weights[i-1] > j) // coin value is greater than given amount
                {
                    table[i][j] = table[i-1][j]; //copy above value
                }
                else
                {
                    table[i][j] = Integer.max(table[i-1][j], profits[i-1] + table[i-1][j - weights[i-1]] );
                }           
            }
        }
        return table[n][w];
    }
    public static void main(String[] args) {
        //int coins[] = {2,3,5,10};
        int weights[] = {3,4,6,5};
        int profits[] = {2,3,1,4};
        int n = weights.length;
        int w = 8;//Bucket Size
        System.out.println("Maximum Profit You can Achieve is : " + Knapsack0_1(weights,profits,n,w));
        
        
        weights = new int[] { 10, 20, 30 }; 
        profits = new int[] { 60, 100, 120 }; 
        w = 50; 
        n = weights.length; 
        System.out.println("Maximum Profit You can Achieve is : " + Knapsack0_1(weights,profits,n,w));
        
    }
}
