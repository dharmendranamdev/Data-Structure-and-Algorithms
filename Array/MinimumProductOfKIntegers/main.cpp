/*Minimum product of k integers in an array of positive Integers
Given an array of n positive integers. We are required to write a program to print the minimum product of k integers of the given array.

Examples:

Input : 198 76 544 123 154 675
         k = 2
Output : 9348
We get minimum product after multiplying
76 and 123.

Input : 11 8 5 7 5 100
        k = 4
Output : 1400
*/

/*
Algorithm : step1-> sort the array
            step2-> multiplication b/w first k elements

*/

// CPP program to find minimum product of
// k elements in an array


//--------------------------Include only this header file-----------------------

#include <bits/stdc++.h>

//--------------------------OR both-----------------------
#include<iostream> //for basic input & output function like cin,cout
#include<algorithm>//data structure function like sort()
using namespace std;

int minProduct(int a[], int n, int k)
{
	sort(a,a+n);
	int mult = 1;
	for(int i = 0; i < k; i++)
        mult*=a[i];
	return mult;
}

// Driver code
int main()
{
	int arr[] = {198, 76, 544, 123, 154, 675};
	int k = 2;
	int n = sizeof(arr) / sizeof(arr[0]);
	cout << "Minimum product is "
		<< minProduct(arr, n, k);
	return 0;
}
