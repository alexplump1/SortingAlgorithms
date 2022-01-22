/**
 * Quick Sort
 *
 * Quick Sort Algorithm - My least favorite
 * Runs in O(n^2) runtime, usually O(n * log(n))
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 22, 2022
 *
 **/

public class QuickSort {
    private static int[] array;
    public static int[] QuickSort(int[] tempArray, int min, int max) {
        //First call only
        if (array==null) {array = tempArray;}

        //Check if size is too small
        if (min < max) {
            //Getting index to split array
            int index = partition(min, max);

            //Calling quick sort on each half
            QuickSort(tempArray, min, index - 1);
            QuickSort(tempArray, index + 1, max);
        }

        //Return sorted array
        return array;
    }

    private static int partition(int min, int max) {
        //** Uses pivot as last item **
        int pivot = array[max];

        //Swapping index
        int i = min - 1;

        //Iterate through whole list
        for (int j = min; j < max ; j++) {
            //See is element should be on left or right of pivot
            if (array[j] < pivot) {
                //Swap elements and increment i
                int temp = array[++i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        //Swapping with pivot
        int temp = array[++i];
        array[i] = pivot;
        array[max] = temp;

        //Return index of new pivot
        return i;
    }
}
