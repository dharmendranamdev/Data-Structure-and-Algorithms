// C++ program to segregate even and
// odd nodes in a Linked List
#include <bits/stdc++.h>
using namespace std;

/* a node of the singly linked list */
class Node
{
	public:
	int data;
	Node *next;
};

void push(Node**, int);
void printList(Node *);
Node *jointPointer = NULL;

Node * segregateEvenOdd(Node **head)
{
	Node *OddList = NULL;
	Node *EvenList = NULL;
	Node *temp = *head;
	if(temp == NULL)
    {
        return temp;
    }
	while(temp != NULL)
    {
        int x = temp->data;
        if(x % 2 != 0)
        {
             push(&OddList, x);
        }
        else
        {
            push(&EvenList, x);
        }
        temp = temp->next;
    }


    jointPointer->next = OddList; //last Pointer of EvenList will be attached with  headPointer (Oddlist) of Oddlist
    //cout<<"\n\n"<<jointPointer->data<<"\n\n";
    cout<<"\n\n---EvenList--\n\n";
    printList(EvenList);
    cout<<"\n\n---OddList--\n\n";
    printList(OddList);
    return EvenList;
}

/* UTILITY FUNCTIONS */
/* Function to insert a node at the beginning */
void push(Node** head, int new_data)
{
	/* allocate node */
	Node* new_node = new Node();
	/* put in the data */
	new_node->data = new_data;
	Node *temp = *head;
	if(temp == NULL)
    {
        new_node->next = temp;
        *head = new_node;
    }
    else
    {
        while(temp->next != NULL)
        {
            temp = temp->next;
        }
        temp->next = new_node;
    }
    if(new_data % 2 == 0)
    {
        jointPointer = new_node;
    }
}

/* Function to print nodes in a given linked list */
void printList(Node *node)
{
	while (node != NULL)
	{
		cout << node->data <<"->";
		node = node->next;
	}
}

/* Driver code*/
int main()
{
	/* Start with the empty list */
	Node* head = NULL;

	/* Let us create a sample linked list as following
	2->4->6->8->10->11 */

	push(&head, 5);
	push(&head, 6);
	push(&head, 8);
	push(&head, 7);
	push(&head, 9);


	cout << "Original Linked list\n\n ";
	printList(head);

	head = segregateEvenOdd(&head);

	cout << "\n\n\nModified Linked list ";
	printList(head);
	cout<<"\n\n\n\n\n";

	return 0;
}

// This code is contributed by rathbhupendra
