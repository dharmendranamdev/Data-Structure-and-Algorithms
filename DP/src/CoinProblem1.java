import java.util.*;
import java.lang.*;

// Number of Ways to make given amount w
public class CoinProblem1 {
    
    static int noOfWays(int coins[], int n, int w)
    {
        int table[][] = new int[n+1][w+1];
        
        for(int i = 0; i < w + 1; i++) //1st row, To make amount w from 0th coin. There is no way Hence, '0'
            table[0][i] = 0;
        for(int i = 0; i < n + 1; i++) //1st col, To make 0 amount from given coins ,there is one way, Don't select that coin
            table[i][0] = 1;
        
        for(int i = 1; i < n+1; i++)
        {
            for(int j = 1; j < w+1; j++)
            {
                if(coins[i-1] > j) // coin value is greater than given amount
                {
                    table[i][j] = table[i-1][j]; //copy above value
                }
                else
                {
                    int exclude = table[i-1][j]; //excluding the coin
                    int include = table[i][j - coins[i-1]];//including the coin
                    table[i][j] = exclude + include;//add 1 + 2
                }           
            }
        }
        return table[n][w];
    }
    public static void main(String[] args) {
        //int coins[] = {2,3,5,10};
        int coins[] = {2,3,5,15};
        
        int n = coins.length;
        
        int w = 10;
        System.out.println("No of ways to make amount "+ w + " is : " + noOfWays(coins,n,w));
    }
}
