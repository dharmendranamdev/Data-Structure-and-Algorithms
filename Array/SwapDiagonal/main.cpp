// CPP Program to swap diagonal of a matrix
//https://www.geeksforgeeks.org/swap-major-minor-diagonals-square-matrix/
#include <bits/stdc++.h>
using namespace std;

// size of square matrix
#define N 4

// Function to swap diagonal of matrix
void swapDiagonal(int matrix[][N]) {
for (int i = 0; i < N; i++)
	swap(matrix[i][i], matrix[i][N - i - 1]);
}

// Driver Code
int main() {
int matrix[N][N] = {
                    {0, 1, 2,3},
					{4, 5, 6,7},
					{8,9,10,11},
					{12,13,14,15}
					};

swapDiagonal(matrix);

// Displaying modified matrix
for (int i = 0; i < N; i++) {
	for (int j = 0; j < N; j++)
	cout << matrix[i][j] << " ";
	cout << endl;
}

return 0;
}
