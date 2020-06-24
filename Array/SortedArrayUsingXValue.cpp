//k sorted Array
#include<iostream>
#include<bits/stdc++.h> 
using namespace std;
void insertionSort(int a[], int n,int x) 
{ 
    for(int i = 0; i < n; i++)
    {
        int j = i;
        while(j > 0 && abs(x - a[j]) < abs(x - a[j-1]))
        {
            int temp = a[j-1];
            a[j-1] = a[j];
            a[j] = temp;
            j--;
            
        }
    }
}
void display(int a[],int n)
{
    for(int i = 0; i < n; i++)
    {
        cout<<a[i]<<"\t";
    }
    cout<<endl;
}
int main(){
    int a[] = {2, 6, 8, 3};
    int n = sizeof(a) / sizeof(a[0]);
    int x = 5;
    display(a,n);
    insertionSort(a,n,x);
    display(a,n);
    
    return 0;
}