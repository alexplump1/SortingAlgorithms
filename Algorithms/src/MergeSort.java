/**
 * Merge Sort
 *
 * Merge Sort Algorithm
 * Runs in O(n * log(n)) runtime
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 17, 2022
 *
 **/

public class MergeSort {
    public static int[] MergeSort(int[] array) {
        //Base case
        if (array.length == 1) {
            return array;
        }

        //Halfway variable
        int halfWay = array.length/2;

        //Creating first array
        int[] array1 = new int[halfWay];
        for (int i = 0; i < halfWay; i++) {
            array1[i] = array[i];
        }

        //Creating second array
        int[] array2 = new int[array.length - (halfWay)];
        for (int i = 0; i < array.length-(halfWay); i++) {
            array2[i] = array[i+halfWay];
        }

        //Splitting arrays more
        array1 = MergeSort(array1);
        array2 = MergeSort(array2);

        array = combineArrays(array1, array2);

        return array;
    }

    private static int[] combineArrays(int[] array1, int[] array2) {
        //Creating bigger array
        int[] bigArray = new int[array1.length + array2.length];

        //Create looping variables
        int i = 0;
        int j = 0;
        while (i < array1.length && j < array2.length) {
            if (array1[i] < array2[j]) {
                //Array1's next item is smaller, add to big array
                bigArray[i+j] = array1[i++];
            } else {
                //Array2 has the smaller item
                bigArray[i+j] = array2[j++];
            }
        }

        if (i == array1.length) {
            //array2 has not yet been depleted
            for (int k = j; k < array2.length; k++) {
                bigArray[i+j] = array2[j++];
            }
        } else {
            //array1 has not yet been depleted
            for (int k = i; k < array1.length; k++) {
                bigArray[i+j] = array2[i++];
            }
        }

        return array1;
    }
}
