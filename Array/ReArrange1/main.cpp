#include <iostream>

//Rearrange an array in order – smallest, largest, 2nd smallest, 2nd largest, ..

using namespace std;

void display(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        cout<<a[i]<<"\t";
    }
    cout<<endl;
}
void IterativeSort(int a[],int n)
{
    for(int i =0; i < n; i++)
    {
        int j = i;
        while(j > 0 && a[j] < a[j-1])
        {
            int temp = a[j];
            a[j] = a[j-1];
            a[j-1] = temp;
            j--;
        }
    }
}
void ReArrange1(int a[],int n){
    //step 1: sort the Array
    IterativeSort(a,n);
    //step2 : Take two variables say i and j and point them to the first and last index of the array respectively.
    int index = 0,tempArray[n],i,j;
    for(i = 0,j = n-1 ; i <= n / 2; i++,j--)
    {
        //Take Temperory Array and put one by one smallest and largest element from starting and ending respectively.
        tempArray[index] = a[i];
        index++;
        tempArray[index] = a[j];
        index++;
    }
    //step 3: copy all elements of TempArray in original Array
    for(int k = 0; k < n; k++){
        a[k] = tempArray[k];
    }
}
int main()
{
    cout << "Hello world!" << endl;

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
    ReArrange1(a,n);
    display(a,n);
    return 0;
}
