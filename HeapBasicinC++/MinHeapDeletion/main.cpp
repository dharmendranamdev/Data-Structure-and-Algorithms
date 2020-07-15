//In a Min Heap ,the operation Heap-Delete(A,i) deletes the item in node with index i from the heap .Write an
// O(log n) time algo for Heap-Delete(A,i)

//Basically ,we delete from the root in Heap,So this is something tricky
#include <iostream>
#include<bits/stdc++.h>
using namespace std;

void printArray(int arr[], int n)
{
    for (int i = 0; i < n; ++i)
        cout << arr[i] << " ";
    cout << "\n";
}

void MinHeapify(int a[],int n,int i)
{
    int minimum = i;
    int lc = 2 * i + 1;
    int rc = 2 * i + 2;

    if(lc < n && a[lc] < a[minimum] )
        minimum = lc;
    if(rc < n && a[rc] < a[minimum])
        minimum = rc;
    if(minimum != i)
    {
        swap(a[minimum],a[i]);
        MinHeapify(a,n,minimum);
    }
}

int Heap_Delete(int a[],int n,int i)
{
    if(i <= n - 1)
    {
        swap(a[i],a[--n]);
        //n--;
        MinHeapify(a,n,i);
    }
    else
    {
        cout<<"Ni, ho skta pagal ho kya we ,Index bhag raha hai!";
    }
    return n;
}

int Heap_Delete1(int a[],int n,int i)
{
    if(i <= n - 1)
    {
      //cout<<n;
       int lc = 2 * i + 1;
       int rc = 2 * i + 2;
        //cout<<"\n"<<lc<<rc;

       if(lc >= n && rc >= n)//no child
       {
           int j = i;
           while(j <= n - 2)
           {
               a[j] = a[j+1];
               j++;
           }
           --n;
       }
       else if(lc <= n - 1 && rc >= n)//when only left child
       {
           swap(a[i],a[lc]);
           --n;
       }
       else//Both Child or tree
       {
           int ind;
           if(a[lc] < a[rc])
              ind = lc;
           else
              ind = rc;

           swap(a[ind], a[i]);
           n = Heap_Delete1( a, n,ind);
       }
    }
    return n;
}

int main()
{
    int arr[] = {0,1,2,3,4,5,6,7};//already min heap

    int n = sizeof(arr) / sizeof(arr[0]);

    printArray(arr, n);

    n = Heap_Delete1(arr, n, 4);//index 1

    printArray(arr, n);

    return 0;
}
