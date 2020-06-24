// C++ program to rotate a matrix

#include <bits/stdc++.h>
#define R 4
#define C 4
using namespace std;

// A function to rotate a matrix mat[][] of size R x C.
// Initially, m = R and n = C
void rotatematrix(int m,int n,int a[R][C])
{
    int m1 = m;
    int n1 = n;
    //cout<<m<<" : "<<n<<endl;
    int count = 1,i,j;
    int temp1,temp2;
    while(count <= n / 2)
    {
        //first Row
        //cout<<"1st row";
        temp1 = a[count - 1][count - 1];
        for(i = count; i < n1; i++)
        {
            temp2 = a[count-1][i];
            a[count-1][i] = temp1;
            //cout<<"a[count-1][i] : "<<a[count-1][i];
            temp1 = temp2;
        }

        //last col
        for(j = count; j < m1; j++)
        {
            temp2 = a[j][m1-1];
            a[j][m1-1] = temp1;
            temp1 = temp2;
        }


        //last Row

        for(j = n1 - 2; j >= count - 1; j--)
        {
            temp2 = a[n1-1][j];
            a[n1-1][j] = temp1;
            temp1 = temp2;
        }
        //first coumnn

        for(j = m1-2; j >= count - 1; j--)
        {
            temp2 = a[j][count - 1];
            a[j][count-1] = temp1;
            temp1 = temp2;
        }

        cout<<endl;
        m1--;
        n1--;
        count++;
    }

}

void display(int m,int n,int a[R][C])
{
    for (int k=0; k< m; k++)
	{
		for (int l=0; l < n; l++)
        {
            cout << a[k][l] << " ";
        }
		cout << endl;
	}
	cout<<endl;
}
/* Driver program to test above functions */
int main()
{
	// Test Case 1
	int a[R][C] = { {1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12},
		{13, 14, 15, 16} };

	// Tese Case 2
	/* int a[R][C] = {{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9}
					};

	*/
	cout<<"Main Array:"<<endl;
    display(R,C,a);
    rotatematrix(R,C,a);

	cout<<"Rotate 2D Array:"<<endl;
     display(R,C,a);
	return 0;
}
