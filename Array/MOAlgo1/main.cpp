/*
Input:  arr[]   = {1, 1, 2, 1, 3, 4, 5, 2, 8};
        query[] = [0, 4], [1, 3] [2, 4]
Output: Sum of arr[] elements in range [0, 4] is 8
        Sum of arr[] elements in range [1, 3] is 4
        Sum of arr[] elements in range [2, 4] is 6
*/

#include <iostream>

using namespace std;
class RangeAddition
{
    int l,r;
public:
    void getData(int L,int R)
    {
        l = L;
        r = R;
    }
    void Addition(int[]);
};

void RangeAddition :: Addition(int a[])
{
        //int L = l;
        //int R = this.r;
        int sum = 0,j;
        for(j = l ; j <= r; j++) // 2 member variable
        {
            cout<<endl<<a[j]<<" value \n";
            sum = sum + a[j];
            cout<<"\nsum:"<<sum;
        }
        cout << "\n\nSum of [" << l << ", "
            << r << "] is :"  << sum << endl;

}

int main()
{
    cout << "Hello................\n\n";
    int a[] ={0,1,2,3,4,5,6,7,8,9};
    //int n = sizeof(a) / sizeof(a[0]);
    int m,l,r;

    cout<<"\nHow many Query do you want to proceed:";
    cin>>m;

    RangeAddition query[m];

    for(int i = 0; i < m; i++)
    {
        cout<<"Enter L and R of "<<i+1<<" Query : ";
        cin>>l>>r;
        query[i].getData(l,r);
        query[i].Addition(a);
    }


    return 0;
}
