
/*
https://www.geeksforgeeks.org/minimum-length-subarray-sum-greater-given-value/

Smallest subarray with sum greater than a given value
Given an array of integers and a number x, find the smallest subarray with sum greater than the given value.
Examples:
arr[] = {1, 4, 45, 6, 0, 19}
   x  =  51
Output: 3
Minimum length subarray is {4, 45, 6}

arr[] = {1, 10, 5, 2, 7}
   x  = 9
Output: 1
Minimum length subarray is {10}

arr[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250}
    x = 280
Output: 4
Minimum length subarray is {100, 1, 0, 200}

arr[] = {1, 2, 4}
    x = 8
Output : Not Possible
Whole array sum is smaller than 8.



*/

# include <iostream>
using namespace std;


int smallestSubWithSum(int a[],int n,int x)
{
    int sum;
    for(int i = 1; i <= n; i++)
    {
        for(int j = 0; j < n-(i-1); j = j + i -( i - 1))
        {
            sum  = 0;
            for(int k = j; k < j + i; k++){
                sum += a[k];
            }
            if(sum > x)
                return i;
        }
    }
    return 0;
}
int main()
{
	int arr1[] = {1, 4, 45, 6, 10, 19};
	int x = 51;
	int n1 = sizeof(arr1)/sizeof(arr1[0]);
	int res1 = smallestSubWithSum(arr1, n1, x);
	(res1 == n1+1)? cout << "Not possible\n" :
					cout << res1 << endl;

	int arr2[] = {1, 10, 5, 2, 7};
	int n2 = sizeof(arr2)/sizeof(arr2[0]);
	x = 9;
	int res2 = smallestSubWithSum(arr2, n2, x);
	(res2 == n2+1)? cout << "Not possible\n" :
					cout << res2 << endl;

	int arr3[] = {1, 11, 100, 1, 0, 200, 3, 2, 1, 250};
	int n3 = sizeof(arr3)/sizeof(arr3[0]);
	x = 280;
	int res3 = smallestSubWithSum(arr3, n3, x);
	(res3 == n3+1)? cout << "Not possible\n" :
					cout << res3 << endl;

    int arr4[] = {- 8, 1, 4, 2, -6};
    int n4 = sizeof(arr4)/sizeof(arr4[0]);
	x = 6;
	int res4 = smallestSubWithSum(arr4, n4, x);
	(res4 == n4+1)? cout << "Not possible\n" :
					cout << res4 << endl;


	return 0;
}
