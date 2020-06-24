#include <iostream>
#include<bits/stdc++.h>
using namespace std;
int partition(int a[],int lb,int ub)
{
    int pivot = a[lb]; //first element as pivot
    int start = lb,end = ub;
    while(start < end)
    {
        while(a[start] <= pivot)
            start++;
        while(a[end] > pivot)
            end--;
        if(start < end)
            swap(a[start],a[end]);
    }
    swap(a[lb],a[end]);//swap pivot element and  'end' element and return 'end' as a location
    return end;
}
void  QuickSort(int a[],int lb,int ub)
{
    if(lb < ub)
    {
        int loc = partition(a,lb,ub);
        QuickSort(a,lb,loc-1);
        QuickSort(a,loc+1,ub);
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
    cout<<"\nBefore Quick Sort--->\n";
    Display(a,n);
    QuickSort(a,0,n-1);
    cout<<"\nAfter Applying Quick Sort--->\n";
    Display(a,n);
    return 0;
}
