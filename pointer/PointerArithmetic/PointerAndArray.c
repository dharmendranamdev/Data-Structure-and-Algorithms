#include<stdio.h>
#include<conio.h>
#include <stdlib.h>
int main()
{
	int *p;
	p = (int *)malloc(5*sizeof(int));
	for(int i = 0; i < 5; i++)
	{
		p[i] = i + 1;
	}
	for(int i = 0; i < 5; i++)
	{
		printf("%d\n",p[i]);
	}
	getch();
	return 0;
}