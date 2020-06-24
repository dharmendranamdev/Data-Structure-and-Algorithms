#include <iostream>
#include<bits/stdc++.h>
using namespace std;
/*
Heap Properties : 1)Complete Binary Tree
                  2) Inserting a node at last & following the property of either Max Heap(Asscending Order) or Min Heap(Disaccending Order)
                  3) Always Root Node is Deleted & last node will place at root node position

child nodes of ith node is  : 2*i and  2*i + 1
parent node of i'th node is  : floor( i / 2 )

Heap Sort : 1) Building a Max Heap(Parent > child)
             2) Deleting the Root Node means :  replace it with last node  and  size wil be n - 1
*/

void Display(int a[],int n){
    int i;
    for(i = 0; i < n; i++){
        cout<<a[i]<<" ";
    }
    cout<<endl;
}
void MaxHeapify(int a[], int n, int i)
{
    int largest = i;
    int l = 2 * i + 1;//left child of i
    int  r = 2  * i + 2;//right child of i
    if(l < n && a[l] > a[largest])
        largest = l;
    if(r < n && a[r] > a[largest])
        largest = r;
    if(largest != i)
    {
        swap(a[i],a[largest]);
        MaxHeapify(a,n,largest);
    }
}
void  HeapSort(int a[],int n)
{
//1) Building a Max Heap From Heapify Method(in heapify Method we start from right side of array & leave the leaf node(so start with n/ 2 to 1))---------------------------------
    for(int i = n / 2 - 1; i >= 0; i--)
        MaxHeapify(a,n,i);
//2) deletion will give the largest element
    Display(a,n);
    for(int j = n-1; j >= 0; j--)
    {
        swap(a[0],a[j]);//swap root node with last node
        MaxHeapify(a,j,0);//check the max heap property again
    }
}

int main()
{
    int a[] = {15,5,20,1,17,10,30};
    int n = sizeof(a) / sizeof(a[0]);
    //cout<<n;
    cout<<"\nBefore Heap Sort--->\n";
    Display(a,n);
    HeapSort(a,n);
    cout<<"\nAfter Applying Heap Sort--->\n";
    Display(a,n);
    return 0;
}
