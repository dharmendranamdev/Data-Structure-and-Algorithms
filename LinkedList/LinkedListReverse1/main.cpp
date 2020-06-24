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

void ReverseLinkedListPair()
{
    display();
    struct Node *current = head;
    struct Node *prev = NULL;
    struct Node *temp1 = NULL;
    struct Node *temp2 = NULL;
    struct Node *copyNode = NULL;
    head = head ->link;
    //cout<<prev->data;
    while(current != NULL && current->link != NULL)
    {
        temp1 = current;
        temp2 = current->link;

        //swappig the address of temp1 & temp2

        copyNode= temp1->link;
        temp1->link = temp2->link;
        temp2->link = copyNode;


        cout<<prev->data;
        //end
        if(prev != NULL)
             prev->link = temp2;
        prev = temp1;

        current = temp1->link;
    }
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
    ReverseLinkedListPair();

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
