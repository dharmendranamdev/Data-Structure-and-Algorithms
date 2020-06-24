// CoinChange.cpp : Defines the entry point for the console application.
//

#include <bits/stdc++.h>
#include <iostream>
using namespace std;

#define MIN(a,b) ((a)>(b)?(b):(a))

#define STATIONS 40

int a[][STATIONS] = {
{ 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2, 4, 5, 3, 2 },
{ 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4, 2, 10, 1, 4 }
};
int t[][STATIONS] = {
{ 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5, 0, 7, 4, 5 },
{ 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8, 0, 9, 2, 8 }
};

int e[] = { 10, 12 };
int x[] = { 18,  7 };



int assemblyScheduling() {
	int F0[STATIONS];//it will keep track of minimal cost on each station for line 0
	int F1[STATIONS];//it will keep track of minimal cost on each station for line 1
    F0[0] = e[0] + a[0][0];
    F1[0] = e[1] + a[1][0];
    for(int j = 1; j < STATIONS; j++)
    {
        F0[j] = MIN(F0[j-1] + a[0][j], F1[j-1] + t[1][j] +  a[0][j] );
        F1[j] = MIN(F1[j-1] + a[1][j], F0[j-1] + t[0][j] +  a[1][j] );
    }
    return MIN(F0[STATIONS - 1] + x[0], F1[STATIONS - 1] + x[1]);
}
int main()
{
	cout << assemblyScheduling();
	return 0;
}
