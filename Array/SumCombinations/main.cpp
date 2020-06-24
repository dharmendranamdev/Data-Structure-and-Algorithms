// A simple C++ program to find N maximum
// combinations from two arrays, https://www.geeksforgeeks.org/k-maximum-sum-combinations-two-arrays/
//i use the concept of getting largest 3 no.https://www.geeksforgeeks.org/find-the-largest-three-elements-in-an-array/

#include <bits/stdc++.h>
using namespace std;

// function to display first N maximum sum
// combinations
void display(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        cout<<"\t"<<a[i];
    }
    cout<<endl;
}
void KMaxCombinations(int a[], int b[], int n, int k)
{
    display(a,n);
    display(b,n);
       cout<<endl;   cout<<endl;
    int MaxCombination[k],sum,start = 1;
    for(int w = 0; w < k; w++){
        MaxCombination[w] = INT_MIN;
    }
    for(int i = 0; i < n; i++)
    {
        for(int j = 0; j < n; j++)
        {
            sum = a[i] + b[j];
            //cout<<"\nSum of ["<<i<<"]["<<j<<"]:"<<sum;
            start = 1;
            for(int y = 0; y < k; y++)
            {

                if(sum > MaxCombination[y] && start == 1)
                {
                    //cout<<"\nvalue :"<<y<<endl;
                    for(int p = k - 1; p > y ; p--)
                    {
                        MaxCombination[p] = MaxCombination[p-1];
                    }
                    MaxCombination[y] = sum;
                    display(MaxCombination,k);
                    start = 0;
                }
            }
        }
    }
    cout<<endl;
    //display(MaxCombination,k);

}

// Driver Code.
int main()
{
	int a[] = { 4, 2, 5, 1 };
	int b[] = { 8, 0, 5, 3 };
	int n = sizeof(a)/sizeof(a[0]);
	int k = 3;
	KMaxCombinations(a, b, n, k);
	return 0;
}
