#include <iostream>
#include <bits/stdc++.h>

using namespace std;

struct Node{
    int data;
    struct Node *link;
};
struct Node *head1 = NULL;
struct Node *head2 = NULL;

void insertAtBeg(struct Node **head, int key){
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node *));
    if(newNode == NULL){
        cout<<"\nNew Node contains Null\n";
        return;
    }
    newNode->data = key;
    newNode->link = *head;
    *head = newNode;
    //cout<<"\n New node "<< newNode->data<<" inserted successfully!\n";
}
void display(struct Node *head){
    //cout<<head->data;
    if(head == NULL)
    {
        cout<<"\nList is Empty\n";
    }
    else{
        struct Node *temp = head;
        cout<<endl;
        while(temp != NULL){
            cout<<temp->data<<" -> ";
            temp= temp->link;
        }
        cout<<"x";
        cout<<endl;
    }
}
struct Node* Merge2List(struct Node *head1,struct Node *head2)
{
    struct Node *temp1 = head1;
    struct Node *temp2 = head2;
    struct Node *head = NULL;
    struct Node *temp = NULL;
    while(temp1 != NULL && temp2 != NULL)
    {
        struct Node *newNode = (struct Node *)malloc(sizeof(struct Node *));//creation of node

        if(head == NULL)//Insert first node in third list
        {
            if(temp1->data <= temp2->data)
            {
                newNode->data = temp1->data;
                temp1 = temp1->link;
            }
            else
            {
                newNode->data = temp2->data;
                temp2 = temp2->link;
            }
            newNode->link = NULL;
            head = newNode;
            temp = newNode;


        }
        else if(temp1->data <= temp2->data)
        {
            newNode->data = temp1->data;
            temp1 = temp1->link;
        }
        else if(temp1->data > temp2->data)
        {
            newNode->data = temp2->data;
            temp2 = temp2->link;
        }

        temp->link = newNode;
        newNode->link = NULL;
        temp = newNode;
    }
    while(temp1 != NULL)
    {
        struct Node *newNode = (struct Node *)malloc(sizeof(struct Node *));
        newNode->data = temp1->data;
        temp->link = newNode;
        newNode->link = NULL;
        temp = newNode;
        temp1 = temp1->link;

    }
    while(temp2 != NULL)
    {
        struct Node *newNode = (struct Node *)malloc(sizeof(struct Node *));
        newNode->data = temp2->data;
        temp->link = newNode;
        newNode->link = NULL;
        temp = newNode;
        temp2 = temp2->link;
    }

    return head;
}
int main()
{
    insertAtBeg(&head1,40);
    insertAtBeg(&head1,10);
    insertAtBeg(&head1,5);
    insertAtBeg(&head1,1);

    cout<<"\n\n ---First LinkedList --- \n\n";
    display(head1);


    insertAtBeg(&head2,50);
    insertAtBeg(&head2,45);
    insertAtBeg(&head2,9);
    insertAtBeg(&head2,6);
    insertAtBeg(&head2,0);

    cout<<"\n\n ---Second LinkedList --- \n\n";
    display(head2);

    cout<<"\n---Merging 2 list----\n";
    struct Node* head3 = Merge2List(head1,head2);

    display(head3);

    free(head1);
    free(head2);
    free(head3);

    return 0;
}
