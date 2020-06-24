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

int cache[11][101];
void initCache() {
	for (int i = 0; i < 11; i++)
		for (int j = 0; j < 101; j++)
			cache[i][j] = -1;
}

int startManufacturing(int line, int station) {
	if (station == STATIONS - 1)
		return a[line][station] + x[line];

	if (cache[line][station] != -1)
		return cache[line][station];

	int option1 = startManufacturing(line, station + 1);
	int option2 = t[line][station + 1] + startManufacturing(1 - line, station + 1);

	return cache[line][station] = MIN(option1, option2) + a[line][station];
}

int assemblyScheduling() {
	int option1 = e[0] + startManufacturing(0, 0);// line0; e[0]->entrycost;
	int option2 = e[1] + startManufacturing(1, 0);//line 1;
	return MIN(option1, option2);
}
int main()
{
	cout << assemblyScheduling();
	return 0;
}
