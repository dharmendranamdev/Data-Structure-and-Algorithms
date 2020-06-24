#include <iostream>
#include<bits/stdc++.h>
using namespace std;
void  ShellSort(int a[],int n)
{
    int i,j,gap;
    for(gap = n / 2; gap >= 1; gap = gap / 2)
    {
        for(j = gap ; j < n; j++)
        {
            for(i = j - gap ; i >=0; i = i - gap)
            {
                if(a[i] < a[i+ gap])
                {
                    break;
                }
                else
                {
                  swap(a[i],a[i+gap]);
                }
            }
        }
    }
}
void Display(int a[],int n){
    int i;
    for(i = 0; i < n; i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
}
int main()
{
    int a[] = {23,29,15,19,31,7,9,5,2};
    int n = sizeof(a) / sizeof(a[0]);
    cout<<"\nBefore Shell Sort--->\n";
    Display(a,n);
    ShellSort(a,n);
    cout<<"\nAfter Applying Shell Sort--->\n";
    Display(a,n);
    return 0;
}
