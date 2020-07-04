import java.util.*;
import java.lang.*;

// Number of Ways to make given amount w
public class CoinProblem2 {
    
    static int MinCoinToMakeAmountW(int coins[], int n, int w)
    {
        int dp[] = new int[w+1];
        
        dp[0] = 0; //first value would be 0
         
        for(int i = 1; i < w + 1; i++) //remaining value would be infinity
        {
            dp[i] = Integer.MAX_VALUE;//infinity
        }
        for(int i = 1; i < w + 1; i++)//i = 1,2,3,4.............w amount
        {
            for(int j = 0; j < n; j++) //j = getting coins one by one
            {
                if(coins[j] <= i) //we camplare each coin with i(amount)
                {
                    int sub_res = dp[i - coins[j]];
                    if(sub_res != Integer.MAX_VALUE)
                        dp[i] = Integer.min(dp[i], sub_res + 1);
                }
            }
        }
        return dp[w];
        
    }
    public static void main(String[] args) {
        //int coins[] = {2,3,5,10};
        int coins[] = {1,5,6,9};
        int n = coins.length;
        int w = 10;
        System.out.println("No of ways to make amount "+ w + " is : " + MinCoinToMakeAmountW(coins,n,w));
        
        
        coins = new int[]{3,4,1};
        n = coins.length;
        w = 5;
        System.out.println("No of ways to make amount "+ w + " is : " + MinCoinToMakeAmountW(coins,n,w));
        
        coins = new int[]{10,5,15,20};
        n = coins.length;
        w = 30;
        System.out.println("No of ways to make amount "+ w + " is : " + MinCoinToMakeAmountW(coins,n,w));
        
         coins = new int[]{2,3,5,10};
        n = coins.length;
        w = 10;
        System.out.println("No of ways to make amount "+ w + " is : " + MinCoinToMakeAmountW(coins,n,w));
    }
}
