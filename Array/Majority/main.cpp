// Hashing based C++ program to find if there
// is a majority element in input array.
#include <bits/stdc++.h>
using namespace std;

// Returns true if there is a majority element
// in a[]
bool isMajority(int a[], int n)
{
	for(int i =  0 ; i < n; i++)
    {
        int count = 0;
        for(int j = 0; j < n; j++)
        {
            if(a[i] == a[j])
            {
                count++;
            }
        }
        if(count = n / 2)
        {
            return true;
        }
    }
    return false;
}

// Driver code
int main()
{
	int a[] = { 2, 3, 9, 2, 2 };
	int n = sizeof(a) / sizeof(a[0]);
	if (isMajority(a, n))
		cout << "Yes";
	else
		cout << "No";
	return 0;
}
