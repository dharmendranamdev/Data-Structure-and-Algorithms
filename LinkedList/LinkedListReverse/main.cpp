#include <iostream>


#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
using namespace std;
void insertBeg(int );

void display();

struct Node
{
	int data;
	struct Node *link;
};
struct Node *head = NULL;

void ReverseLinkedList()
{
     struct Node *current = NULL;
     struct Node *nextNode = NULL;
     while(head != NULL)
     {
         nextNode = head->link;
         head->link = current;
         current = head;
         head = nextNode;
     }
     head = current;
}
int main()
{
    insertBeg(4);
    insertBeg(3);
    insertBeg(2);
    insertBeg(1);

    cout<<"\n----given List------\n";
    display();

    cout<<"\n-------Reverse The List--------------\n";
    ReverseLinkedList();

    display();

}
void insertBeg(int item)
{

	struct Node *ptr = NULL;
	ptr = (struct Node *)malloc(sizeof(struct Node *));
	if(ptr == NULL)
		printf("\nOverflow\n");
	else{
		ptr->data = item;
		ptr->link = head;
		head = ptr;
	}

}
void display(){
	struct Node *ptr = head;
	while(ptr != NULL)
	{
		printf("%d ->",ptr->data);
		ptr = ptr->link;
	}
}
