// C++ program to Count
// Inversions in an array
// using Merge Sort
#include <bits/stdc++.h>
using namespace std;

/* This funt merges two sorted arrays
and returns inversion count in the arrays.*/
int mergeArray(int a[],int n,int left,int mid,int right)
{
    int inv_count = 0;
    int i = left;
    int j = mid + 1;
    int k = left;
    int temp[n];
    while(i <= mid && j <= right)
    {
        if(a[i] <= a[j]){
            temp[k++] = a[i++];
        }
        else if(a[i] > a[j]){
            temp[k++] = a[j++];
            inv_count = inv_count + (mid - i) + 1;
        }
    }
    while(i <= mid)
    {
        temp[k++] = a[i++];
    }
    while(j <= right)
    {
        temp[k++] = a[j++];
    }
    for(int p = left ; p <= right; p++)//copy the element of  temp array into original array in sorted manner
    {
        a[p] = temp[p];
    }
    return inv_count;
}

int mergeSort(int a[],int n,int l,int r)
{
    int invCount = 0;
    if(l >= r)
        return invCount;
    else
    {
        int mid = (l + r ) / 2;
         /* Inversion count will be sum of
        inversions in left-part, right-part
        and number of inversions in merging */
        invCount = invCount +  mergeSort(a,n,l,mid);
        invCount = invCount + mergeSort(a,n,mid+1,r);
        //Merge 2 Array as well as find inv_count b/w them
        invCount = invCount + mergeArray(a,n,l,mid,r);
    }
    return invCount;
}

int main()
{
    int arr[] = { 1,20,6,4,5,6,2};
    int n = sizeof(arr) / sizeof(arr[0]);
    int ans = mergeSort(arr, n , 0, n-1);
    cout << " Number of inversions are " << ans;
    return 0;
}
