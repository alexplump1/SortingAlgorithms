/**
 * Heap Sort
 *
 * Heap Sort Algorithm
 * Runs in O(nlog(n)) runtime
 * Creates a max heap and then gets max from heap
 *
 * Sources:
 *
 * @author Alex Plump
 * @version February XX, 2022
 *
 **/

public class HeapSort {
    public static int[] HeapSort(int[] array) {
        /* Turn array into heap */
        //array = traditionalHeap(array);
        //array = topBottomHeap(array);
        array = bottomUpHeap(array);    //Fastest heap maker

        //return sorted array
        return sortDown(array);
    }

    private static int[] traditionalHeap(int[] array) {

        //Return heap
        return array;
    }

    private static int[] topBottomHeap(int[] array) {

        //Return heap
        return array;
    }

    private static int[] bottomUpHeap(int[] array) {


        //Return heap
        return array;
    }

    private static int[] sortDown(int[] array) {
        

        //Return sorted array
        return array;
    }
}
