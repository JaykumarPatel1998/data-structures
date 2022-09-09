#include <stdio.h>
#include <stdlib.h>

struct stack {
    int size;
    int top;
    int * pointerToFirst; // pointer to first element of array
};

int isEmpty(struct stack *ptr) {
    if (ptr -> top == -1) {
        return 1;
    }
    return 0;
}

int isFull(struct stack *ptr) {
    if (ptr -> top == ptr-> size-1) {
        return 1;
    }
    return 0;
}

int push(struct stack *ptr, int data) {
    if (isFull(ptr)) {
        printf("stack overflow!!\n");
        return -1;
    }
    else {
        ptr -> top++;
        ptr->pointerToFirst[ptr -> top] = data;
        return ptr->top;
    }
}

int pop(struct stack *ptr) {
    if (isEmpty(ptr)) {
        printf("stack underflow!!\n");
        return -1;
    }
    else {
        int data = ptr-> pointerToFirst[ptr -> top];
        ptr -> top--;
        return data;
    }
}

int peek(struct stack *ptr, int index) {
    if (ptr->top-index+1 < 0 || index < 0) {
        printf("array index out of bounds exception has occured.\n");
        return -1;
    }
    else {
        return ptr->pointerToFirst[ptr -> top-index+1];
    }


} 

//helper function
void pushbulk(struct stack *s) {
    // pushing bulk of values into stack
    push(s, 10);
    push(s, 20);
    push(s, 30);
    push(s, 40);
    push(s, 50);
    push(s, 60);
    push(s, 70);
    push(s, 80);
}

int main()
{
    struct stack *s;
    s = (struct stack *)malloc(sizeof(struct stack));
    s->size = 8;
    s->top = -1;
    s->pointerToFirst = (int *) malloc(s->size * sizeof(int));

    // pushing and popping values into stack
    pushbulk(s);

    printf("---------------------- the push operation ends here ---------------\n\n");

    printf("the value in stack at index %d is %d\n", -1, peek(s,-1));
    

    return 0;
}


