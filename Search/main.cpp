
#include <iostream>

using namespace std;

void display(int a[],int n)
{
    for(int i = 0 ; i < n; i++){
        cout<<a[i]<<"\t";
    }
    cout<<"\n";
}
int linearSer(int a[],int key,int n)
{
    for(int i = 0; i < n; i++)
    {
        if(key == a[i])
        {
            return 1;
        }
    }
    return 0;
}

int BinarySer(int a[],int key,int n)
{

    int left = 0,right = n-1;

    while(left <= right)
    {
         int mid = (left+right) / 2;
         if(a[mid] < key)
            left = mid+1;
         else if(a[mid] > key)
            right = mid-1;
         else
            return 1;
    }
    return 0;

}



int main()
{
    int n,key;
    cout<<"Enter The Size of Array:";
    cin>>n;

    int a[n];//array declaration

    for(int i = 0; i < n; i++){

        cout<<"\nEnter "<<i+1<<" Element:";
        cin>>a[i];
    }
    display(a,n);

    cout<<"\n\nEnter the Element which you want to search :";
    cin>>key;

    int pos  = BinarySer(a,key,n);


    if(pos == 1)
    {
        cout<<"\nKey Element found ...";
    }
    else
    {
        cout<<"\nKey Not found in...";
    }

    return 0;
}
