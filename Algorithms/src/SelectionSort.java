/**
 * Selection Sort
 *
 * Selection Sort Algorithm
 * Runs in O(n^2) runtime
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 15, 2022
 *
 **/

public class SelectionSort {
    public static int[] SelectionSort(int[] array) {
        //Creating smallest number holder and index
        int smallestNumber;
        int smallestNumIndex;

        //Search list finding smallest item each time
        for (int i = 0; i < array.length-1; i++) {
            smallestNumber = array[i];
            smallestNumIndex = i;

            for (int j = i; j < array.length; j++) {
                if (array[j] < smallestNumber) {
                    smallestNumber = array[j];
                    smallestNumIndex = j;
                }
            }

            //Found smallest number, swapping with array[i]
            array[smallestNumIndex] = array[i];
            array[i] = smallestNumber;
        }

        //Return sorted array
        return array;
    }
}
