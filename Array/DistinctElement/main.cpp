// C++ program to print all distinct elements in a given array
//Print All Distinct Elements of a given integer array
/*
solution : A Simple Solution is to use twp nested loops.
The outer loop picks an element one by one starting from the leftmost element.
The inner loop checks if the element is present on left side of it.
If present, then ignores the element,else prints the element.
 Following is the implementation of the simple algorithm.
*/
#include <iostream>
#include <algorithm>
using namespace std;

void printDistinct(int a[], int n)
{
    int i,j;
	for(i = 0; i < n; i++)
    {
        for(j = 0; j < i; j++)
        {
            if(a[i] == a[j])
                break;
        }
        if(i == j)
        {
            cout<<a[i]<<" ";
        }
    }
}
int main()
{
	int arr[] = {6, 10, 5, 4, 9, 120, 4, 6, 10};
	int n = sizeof(arr)/sizeof(arr[0]);
	printDistinct(arr, n);
	return 0;
}
