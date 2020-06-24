#include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define N 100

int r1,c1,r2,c2;
void display(int r,int c,int a[][N] )
{
    int i,j;
    for(i = 0; i < r; i++){
        for(j = 0; j < c; j++)
        {
            cout<<a[i][j]<<"\t";
        }
        cout<<endl;
    }
}
void setArgument(int r,int c,int A[][N]){
    for(int i = 0; i < r; i++)
    {
        for(int j = 0; j < c; j++)
        {
            cout<<"Enter ("<<i<<")("<<j<<") : ";
            cin>>A[i][j];
            cout<<endl;
        }
    }
}
void MatrixMultiplication(int a[][N],int b[][N],int mult[][N]){

    //cout<<r1<<" "<<c1<<" "<<r2<<" "<<c2<<endl;
    for(int i = 0; i < r1; i++)//changing the row of A
    {
        for(int j = 0; j < c2;j++) //changing the columb of B
        {
            for(int k = 0; k < c1; k++)
            {
                mult[i][j] = mult[i][j] + a[i][k] * b[k][j];
            }
        }
    }

}
int main()
{

    cout<<"enter the row value for matrix A:";
    cin>>r1;
    cout<<"enter the col value for matrix B:";
    cin>>c1;
    cout<<"enter the row value for matrix A:";
    cin>>r2;
    cout<<"enter the col value for matrix A:";
    cin>>c2;
    if(c1 == r2)
    {
        int A[r1][N];//a[r1][c1]
        int B[r2][N];//a[r2][c2]
        int mult[r1][N];//mult[r1][c2]
        setArgument(r1,c1,A);
        setArgument(r2,c2,B);
        cout<<"First Matrix:\n";
        display(r1,c1,A);
        cout<<"Second Matrix:\n";
        display(r2,c2,B);
        for(int i = 0; i < r1; i++)//initialize mult array wit 0{
        {
                for(int j = 0; j < c2; j++){
                    mult[i][j] = 0;
                }
        }
        MatrixMultiplication(A,B,mult);
          cout<<"Multiplication of  Matrix:\n\n";
        display(r1,c2,mult);
    }
    else
    {
        cout<<"Matrix can't be performed ! bcz c1 != r2 \n\n";
    }

    return 0;
}

