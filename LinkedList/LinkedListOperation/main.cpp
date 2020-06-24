#include <iostream>


#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
using namespace std;
void insertBeg();
void insertLast();
void insertRan();
void deleteBeg();
void deleteLast();
void deleteRan();
void display();
int searching(int);
struct node
{
	int data;
	struct node *link;
};
struct  node *head;
int main()
{
	int choice,key,c;
	do
	{

		printf("1. Insert a Node at Beginning\t2. Insert a Node at Last\t3.Insert at any random location\n4. Delete a Node at Beginning \t5.Delete a Node at Last\t 6.Delete a Node at random Location\n 7.Display all the Element \t 8.Searching the Element\t -1. to exit\n\n");

		printf("\nEnter your choice:");
		scanf("%d",&choice);
		switch(choice)
		{
			case 1:
			     insertBeg();
			     break;
			case 2:
                 insertLast();
                 break;
            case 3:
			     insertRan();
			     break;
			case 4:
                 deleteBeg();
                 break;
            case 5:
			     deleteLast();
			     break;
			case 6:
                 deleteRan();
                 break;
            case 7:
                 display();
                 break;
            case 8:

                 printf("\nEnter the key item which you want to be searched\n");
                 scanf("%d",&key);
                 c = searching(key);
                 if(c == 1)
                 	printf("\nkey Item is found\n");
                 else
                 	printf("\nkey Item is not found\n");
                 break;
			case -1:
			     printf("\nyou choose exit from the program\n");
			     break;
			default:
			     printf("\nInvalid choice\n");
		}
	}while(choice != -1);
	return 0;
	getch();
}
void insertBeg()
{
	int item;
	struct node *ptr = NULL;
	ptr = (struct node *)malloc(sizeof(struct node *));
	if(ptr == NULL)
		printf("\nOverflow\n");
	else
	{
		printf("Enter the value of data item\n");
		scanf("%d",&item);
		ptr->data = item;
		ptr->link = head;
		head = ptr;
		printf("\nNode has been inserted at the Beginning\n");
	}

}
void insertLast()
{
	int item;
	struct node *ptr,*temp;
	ptr = (struct node *)malloc(sizeof(struct node *));
    if(ptr == NULL)
	{
		printf("\nOverflow\n");
	}
	else
	{
		printf("Enter the item :\n");
		scanf("%d",&item);
		ptr->data = item;
		if(head == NULL)
		{
			ptr->link = head;
			head = ptr;
			printf("\nNode inserted at last Successfully !\n");
		}
		else
		{
			temp = head;
			while(temp->link != NULL)
			{
				temp = temp->link;
			}
			temp->link = ptr;
			ptr->link = NULL;
			printf("\nNode inserted at last Successfully !\n");
		}
	}

}
void  insertRan()
{
	int i,loc,item;
    struct node *ptr, *temp;
    ptr = (struct node *) malloc (sizeof(struct node));
    if(ptr == NULL)
    {
        printf("\nOVERFLOW");
    }
    else
    {
        printf("\nEnter element value");
        scanf("%d",&item);
        ptr->data = item;
        printf("\nEnter the location after which you want to insert ");
        scanf("\n%d",&loc);
        temp=head;
        for(i=1; i<loc;i++)
        {
            temp = temp->link;
            if(temp == NULL)
            {
                printf("\ncan't insert\n");
                return;
            }

        }
        ptr ->link= temp ->link;
        temp ->link = ptr;
        printf("\nNode inserted");
    }
}
void deleteBeg(){
	struct node *ptr;
    if(head == NULL)
    {
        printf("\nList is empty\n");
    }
    else
    {
        ptr = head;
        head = ptr->link;
        free(ptr);
        printf("\nNode deleted from the begining ...\n");
    }
}
void deleteLast(){
	struct node *ptr;
	if(head  == NULL)
		printf("List is empty ! UnderFlow");
	else if(head->link == NULL)
	{
		head = NULL;
		free(head);
		printf("\nOnly node of the list is deleted\n");
	}
	else
	{
		ptr = head;
		struct node *ptr1;
		while(ptr->link != NULL)
		{
			ptr1 = ptr;
			ptr = ptr->link;
		}
		ptr1->link = NULL;
		free(ptr);
		printf("\nDeleted node from the last\n");
	}
}
void deleteRan(){
	struct node *ptr,*ptr1;
	int loc;
	printf("Enter the location of node after which you want to perform deletion :\n");
	scanf("%d",&loc);
	ptr = head;
	for(int i = 0; i < loc ;i++)
	{
		ptr1 = ptr;
		ptr = ptr->link;
	    if(ptr == NULL)
        {
            printf("\nCan't delete");
            return;
        }
    }
    ptr1 ->link = ptr ->link;
    free(ptr);
    printf("\nDeleted node %d ",loc+1);

}
void display(){
	struct node *ptr;
	ptr = head;
	while(ptr != NULL)
	{
		printf("%d\n",ptr->data);
		ptr = ptr->link;
	}
}
int searching(int key){
	struct node *ptr;
	ptr = head;
	while(ptr != NULL)
	{
		if(ptr->data == key)
			return 1;
		ptr = ptr->link;
	}
	return 0;
}
