#include<stdio.h>
#include<conio.h>
int main()
{
	int a;
	printf("Enter the value of a:\n");
	scanf("%d",&a);
	int *p = NULL;
	p = &a;
	printf("%d\t%d\n", *p,a);
	printf("%u\t%u",&a,p );
	p = p + 1;
	printf("\n\nincrementing pointer variable : %u\n", p);
	getch();
	return 0;

}