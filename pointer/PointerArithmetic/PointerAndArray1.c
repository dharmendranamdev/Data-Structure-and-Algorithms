#include<stdio.h>
#include<conio.h>
#include <stdlib.h>
int main()
{
	int **p; //for 2D array
	int m,n,k;
	printf("\nEnter No of Row & col : ");
	scanf("%d %d",&m,&n);
	
	
	p = (int **)malloc(m * sizeof(int * ));
	for(int i = 0; i  < m; i++)
	{
	    p[i] = (int *)malloc(n * sizeof(int));
	}
	
	
	for(int i = 0; i < m; i++)
	{
		for(int j = 0 ; j < n; j++)
		{
			p[i][j] = i;
		}
	}
	for(int i = 0; i < m; i++)
	{
		for(int j = 0 ; j < n; j++)
		{
			printf("%d ",p[i][j] );
		}
		printf("\n");
	}
	getch();
	return 0;
}