//90 degree rotation o
#include<iostream>
using namespace  std;

#define M 4
#define N 4
void rotation90Degree(int m, int n, int arr[M][N])
{
    int i,j,m1;
    int  tempArray[M][N];
    for(i = 0; i < M; i++)
    {
        m1 = m - 1;
        //cout<<endl<<m<<endl<<endl;
        for(j = 0; j < N; j++)
        {
            tempArray[m1][i] = arr[i][j];
            m1--;
        }
    }

    for(int k = 0; k < M; k++)
    {
        for(int l = 0; l < N; l++)
        {
            cout<<tempArray[k][l]<<" ";
        }
        cout<<endl;
    }
}

int main()
{
    // Test Case 1
    int mat[N][N] =
    {
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
        {13, 14, 15, 16}
    };


    // Tese Case 2
    /* int mat[N][N] = {
                        {1, 2, 3},
                        {4, 5, 6},
                        {7, 8, 9}
                    };
     */

    // Tese Case 3
    /*int mat[N][N] = {
                    {1, 2},
                    {4, 5}
                };*/

    //displayMatrix(mat);

    rotation90Degree(N,N,mat);

    // Print rotated matrix
   // displayMatrix(mat);

    return 0;
}
