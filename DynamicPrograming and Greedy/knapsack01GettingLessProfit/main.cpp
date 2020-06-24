/*
 Given infinite supply of coins of different denominations and certain amount.
how many ways these coins can be combined to get the given amount w.
*/


// ----------------Work In Progress----------------------


/*
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

void PrintArray(int a[],int n)
{
    for(int i = 0; i < n; i++)
    {
        cout<<a[i]<<" ";
    }
    cout<<"\n";
}
void MySorting(int a[],int b[],int n)
{
    for(int i = 1; i < n; i++)
    {
        int  j = i;
        while(j > 0 && a[j-1] > a[j])
        {
            swap(a[j-1],a[j]);
            swap(b[j-1],b[j]);
            j--;
        }
    }
}
int Knapsack01(int wt[],int p[],int n,int w)
{
    //sorting the weights and correspondence to profit
    MySorting(wt,p,n);

    cout<<"\n\n-----After Sorting the weights and correspondence to its profit--\n\n";
    PrintArray(wt,n);
    PrintArray(p,n);

    cout<<"\n\n\n";

    //table declaration
    int Table[n+1][w+1];

    for(int i = 0; i < w + 1; i++)//choose 0 weight,you can't make any amount(Row)
    {
        Table[0][i] = INT_MAX;
    }
    for(int i =0; i < n+1; i++)//first coulmn initialize with 0,making 0 amount,no need to pick coin
        Table[i][0] = 0;

    for(int i = 1 ; i < n + 1; i++)
    {
        for(int j = 1; j < w + 1; j++)
        {
            if(wt[i-1] > j)//if coin value > amount then  select above cell value
            {
                Table[i][j] = Table[i-1][j];
            }
            else
            {
                Table[i][j] = min(Table[i-1][j] , p[i-1] + Table[i-1][j - wt[i -1]] );
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
    cout<<"\nX-------------------0 / 1 Knapsack Problem----------------------X\n\n\n";
    int weights[] = {1,2,3,4,5};
    int profits[] = {12,22,27,32,40};
    int n = sizeof(weights) / sizeof(weights[0]);
    int w = 10; // we have to fill that bag(with amount w) from given weights such that we get maximum profit
    int x = Knapsack01(weights,profits,n,w);
    cout<<"\n\nMaximum Profit that you can acheive with  "<<w <<" Amount : "<<x;
    cout << "\n\n\n"<< endl;
    return 0;
}
*/
