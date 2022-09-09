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


int binarySearch(int arr[], int low, int high, int element){
    if  (high >= low) {
        int mid = low + (high - low)/2;

        if (arr[mid]==element)
            return mid;
        
        else if (arr[mid] < element)
            return binarySearch(arr, mid+1, high, element);
        
        else
            return binarySearch(arr, low, mid-1, element);
    }

    return -1;

}

int main()
{
    int arr[] = {10,20,30,40,50,60,70,80};
    int size = sizeof(arr)/sizeof(int);
    int element = 70;
    printf("the value of serached index is %d by linear search\n",linearSearch(arr, size, element));
    printf("the value of serached index is %d by recursive binary search",binarySearch(arr, 0, size-1, element));
    return 0;
}

