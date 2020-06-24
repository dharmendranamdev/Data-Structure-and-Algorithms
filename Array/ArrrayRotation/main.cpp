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
//-------------------1st Method------------------------
void RotateUsingTempArray(int a[],int d,int n)
{
    int temp[d],i,j,k;
    for(i=0; i < d; i++){ //put d  elements start from index 0 in temp array
        temp[i] = a[i]; //Store d elements in a temp array
    }

    int gap = i;
    for(j = 0; j < n && gap < n ; j++)  // Shift rest of the arr[]
    {
        a[j] = a[gap];
        gap++;
    }

    for(k = d - 1; k >= 0; k--)//Store back the d elements
    {
        a[--gap] = temp[k];
    }
}
//--------------------------2nd method-------------------------------
void RotateOneByOne(int a[],int d,int n)
{
    int i,j;
    for(i = 0; i < d; i++)
    {
        int temp = a[0];
        for(j = 0; j < n-1;j++)
        {
            a[j] = a[j+1];
        }
        a[j] = temp;
    }
}

//-------------Using Juglling Algorithm--------------------------------
int gcd(int a, int b)
{
    if (b == 0)
        return a;

    else
        return gcd(b, a % b);
}
//Juglling ALgo : divide the Array into sets based on some criteria like GCD
void JugglingAlgo(int a[],int d,int n){
    int g_c_d = gcd(d,n);
    int i,j;
    for(i = 0; i < g_c_d; i++)
    {
        int temp = a[i];
        for(j = i; j + g_c_d < n ; j = j + g_c_d)
        {
            a[j] = a[j+g_c_d];
        }
        a[j] = temp;
    }
}

//----------------Using Reversal Algorithm-------------------

/*Function to reverse arr[] from index start to end*/
void rvereseArray(int arr[], int start, int end)
{
    while (start < end) {
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
        start++;
        end--;
    }
}
/* Function to left rotate arr[] of size n by d */
void ReversalAlgo(int arr[], int d, int n){
    rvereseArray(arr, 0, d - 1);
    rvereseArray(arr, d, n - 1);
    rvereseArray(arr, 0, n - 1);
}


/*---------------Search an element in a sorted and rotated array-----------*/
/*
Question:-An element in a sorted array can be found in O(log n) time via binary search.
But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
So for instance, 1 2 3 4 5 might become 3 4 5 1 2. Devise a way to find an element in the rotated array in O(log n) time
*/

/*
Ans--->we individually call each sorted array for Binary Search
*/

int BinarySearch(int a[],int n,int key,int low ,int high)
{
    if(low > high)
        return 0;
    int mid = (low + high ) / 2;
    if(key == a[mid])
        return 1;
    else if(key > a[mid])
        return BinarySearch(a,n,key,mid+1,high);
    else
        return BinarySearch(a,n,key,low,mid-1);

}

int BinarySearchForRotateArray(int a[],int n,int key,int d){
    if(BinarySearch(a,n,key,0,(n-1)-(d-1)- 1) || BinarySearch(a,n,key,(n-1)-(d-1), n - 1))
    {
        return 1;
    }
    else{
        return 0;
    }
}



int main()
{
    int n,d;
     int key;
    cout << "Enter the size of array: " <<endl;
    cin>>n;

    int a[n];

    cout<<"\nEnter the Aray Items:";
    for(int i =0; i < n; i++)
    {
        cout<<"\nEnter a["<<i<<"] Element : " ;
        cin>>a[i];
    }
    cout<<"\nEnter the Value of d:";
    cin>>d;
    display(a,n);
    /*------------Array Rotation-----------------*/
    //RotateUsingTempArray(a,d,n);        // 1
    //RotateOneByOne(a,d,n);    //2
    //JugglingAlgo(a,d,n);     //3
    ReversalAlgo(a,d,n);        //4
    display(a,n);

    do{
    cout<<"\nEnter a Key Value:";
    cin>>key;
    cout<<"\nFound or not : "<<BinarySearchForRotateArray(a,n,key,d);
    }while(key != -1);

    return 0;
}
