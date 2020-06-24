#include <iostream>

using namespace std;

void prinArray(int a[],int n)
{
    cout<<"\n";
    for(int i = 0; i < n ; i++)
    {
        cout<<a[i]<<" ";
    }
    cout<<"\n";
}
void DecreasingSort(int a[],int n)
{
    for(int i = 1; i < n; i++)
    {
        int j = i;
        while(j > 0 && a[j-1] < a[j])
        {
            swap(a[j],a[j-1]);
            j--;
        }
    }
}
int Coin_change_greedy(int c[],int n,int m)
{
    cout<<"\nCoins Aray\n";
    prinArray(c,n);
    DecreasingSort(c,n);//sorting array c in decreasing array

    cout<<"\nDecreasing Order\n";
    prinArray(c,n);
    int i = 0,NoOfCoins = 0;
    while(m > 0)
    {
        if(c[i] <= m)//if amount is less than or equal to desired amount m
        {
            m = m - c[i];
            NoOfCoins++;
        }
        else
            i++;
    }
    return NoOfCoins;
}
int main()
{
    cout << "\n\n\n"<< endl;

    int coins[] = {1,15,40,25,80};//these are coins
    int n = sizeof(coins) / sizeof(coins[0]);
    int m = 30;//i make the amount of m such that i pic less amount of coins
    int x = Coin_change_greedy(coins, n, m);
    cout<<"\n\nNo Of Coins (Greedy Approach) : "<<x;
    cout << "\n\n\n"<< endl;
    return 0;
}
