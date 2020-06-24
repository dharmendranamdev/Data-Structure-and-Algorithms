// C++ program to shift k elements in a matrix.
#include <bits/stdc++.h>
using namespace std;
#define N 4

// Function to shift first k elements of
// each row of matrix.
void shiftMatrixByK(int mat[N][N], int k)
{
	if (k > N) {
		cout << "shifting is not possible" << endl;
		return;
	}

	int j = 0;
	while (j < N) {

		// Print elements from index k
		for (int i = k; i < N; i++)
			cout << mat[j][i] << " ";

		// Print elements before index k
		for (int i = 0; i < k; i++)
			cout << mat[j][i] << " ";

		cout << endl;
		j++;
	}
}

// Driver code
int main()
{
	int mat[N][N] = {{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9, 10, 11, 12},
					{13, 14, 15, 16}};
	int k = 2;

	// Function call
	shiftMatrixByK(mat, k);

	return 0;
}
