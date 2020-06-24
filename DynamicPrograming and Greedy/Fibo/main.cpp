#include <iostream>
#include<cmath>
using namespace std;
static int count = 0;




int fibo1(int n)
{
    count++;
    if(n == 0)
        return 0;
    if(n == 1)
        return 1;
    return fibo1(n-1) + fibo1(n-2);
}


//Fibonacci Series using Dynamic Programming
//Method 2: Botton Up Approach of DP (Tabular Method)
int fibo2(int n)
{
/* Declare an array to store Fibonacci numbers. */
int f[n+2]; // 1 extra to handle case, n = 0
int i;

/* 0th and 1st number of the series are 0 and 1*/
f[0] = 0;
f[1] = 1;

for (i = 2; i <= n; i++)
{
    count++;
	/* Add the previous 2 numbers in the series
		and store it */
	f[i] = f[i-1] + f[i-2];
}

return f[n];
}
// 3 Method using Formula to calculate  the nth term of fibo , Time Complexity : O(1)  and space complexity O(1)
int fibo3(int n) //Most Efficient Method
{
    count++;
    double x = (1 + sqrt(5)) / 2;
    return round( pow(x,n) / sqrt(5) );
}

//Method 4: Top Down Approach of DP (Memorization Technique) ,Time Complexity --> O(n)
int fibo4(int memo[],int N)
{
    if(memo[N] != - 1)
        return memo[N];
    count++;
    if(N == 0){
        memo[N] = 0;
        return 0;
    }
    if(N == 1){
        memo[N] = 1;
        return 1;
    }
    int sum = fibo4(memo,N-1) + fibo4(memo,N-2);
    memo[N] = sum;
    return sum;


}

int main()
{
    cout << "Hello world!" << endl;
    int n;
    cout<<"Enter a no:";
    cin>>n;
    //cout<<"Fibonacci no : "<<fibo1(n);
    //cout<<"Fibonacci no : "<<fibo2(n);
    //cout<<"Fibonacci no : "<<fibo3(n);
    int memo[n+1];
    for(int i = 0; i < n + 1; i++)
        memo[i]  = -1;
    cout<<"Fibonacci no : "<<fibo4(memo,n);
    cout<<"\n"<<count<<" times fibo() excutes\n\n";

    return 0;
}
