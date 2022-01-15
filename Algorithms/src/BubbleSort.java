/**
 * Bubble Sort
 *
 * Bubble Sort Algorithm
 * Runs in O(n^2) runtime
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 15, 2022
 *
 **/

public class BubbleSort {
    public static int[] BubbleSort(int[] array) {
        //Creating loop dependent variable
        boolean isSorted = false;

        //Getting array size
        int arraySize = array.length;

        //Start at leftmost item moving right
        while(!isSorted) {
            //Set condition to sorted
            isSorted=true;

            //Run through list checking i and i+1
            for (int i = 0; i < arraySize-1; i++) {
                if (array[i] > array[i+1]) {    //Items not sorted
                    //Flip items around
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;

                    //Set unsorted to true
                    isSorted=false;
                }
            }
        }

        return array;
    }
}