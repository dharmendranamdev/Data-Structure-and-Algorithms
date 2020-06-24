/*
Input:  arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        query[] = [0, 4], [1, 3] [2, 4]
Output: Sum of arr[] elements in range [0, 4] is 8
        Sum of arr[] elements in range [1, 3] is 4
        Sum of arr[] elements in range [2, 4] is 6
*/

#include <iostream>

using namespace std;
struct AddOfRange{
    int l,r;
};

void Addition(int a[],AddOfRange query[],int m)
{
    for(int i =0; i < m; i++)
    {
        int L = query[i].l;
        int R = query[i].r;
        int sum = 0;
        for(int j = L ; j <= R; j++)
            sum += a[j];
        cout << "Sum of [" << L << ", "
            << R << "] is "  << sum << endl;

    }
}

int main()
{
    cout << "Hello................\n\n";
    int a[] ={1,2,4,5,6,7,8,9,10};
    int n = sizeof(a) / sizeof(a[0]);
    AddOfRange query[] = {{0,4},{1,3},{2,4}}; //Array of Objects
    /*
    Ex: query[0].l = 0
        query[0].r = 4
    */
    int m = sizeof(query) / sizeof(query[0]);
    Addition(a,query,m);

    return 0;
}
