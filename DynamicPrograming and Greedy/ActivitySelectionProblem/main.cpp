#include <iostream>

using namespace std;
void printMaxActivities(int s[],int f[],int n)
{
    cout<<"\n\n";
    //i :  last activity
    //j : current activity
    int i = 0,j;
    cout<<i<<"\t"; //alwaysa include first activity
    for(j = 1; j < n; j++)
    {
        if(s[j] >= f[i])//if start time of current activity(which has minimum finish time among rest activity) >= finish time of last recent activity
        {
            cout<<j<<"\t";
            i = j;
        }
    }
}

int main()
{
    //Finish Array are already sorted,so no need to sorted it
    //if it is not sorted then we have to sort finish array and also correspondence to its start time.
    int s[] =  {1, 3, 0, 5, 8, 5};
    int f[] =  {2, 4, 6, 7, 9, 9};

    int n = sizeof(s)/sizeof(s[0]);
    printMaxActivities(s, f, n);
    cout<<"\n\n\n\n\n\n";
    return 0;
}
