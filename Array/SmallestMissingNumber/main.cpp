// C++ program to find the smallest elements
// missing in a sorted array.
#include<bits/stdc++.h>
using namespace std;

int BinarySearch(int a[],int n,int key)
{
    int left = 0;
    int  right = n-1;
    while(left < right)
    {
        int mid = (left  + right ) / 2;
        if(a[mid] == key)
            return -1;
        else if(a[mid] > key)
            right =  mid-1;
        else
            left = mid+1;
    }
    return key;
}

// Driver code
int main()
{
	int arr[] = {0, 1, 2, 3, 4, 5, 6, 7, 10};
	int n = sizeof(arr)/sizeof(arr[0]);
	int m = 15;//m > n
	//cout << "Smallest missing element is " <<
	//	findFirstMissing(arr, 0, n-1) << endl;

	for(int i = 0; i < m ; i++)
    {
       int x = BinarySearch(arr,n,i);
       if(x != -1)
       {
         cout<<x<<" Smallest element is missing...\n";
         return 0;
       }
   }
}

// This code is contributed by

