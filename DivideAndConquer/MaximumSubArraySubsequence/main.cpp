#include <iostream>
#include<bits/stdc++.h>

using namespace std;
//------------Brute Force Method : Time Complexity : O(n^3)-----------------//
int maxSubArraySum1(int a[],int n)
{
    //cout<<"nkafhkhfka ffhaskjlufhiash fihashd f";
    int ans = INT_MIN,i,size,k;
    for(size = 1; size <= n; size++)
    {
        for(i = 0; i < n ; i++)
        {
            if(i + size > n)
                break;
            int sum = 0;
            for(k  = i; k < i + size ; k++)
            {
                sum = sum +  a[k];
            }
            if(ans < sum)
                ans = sum;
        }
    }
    return ans;
}

//-------------------Brute Force method 2nd : Time complexity : O(n^2)
int maxSubArraySum2(int a[],int n)
{
    //cout<<"nkafhkhfka ffhaskjlufhiash fihashd f";
    int Maximum = INT_MIN,i,size,k;
    for(int index = 0; index < n; index++)
    {
        int sum = 0;
        for(int size = 1; size <= n; size++)
        {
            if(index + size > n)
                break;
            sum = sum + a[index + size - 1];
            if(sum > Maximum)
                 Maximum = sum;
        }
    }
    return Maximum;
}
//-------------------Divide & Conquer Approach : Time complexity : O(nlogn)

int maximum(int a,int b, int c)
{
    if(a > b)
    {
        if(a > c)
           return a;
        else
            return c;
    }
    else if(b > c)
    {
        return b;
    }
    else
    {
        return c;
    }
}

int maxAcrossingSum(int a[],int mid,int l,int r)
{
    //Sum of left Element
    int sum = 0;
    int left_Sum = INT_MIN;
    for(int i = mid; i >= l; i--)
    {
        sum += a[i];
        if(sum > left_Sum)
            left_Sum = sum;
    }

     //Sum of left Element
     sum = 0;
    int right_Sum = INT_MIN;
    for(int i = mid + 1; i <= r; i++)
    {
        sum += a[i];
        if(right_Sum < sum)
            right_Sum = sum;
    }
    return left_Sum + right_Sum;

}
int maxSubArraySum3(int a[],int l,int r)
{
    if(l == r)//there is only 1 element
        return a[l];
    int mid = (l + r ) / 2;

    return(maximum(maxSubArraySum3(a,l,mid),maxSubArraySum3(a,mid+1,r),maxAcrossingSum(a,mid,l,r)));

}
int main()
{
   int arr[] = {1,-1,2,-3,-1,4};
   int n = sizeof(arr)/sizeof(arr[0]);
   //int max_sum = maxSubArraySum1(arr, n);
   //int max_sum = maxSubArraySum2(arr, n);
   int max_sum = maxSubArraySum3(arr, 0,n-1); //Divide & Conquer Approach
   cout<<max_sum;
   return 0;
}
