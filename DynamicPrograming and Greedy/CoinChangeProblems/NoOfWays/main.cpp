/*
 Given infinite supply of coins of different denominations and certain amount.
how many ways these coins can be combined to get the given amount w.
*/
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

int NoOfWaysTOMakeAmountW(int c[], int n, int w)
{
    int Table[n+1][w+1];

    for(int i = 0; i < w + 1; i++)//consider first row for 0th coin
    {
        Table[0][i] = 0;
    }
    for(int i =0; i < n+1; i++)//first coulmn initialize with 1,only 1 way to make changes in 0 amount(which is do nothing)
        Table[i][0] = 1;

    for(int i = 1 ; i < n+1; i++)
    {
        for(int j = 0; j < w + 1; j++)
        {
            if(c[i-1] > j)//if coin value > amount then  select above cell value
            {
                Table[i][j] = Table[i-1][j];
            }
            else
            {
                Table[i][j] = Table[i-1][j] + Table[i][j - c[i-1]];
            }
        }
    }

    for(int i = 0; i < n + 1; i++)
    {
        for(int j = 0; j < w+1 ; j++)
        {
            cout<<Table[i][j]<<" ";
        }
        cout<<endl;
    }
    return Table[n][w];
}
int main()
{
    cout << "\n\n\n"<< endl;
    cout<<"\nX-------------------No of Ways to make  W amount----------------------X\n\n\n";
    int coins[] = {2,3,5,10};//these are coins
    int n = sizeof(coins) / sizeof(coins[0]);
    int w = 15;//i make the amount of W
    int x = NoOfWaysTOMakeAmountW(coins, n, w);
    cout<<"\n\nTotal No Of Ways to make "<<w <<" Amount : "<<x;
    cout << "\n\n\n"<< endl;
    return 0;
}
