//https://www.geeksforgeeks.org/find-distinct-elements-common-rows-matrix/

#include <iostream>
#include<bits/stdc++.h>
//Find distinct elements common to all rows of a matrix
//solution : 1) without sorting the row : n3
        //   2) with sorting the roes : n^2 * log(n)
using namespace std;
int BinarySearch(int a[],int key,int n)
{
    int low = 0,high = n - 1;
    while(low <= high)
    {
        int mid = (low + high ) / 2;
        if(a[mid] == key)
            return 1;
        else if(a[mid] > key)
            high = mid -1;
        else
            low = mid + 1;
    }
    return 0;
}
int main()
{
    cout << " Ques: Find distinct elements common to all rows of a matrix!\n" << endl;
    int m = 3,n = 4;
    int a[m][n] = {{1,2,17,3},{2,3,4,17},{1,17,2,5}};
    for(int i = 0; i < m; i++)
    {
        for(int j = 0; j < n; j++)
        {
            cout<<a[i][j]<<" ";
        }
        cout<<"\n";
    }

    //1)      without sorting the row : n3
    //Distinct Node
    cout<<"--------Distinct Node---------\n";
    int find;
    for(int i = 0; i < n; i++){
        for(int j = 1; j < m; j++){
            find = 0;
            for(int  k = 0; k < n; k++){
                if(a[0][i] == a[j][k]){
                    find = 1;
                    break;
                }
            }
            if(find != 1)//no need to search for another rows or if last row doesn't have a[0][i]
                break;
        }
        if(find == 1){
            cout<<a[0][i]<<"\t";
        }
    }

    cout<<"\n\n\n\n";

    //2)     with Sorting the Row

     //for sorting a rows
    for(int i = 0; i < m; i++)
        sort(a[i],a[i]+n);
    //real algo
    int find1;
    for(int i = 0; i < n; i++){
        for(int j = 1; j < m; j++){
            find1 = 0;
            if(BinarySearch(a[j],a[0][i],n))
                find1 = 1;
            if(find1 != 1)//no need to search for another rows or if last row doesn't have a[0][i]
                break;
        }
        if(find1 == 1){
            cout<<a[0][i]<<"\t";
        }
    }
    return 0;
}
