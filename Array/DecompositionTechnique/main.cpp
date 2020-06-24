// C++ program to demonstrate working of Square Root
// Decomposition.
#include "iostream"
#include "math.h"
using namespace std;

int main()
{
	//int input[] = {1, 5, 2, 4, 6, 1, 3, 5, 7, 10};
	int input[] ={0,1,2,3,4,5,6,7,8,9};
	int n = sizeof(input)/sizeof(input[0]);

	int blck_size = sqrt(n);
	if(n % 2 == 0)
    {

    }

    cout<<blck_size;

	int blocks[blck_size];

	//cout << "query(3,8) : " << query(3, 8) << endl;
	//cout << "query(1,6) : " << query(1, 6) << endl;
	//cout << "query(8,8) : " << query(8, 8) << endl;
	return 0;
}
