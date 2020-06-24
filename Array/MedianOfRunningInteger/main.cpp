#include <iostream>
//calculate median of running integer(one  by one)
using namespace std;

double CalculateMedian(int a[],int index)
{
    if(index % 2 == 0) //no of elements odd in count
    {
     return (double)a[index/2];
    }
    else //no of elements even in count
    {
     double x = ( a[index/2 + 1] + a[index/2] )*1.0 / 2;
     return x;
    }
}

void  Median(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
       double mini = CalculateMedian(a,i);
       cout<<endl<<i+1<<" Median :"<<mini;
    }
}


int main()
{
    cout << "Hello world!" << endl;
    int a[]={1,2,3,4,5,6,7};
    Median(a,7);
    return 0;
}
