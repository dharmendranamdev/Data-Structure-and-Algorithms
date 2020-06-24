#include <iostream>
#include<bits/stdc++.h>
using namespace std;
#define MAX 10

struct Mystack{
    int capacity;
    int top;
    int *array;
};

struct Mystack * createStack()
{
    struct Mystack *s = (struct Mystack *)malloc(sizeof(struct Mystack *));
    s->capacity = MAX;
    s->top = -1;
    s->array = (int *)malloc(sizeof(s->capacity * sizeof(int)));
    if(!s->array)
    {
        return NULL;
    }
    return s;
}

int isEmpty(struct Mystack *s)
{
    return (s->top == -1);
}
int isFull(struct Mystack *s)
{
    return (s->top == s->capacity - 1);
}
void push(struct Mystack *s,int data)
{
    if(isFull(s))
        cout<<"Stack Overflow";
    else{
        s->array[++s->top] = data;
    }
}
int pop(struct Mystack *s){
    if(isEmpty(s))
    {
        cout<<"Stack UnderFlow!";
        return INT_MIN;
    }
    else{
        return (s->array[s->top--]);
    }
}

void DeleteStack(struct Mystack *s)
{

    if(s)
    {
        if(s->array)
            free(s->array);
        free(s);
    }
}
int main()
{
    struct Mystack *s1 = createStack();//but less then or equal MAX
    //cout<<s1->capacity;
    //cout<<s1->top;
    push(s1,1);
    push(s1,2);
    push(s1,3);
    push(s1,4);
    push(s1,5);
    push(s1,6);



    cout<<"capacity Top Array[top]\n--------------------------------------\n";
    cout<<s1->capacity<<"\t";
    cout<<s1->top<<"\t";
    cout<<s1->array[s1->top]<<"\n\n";

    pop(s1);
    pop(s1);

    cout<<s1->capacity<<"\t";
    cout<<s1->top<<"\t";
    cout<<s1->array[s1->top]<<"\n\n";

    return 0;
}
