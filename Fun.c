#include <stdio.h>
#include <stdlib.h>

struct stack {
    int size;
    int top;
    int * pointerToFirst; // pointer to first element of array
};

// int isEmpty(struct stack *ptr) {
//     if (ptr -> top == -1) {
//         return 1;
//     }
//     return 0;
// }

// int isFull(struct stack *ptr) {
//     if (ptr -> top == ptr-> size-1) {
//         return 1;
//     }
//     return 0;
// }

// int push(struct stack *ptr, int data) {
//     if (isFull(ptr)) {
//         printf("stack overflow!!\n");
//         return -1;
//     }
//     else {
//         ptr -> top++;
//         ptr->pointerToFirst[ptr -> top] = data;
//         return ptr->top;
//     }
// }

// int pop(struct stack *ptr) {
//     if (isEmpty(ptr)) {
//         printf("stack underflow!!\n");
//         return -1;
//     }
//     else {
//         int data = ptr-> pointerToFirst[ptr -> top];
//         ptr -> top--;
//         return data;
//     }
// }

void manipulateData(struct stack p) {
    p.pointerToFirst[0] = 12;
    p.top++;
    p.pointerToFirst[1] = 13;
    p.top++;
    p.pointerToFirst[2] = 14;
    p.top++;
    p.pointerToFirst[3] = 15;
    p.top++;
    printf("the top value of manipulated data is %d\n", p.top);

}

int main()
{
    struct stack s;
    // s = (struct stack *)malloc(sizeof(struct stack));
    s.size = 8;
    s.top = -1;
    s.pointerToFirst = (int *) malloc(s.size * sizeof(int));
    manipulateData(s);
    printf("%d\n", s.top);

    // pushing and popping values into stack
    // printf("The value of top is %d\n", push(s, 10));
    // printf("The value of top is %d\n", push(s, 20));
    // printf("The value of top is %d\n", push(s, 30));
    // printf("The value of top is %d\n", push(s, 40));
    // printf("The value of top is %d\n", push(s, 50));
    // printf("The value of top is %d\n", push(s, 60));
    // printf("The value of top is %d\n", push(s, 70));
    // printf("The value of top is %d\n", push(s, 80));
    // printf("The value of top is %d\n", push(s, 90));

    // printf("---------------------- the pop operation begns here ---------------\n\n");

    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));
    // printf("The value popped is %d\n", pop(s));

    return 0;
}
