#include <iostream>

using namespace std;


/*

Rearrange array such that arr[i] >= arr[j] if i is even and arr[i]<=arr[j] if i is odd and j < i
Given an array of n elements. Our task is to write a program to rearrange the array such that
elements at even positions are greater
than all elements before it and elements at odd positions are less than all elements before it.

Examples:

Input : arr[] = {1, 2, 3, 4, 5, 6, 7}
Output : 4 5 3 6 2 7 1

Input : arr[] = {1, 2, 1, 4, 5, 6, 8, 8}
Output : 4 5 2 6 1 8 1 8

*/


void display(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        cout<<a[i]<<"\t";
    }
    cout<<endl;
}
void IterativeSort(int a[],int n){
    for(int i =0; i < n; i++)
    {
        int j = i;
        while(j > 0 && a[j] < a[j-1])
        {
            int temp = a[j];
            a[j] = a[j-1];
            a[j-1]=temp;
            j--;
        }
    }
}


/*
  step 1: Sort the Array
  step 2: divide the sorted Array into as 2 SubArray,based on the value of total no. of elements
   Ex:  if n = 7, nOdd = 4 and nEven = 3
        if n = 8 , nOdd = 4 and nEven = 4
  step 3: insert elements into both subarray's
  step 4: insert elements of both Arrays one by one like switching
*/

void Arrange(int a[],int n){
    //step 1
    IterativeSort(a,n);
    //step 2
    int nOdd,nEven;
    nOdd = n / 2;
    nEven = n / 2;
    if(n % 2 != 0)
        ++nOdd;
    int ArrayEven[nEven],ArrayOdd[nOdd];
    //step 3
    int i;
    for(i = 0; i < nOdd; i++)
        ArrayOdd[i] = a[i];
    for(int j = 0; j < nEven;j++)
    {
        ArrayEven[j] = a[i];
        i++;
    }
    //step 4
    int o=nOdd-1,e=0;//for counting
    for(int k = 0 ; k < n; k++){
        if(k % 2 == 0)//odd Place
        {
            a[k] = ArrayOdd[o];
            o--;
        }
        else//Even Place
        {
            a[k] = ArrayEven[e];
            e++;
        }
    }

}


int main()

{
    int n;
    cout << "Enter the size of array: " <<endl;
    cin>>n;

    int a[n];

    cout<<"\nEnter the Aray Items:";
    for(int i =0; i < n; i++)
    {
        cout<<"\nEnter a["<<i<<"] Element : " ;
        cin>>a[i];
    }

    display(a,n);
    Arrange(a,n);
    display(a,n);


    return 0;
}
