// C++ program for left rotation of matrix by 90
// degree without using extra space
/*
SoLution : transpose the matrix
           reverse the columb
*/
#include <bits/stdc++.h>
using namespace std;
#define R 4
#define C 4

// After transpose we swap elements of column
// one by one for finding left rotation of matrix
// by 90 degree
void reverseColumns(int arr[R][C])
{
	int m1 = R;
	int count = 1;
	while(count <= R / 2)
    {
        for(int i = 0; i < C; i++)
        {
            swap(arr[count - 1][i],arr[m1-1][i]);
        }
        count++;
        m1--;
    }
}

// Function for do transpose of matrix
void transpose(int arr[R][C])
{
	for (int i = 0; i < R; i++)
		for (int j = i; j < C; j++)
			swap(arr[i][j], arr[j][i]);
}

void printMatrix(int arr[R][C])
{
	for (int i = 0; i < R; i++) {
		for (int j = 0; j < C; j++)
			cout << arr[i][j] << " ";
		cout << '\n';
	}
}

// Function to anticlockwise rotate matrix
// by 90 degree
void rotate90(int arr[R][C])
{
	transpose(arr);
	reverseColumns(arr);
}

// Driven code
int main()
{
	int arr[R][C] = { { 1, 2, 3, 4 },
					{ 5, 6, 7, 8 },
					{ 9, 10, 11, 12 },
					{ 13, 14, 15, 16 } };
	rotate90(arr);
	printMatrix(arr);
	return 0;
}
