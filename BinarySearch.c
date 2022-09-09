#include<stdio.h>
#include<stdlib.h>

int linearSearch(int arr[], int size, int element){
    for (int i = 0; i < size-1; i++)
    {
        if(arr[i] ==element) {
            return i;
        }
    }
    return -1;
}

int binarySearch(int arr[], int size, int element){
    int low, mid, high;

    // initail low and high indices are set here
    low = 0;
    high = size-1;

    //searching starts
    while(low<=high) {
        mid = (low + high) / 2;
        if(arr[mid] ==element) {
            return mid;
        }
        else if(arr[mid]<element) {
            low = mid+ 1;
        }
        else{
            high = mid-1;
        }
    }
    //searching ends

    return -1;

}

int main()
{
    int arr[] = {10,20,30,40,50,60,70,80};
    int size = sizeof(arr)/sizeof(int);
    int element = 10;
    printf("the value of serached index is %d by linear search\n",linearSearch(arr, size, element));
    printf("the value of serached index is %d by binary search",binarySearch(arr, size, element));
    return 0;
}

