// C++ program to pairwise swap elements
/* in a given linked list
Pairwise swap elements of a given linked list
Given a singly linked list, write a function to swap elements pairwise.

Input : 1->2->3->4->5->6->NULL
Output : 2->1->4->3->6->5->NULL

Input : 1->2->3->4->5->NULL
Output : 2->1->4->3->5->NULL



Input : 1->NULL
Output : 1->NULL


*/


#include <bits/stdc++.h>
using namespace std;

struct Node{
    int data;
    struct Node *next;
};

void printList(struct Node *head)
{
    struct Node *temp = head;
	while (temp != NULL) {
		cout << temp->data << " ";
		temp = temp->next;
	}
}
void push(struct Node **head,int key)
{
    struct Node *new_Node = (struct Node *)malloc(sizeof(struct Node *));
    new_Node->data = key;
    new_Node->next = *head;
    *head = new_Node;
}

void pairWiseSwap(struct Node *head)//swap the data ,Not the Node
{
    struct Node *temp = head;
    while(temp != NULL && temp->next != NULL)
    {
        swap(temp->data,temp->next->data);
        temp = temp->next->next;
    }
}
// Driver Code
int main()
{
	struct Node *root = NULL;

	/* The constructed linked list is:
	1->2->3->4->5 */
	push(&root, 5);
	push(&root, 4);
	push(&root, 3);
	push(&root, 2);
	push(&root, 1);
	push(&root, 0);

	cout << "Linked list "
		<< "before calling pairWiseSwap()\n";
	printList(root);

	pairWiseSwap(root);

	cout << "\nLinked list "
		<< "after calling pairWiseSwap()\n";
	printList(root);

	return 0;
}

// This code is contributed
// by rathbhupendra
