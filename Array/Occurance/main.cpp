// C++ implementation to find k numbers with most
// occurrences in the given array
#include <bits/stdc++.h>

using namespace std;

// comparison function to sort the 'freq_arr[]'
bool compare(pair<int, int> p1, pair<int, int> p2)
{
}

// funnction to print the k numbers with most occurrences
void print_N_mostFrequentNumber(int a[], int n, int k)
{
    int count = 1,occur = 1,get;
	for(int i = 0; i < n; i++)
    {
        if(a[i] != INT_MIN)
        {
            count = 1;
            for(int j = i+1; j < n; j++)
            {
                if(a[j]  != INT_MIN)
                {

                    if(a[i] == a[j])
                    {
                        count++;
                        a[j] = INT_MIN;
                    }
                }
            }
            if(occur < count){
                get = a[i];
                occur = count;
            }
        }
    }
    cout<<endl<<get<<" appears "<<occur<<" times....";
}

// Driver program to test above
int main()
{
	//int arr[] = {3, 1, 4, 4, 5, 2, 6, 1};
	int arr[] = {3, 1, 3, 1, 1, 5, 5, 1, 1, 4,4,4,4,4,4};
	int n = sizeof(arr) / sizeof(arr[0]);
	int k = 2;
	print_N_mostFrequentNumber(arr, n, k);
	return 0;
}
