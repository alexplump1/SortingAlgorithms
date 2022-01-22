import java.util.Random;

public class RunSort {
    public static void main(String[] args) {
        //Variables for creating array
        int minNum = 100;
        int maxNum = 1000;
        int numOfElements = 100;

        //Creating array
        int[] myArray = createIntArray(minNum, maxNum, numOfElements);

        //Sorting Algorithms
        //myArray = BubbleSort.BubbleSort(myArray);
        //myArray = InsertionSort.InsertionSort(myArray);
        //myArray = SelectionSort.SelectionSort(myArray);
        //myArray = MergeSort.MergeSort(myArray);
        //myArray = CountingSort.CountingSort(myArray, maxNum);     //Can't handle neg. numbers
        //myArray = CountingSort.CountingSort2(myArray);            //Can handle neg. numbers
        //myArray = CountingSort.CountingSort3(myArray);            //Can handle neg. numbers
        //myArray = BucketSort.BucketSort(myArray, minNum, maxNum);
        myArray = QuickSort.QuickSort(myArray, 0, numOfElements - 1);
        



        //Checking correct sorting
        //printArray(myArray);
        assert(checkSorted(myArray));

        //For visual confirmation
        System.out.println(checkSorted(myArray));
    }

    private static int[] createIntArray(int min, int max, int num) {
        if (num<2) {return null;}   //if not enough items, don't create
        int[] newArray = new int[num];
        Random randomItem = new Random();
        for (int i = 0; i < num; i++) {
            newArray[i] = randomItem.nextInt(max-min)+min;
        }
        return newArray;
    }

    private static boolean checkSorted(int[] sortedArray) {
        if(sortedArray==null){return true;}
        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] > sortedArray[i+1]) {
                System.out.printf("Array[%d] = %d; Array[%d] = %d\n", i, sortedArray[i], i+1, sortedArray[i+1]);
                return false;
            }
        }
        return true;
    }

    private static void printArray(int[] array) {
        System.out.printf("Array=[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.printf("%d, ", array[i]);
        } System.out.printf("%d]\n", array[array.length-1]);
    }
}