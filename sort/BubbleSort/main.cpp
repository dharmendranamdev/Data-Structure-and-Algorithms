#include <iostream>

using namespace std;

void Display(int a[],int n)
{
    for(int i = 0; i < n; i++)
    {
        cout<<"\t"<<a[i];
    }
    cout<<endl<<endl;
}

void BubbleSort(int a[],int n)
{
    for(int i = 0 ; i < n - 1 ; i++)
    {
        for(int j = 0; j < n - i - 1; j++)
        {
            if(a[j] > a[j+1])
            {
                int temp = a[j];
                a[j] = a[j+1];
                a[j+1] = temp;
            }
        }
        Display(a,n);
    }
}
int main()
{
    int a[] = {8,7,6,5,4,3,2,1};
    int n = sizeof(a) / sizeof(a[0]);
    Display(a,n);
    cout<<"\nApply BubbleSort\n";
    BubbleSort(a,n);
    cout<<"\nFinal Array--->\n";
    Display(a,n);
    return 0;
}
