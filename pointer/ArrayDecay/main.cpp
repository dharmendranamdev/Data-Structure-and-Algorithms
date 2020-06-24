#include <iostream>
//Array Decaly : loss of its type and dimensions
using namespace std;
void aDecay(int *p)
{
    cout<<"size of array (aDecay) : ";
    cout<<sizeof(p)<<endl;
}
void pDeccay(int (*p)[7]){
    cout<<"size of array (pDecay) : ";
    cout<<sizeof(p)<<endl;
}
void PreventArrayDecay(int (&p)[7])
{
    cout<<"sizeof of array (PreventArrayDecay) : ";
    cout<<sizeof(p)<<endl;
}
int main()
{
    int a[7] = {1,2,3,4,5,6,7};
    cout<<"Size of The array:";
    cout<<sizeof(a)<<endl;

    //passing array as a value to function
    aDecay(a);
    //passing array as a pointer to a function
    pDeccay(&a);

    /*how to prevent ArrayDecay
    1-> passing size of array 2->passing array into  function as reference
    */
    cout<<"\nHow to Prevent Array Decay-----\n";
    PreventArrayDecay(a);
    return 0;
}
