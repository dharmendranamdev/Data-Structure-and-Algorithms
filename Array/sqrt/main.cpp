#include <iostream>
#include "math.h"

using namespace std;
void query(int l,int r){

}
void preprocess(int a[],int n)
{
    int NoOfBlocks = 0;
    int x = sqrt(n);
    int sum = 0;
    for(int i = 0; i < n; i++)
    {
        if(i % x == 0)
        {

            NoOfBlocks++;
        }

    }
    cout<<"No Of Blocks : "<<NoOfBlocks;
    NoOfBlocks = 3 * NoOfBlocks;//sum,StartIndex,EndIndex
    int Blocks[NoOfBlocks];

    int k = 0,j;
    for(int i = 0; i < n; i = i + x)
    {
        sum = 0;
        for(j = i ; j < (i + x) && j < n; j++){
            sum += a[j];
        }
        Blocks[k] = sum;
        k++;
        Blocks[k] = i;
        k++;
        Blocks[k] = j - 1;
    }
    //--------------Queries------------------
    cout << "query(3,8) : " << query(3, 8) << endl;
    cout << "query(1,6) : " << query(1, 6) << endl;
    cout << "query(8,8) : " << query(8, 8) << endl;


}
int main()
{

    int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
    int n = sizeof(input)/sizeof(input[0]);

    preprocess(input, n);

    //cout << "query(3,8) : " << query(3, 8) << endl;
    //cout << "query(1,6) : " << query(1, 6) << endl;
    //update(8, 0);
    //cout << "query(8,8) : " << query(8, 8) << endl;

    return 0;
}
