/**
 * Insertion Sort
 *
 * Insertion Sort Algorithm
 * Runs in O(n^2) runtime
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 15, 2022
 *
 **/

public class InsertionSort {
    public static int[] InsertionSort(int[] array) {

        //Selecting unsorted item, moving left to sorted location
        for (int i = 1; i < array.length; i++) {
            int checkIndex = i;

            //Moving item left
            while (checkIndex != 0 && array[checkIndex] < array[checkIndex-1]) {
                //Shifting items
                int temp = array[checkIndex];
                array[checkIndex] = array[checkIndex-1];
                array[checkIndex-1] = temp;

                //Moving to next location
                checkIndex--;
            }
        }

        //Return sorted array
        return array;
    }
}
