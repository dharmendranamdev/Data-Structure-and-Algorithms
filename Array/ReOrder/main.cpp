/*

Reorder an array according to given indexes
Given two integer arrays of same size, “arr[]” and “index[]”,
reorder elements in “arr[]” according to given index array. It is not allowed to given array arr’s length.

Example:

Input:  arr[]   = [10, 11, 12];
        index[] = [1, 0, 2];
Output: arr[]   = [11, 10, 12]
        index[] = [0,  1,  2]

Input:  arr[]   = [50, 40, 70, 60, 90]
        index[] = [3,  0,  4,  1,  2]
Output: arr[]   = [40, 60, 90, 50, 70]
        index[] = [0,  1,  2,  3,   4]
Expected time complexity O(n) and auxiliary space O(1)


*/

#include <iostream>

using namespace std;


void display(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        cout<<a[i]<<"\t";
    }
    cout<<endl;
}
void ReOrder(int a[],int indexArray[],int n)//iterative sort
{
    for(int i =0; i < n; i++)
    {
        int j = i;
        while(j > 0 && indexArray[j] < indexArray[j-1])
        {
            int temp1 = indexArray[j]; // sorting of index Array
            indexArray[j] = indexArray[j-1];
            indexArray[j-1] = temp1;

            int temp2 = a[j];   //simulteneously sorting of main array as well
            a[j] = a[j-1];
            a[j-1] = temp2;

            j--;
        }
    }
}
int main()
{
    cout << "Hello world!" << endl;
     int n;
    cout << "Enter the size of both arrays(main and index): " <<endl;
    cin>>n;

    int a[n],indexArray[n];

    cout<<"\nEnter the Aray Items:";
    for(int i =0; i < n; i++)
    {
        cout<<"\nEnter a["<<i<<"] Element : " ;
        cin>>a[i];
    }
    cout<<"\nEnter the indexes in index Array:";
    for(int i =0; i < n; i++)
    {
        cout<<"\nEnter index["<<i<<"] : " ;
        cin>>indexArray[i];
        if(indexArray[i] >= n || indexArray[i] < 0)
        {
            cout<<"\nIndex doesn't exist in 0 to "<<n-1<<" range\n";
            cout<<"Enter Again....\n";
            i--;
        }
    }

    display(a,n);
    display(indexArray,n);

    ReOrder(a,indexArray,n);

    display(a,n);
    display(indexArray,n);
    return 0;
}
