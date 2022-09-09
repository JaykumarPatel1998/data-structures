public class Sorting{

    public void printArray(int [] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i==0) {
                System.out.print("["+arr[i]);
            }
            else{
                System.out.print(", "+arr[i]);
            }
        }
        System.out.print("]");
    }


    public void bubbleSort(int[] a) {
        int temp;
        boolean isSorted = false;

        for (int i = 0; i < a.length-1; i++) { // number of passes in the bubbleSort is (n-1)
            isSorted = true;
            for (int j = 0; j < a.length-1-i; j++) { // this loop specifies the number of comparisons made in each pass (n-1-i)
                if (a[j] > a[j+1]) {
                    temp = a[j];
                    a[j] = a[j+1];
                    a[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted) {
                return;
            }
        }
    }



    public static void main(String[] args) {
        int [] arr = {21, -20, 1987, 2829, 9, 0, -34, 78};
        Sorting s = new Sorting();

        System.out.println("The original unsorted array is :");
        s.printArray(arr);
        // System.out.println("\nThe bubble sorted array is :");
        // s.bubbleSort(arr);
        // s.printArray(arr);
        System.out.println("\nThe insertion sorted array is :");
        s.bubbleSort(arr);
        s.printArray(arr);
    }
}






