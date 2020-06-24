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

void  SelectionSort(int a[],int n)
{
    for(int i = 0; i < n - 1; i++)
    {
        for(int j = i + 1; j < n; j++)
        {
            if(a[i] > a[j])
            {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
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
    cout<<"\nApply SelectionSort\n";
    SelectionSort(a,n);
    cout<<"\nFinal Array--->\n";
    Display(a,n);
    return 0;
}
