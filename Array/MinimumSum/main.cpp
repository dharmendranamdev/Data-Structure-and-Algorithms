
#include <bits/stdc++.h>
using namespace std;

void insertionSort(int a[], int n)
{
    for(int i = 0; i < n; i++)
    {
        int j = i;
        while(j > 0 && a[j] < a[j-1])
        {
            int temp = a[j-1];
            a[j-1] = a[j];
            a[j] = temp;
            j--;

        }
    }
}
void findMinSum(int a[], int n)
{
	insertionSort(a, n);
	int min = INT_MAX, index1, index2;
	for (int i = 0; i < n; i++) {

		for(int j = i + 1; j < n; j++){
            if(abs(a[i] + a[j]) < min)
            {
                min = abs(a[i] + a[j]);
                index1 = i;
                index2 = j;
            }
		}
	}
	cout << "The two elements whose sum is minimum are "
		<< a[index1] << " and " << a[index2];
}
int main()
{
	int arr[] = { 1, 60, -10, 70, -80, 85,83};
	int n = sizeof(arr) / sizeof(arr[0]);
	findMinSum(arr, n);
	return 0;
}
