#include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define M 4
#define N 4

int maximum(int a[],int n)
{
    int maxi = a[0];
    for(int i = 1; i < n; i++)
    {
        if(maxi < a[i])
            maxi = a[i];
    }
    return maxi;
}
void MaxElement(int m ,int n,int a[][N])
{
    //printing the matrix
    for(int i = 0; i < m; i++)
    {
        for(int  j = 0; j < n; j++)
        {
            cout<<a[i][j]<<" ";
        }
        cout<<endl;
    }
    //find max of each row
    for(int i = 0; i < m; i++)
    {
        cout<<i<<" th row maximum : "<<maximum(a[i],n)<<endl;
    }

}
int main()
{
        int arr[][N] = { {3, 4, 1, 8},
                        {1, 4, 9, 11},
                        {76, 34, 21, 1},
                        {2, 1, 4, 5} };
    // Calling the function
        MaxElement(M,N,arr);
}
