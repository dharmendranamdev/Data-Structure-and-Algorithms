#include <iostream>

using namespace std;

void display(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        cout<<a[i]<<"\t";
    }
    cout<<endl;
}

void MoveZeroatEnd(int a[],int n){
    int k = 0;
    for(int i = 0; i < n;i++)
    {
        if(a[i] != 0)
        {
            a[k] = a[i];
            k++;
        }
    }
    while(k < n)
    {
        a[k] = 0;
        k++;
    }
}

int main()
{

    int n;
    cout << "Enter the size of array: " <<endl;
    cin>>n;

    int a[n];

    cout<<"\nEnter the Aray Items:";
    for(int i =0; i < n; i++)
    {
        cout<<"\nEnter a["<<i<<"] Element : " ;
        cin>>a[i];
    }

    display(a,n);

    MoveZeroatEnd(a,n);
    display(a,n);


    return 0;
}
