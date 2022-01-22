/**
 * Run Sort
 *
 * This is the main file to call other sorting algorithms
 *
 * Sources:
 *
 * @author Alex Plump
 * @version Updated after every algorithm added
 *
 **/

import java.util.Random;

public class RunSort {
    public static void main(String[] args) {
        //Variables for creating int array
        int minNum = 100;
        int maxNum = 1000;

        //Variable for string array (radix sort)
        int maxStringSize = 5;
        boolean sameSizeStrings = true;

        //Number of elements for any array
        int numOfElements = 20;

        //Creating array
        int[] myArray = createIntArray(minNum, maxNum, numOfElements);

        String[] sArray = createStringArray(maxStringSize, sameSizeStrings, numOfElements);

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

        //Radix sort / topological sort for strings
        sArray = RadixSort.RadixSort(sArray, maxStringSize);

        //Checking correct sorting
        //printIntArray(myArray);
        printStrArray(sArray);
        assert(checkSorted(myArray));

        //For visual confirmation
        System.out.println(checkSorted(myArray));
    }

    private static int[] createIntArray(int min, int max, int num) {
        if (num<2) {return null;}   //if not enough items, don't create
        int[] newArray = new int[num];
        Random randomItem = new Random();
        for (int i = 0; i < num; i++) {
            newArray[i] = randomItem.nextInt((max+1)-min)+min;      //nI(901) -> 0-900
        }
        return newArray;
    }

    private static String[] createStringArray(int maxSize, boolean sameSize, int num) {
        if (num<1){return null;}
        String[] newArray = new String[num];
        Random randomItem = new Random();
        for (int i = 0; i < num; i++) {
            if (sameSize) {     //Same size strings
                char[] newString = new char[maxSize];
                for (int j = 0; j < maxSize; j++) {
                    newString[j] = (char) (randomItem.nextInt(26)+97);
                }
                newArray[i] = new String(newString);
            } else {    //Different sizes
                char[] newString = new char[randomItem.nextInt(maxSize)+1]; //Min size is 1
                for (int j = 0; j < newString.length; j++) {
                    newString[j] = (char) (randomItem.nextInt(26)+97);
                }
                newArray[i] = new String(newString);
            }
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

    private static void printIntArray(int[] array) {
        System.out.print("Array=[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.printf("%d, ", array[i]);
        } System.out.printf("%d]\n", array[array.length-1]);
    }

    private static void printStrArray(String[] array) {
        System.out.print("Array=[");
        for (int i = 0; i < array.length-1; i++) {
            System.out.printf("%s, ", array[i]);
        } System.out.printf("%s]\n", array[array.length-1]);
    }

}