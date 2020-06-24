#include <iostream>
//merge 2 sublist in a order and both sublists are already sorted
using namespace std;

void Display(int a[],int n)
{
    for(int i = 0; i < n; i++)
    {
        cout<<" "<<a[i];
    }
    cout<<endl<<endl;
}

 void Merge2Sublist(int a[],int start,int n1,int n2)
 {
     int i = start;
     int j = start + n1;
     int k = 0;
     int temp[n1 + n2];

     while(i < start + n1 && j < start + n1 + n2)
     {
         if(a[i] <= a[j])
         {
             temp[k] = a[i];
             i++;
         }
         else
         {
             temp[k] = a[j];
             j++;
         }
         k++;
     }
     //copy remaining elements of  first sublist
     while(i < start + n1)
     {
         temp[k] = a[i];
         k++;
         i++;
     }
    //copy remaining elements of  second sublist
     while(j < start + n1 + n2)
     {
         temp[k] = a[j];
         k++;
         j++;
     }

     //copy temp array into both sublist
     int x = start;
     for(int k = 0; k < n1 + n2; k++,x++)
     {
         a[x] = temp[k];
     }
 }
int main()
{
    int a[] = {-3,-2,-1,0,5,6,7,8,1,2,3,4,9,10,11,12,13};
    int start = 4;//starting index of first sublist
    int n1 = 4 ;//size of first list
    int n2 = 4 ;//size of second list
    int n = sizeof(a) / sizeof(a[0]);
    Display(a,n);
    cout<<"\nApply MerGe2SublistInSortedOrder\n";
    Merge2Sublist(a,start,n1,n2);
    cout<<"\nFinal Array--->\n";
    Display(a,n);
    return 0;
}
