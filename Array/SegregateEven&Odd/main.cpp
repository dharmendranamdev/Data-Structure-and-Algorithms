// CPP code to segregate even odd
// numbers in an array
#include <bits/stdc++.h>
using namespace std;

// Function to segregate even odd numbers
void arrayEvenAndOdd(int a[], int n)
{

	int i,evenP,oddP,start = 1;
	for(i = 0; i < n; i++)
	{
	    if(a[i] % 2 != 0 && start == 1)
	    {
	        oddP = i;
	        start = 0;
	    }
	    if(a[i] % 2 == 0)
	    {
	       int temp = a[i];
	       a[i] = a[oddP];
	       a[oddP] = temp;
	       i = oddP;
	       start = 1;
	    }
	}
	// Printing segregated array
	for (int i = 0; i < n; i++)
		cout << a[i] << " ";
}

// Driver code
int main()
{
	int arr[] = { 1, 9,5,3,2,6,7,11 };
	int n = sizeof(arr) / sizeof(int);
	arrayEvenAndOdd(arr, n);
	return 0;
}
