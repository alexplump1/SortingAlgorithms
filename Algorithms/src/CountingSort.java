/**
 * Counting Sort
 *
 * Counting Sort Algorithm - My favorite
 * Runs in O(n + m) runtime
 *  m = size of largest item in array
 *
 * See multiple modifications below
 *
 * @author Alex Plump
 * @version January 17, 2022
 *
 **/

public class CountingSort {

    /**
    * This is the traditional counting sort.
    * It works with objects when modified.
    * It does NOT work with negative numbers.
     * 
     * Space complexity of '2n', (makes 2 additional arrays)
    */
    public static int[] CountingSort(int[] array, int max) {
        //Creating array of occurrences
        int[] occurrences = new int[max+1]; //size includes [0-max]

        //Filling occurrences
        for (int i = 0; i < array.length; i++) {
            occurrences[array[i]] += 1;
        }

        //Carrying occurrences over; [i] = [i] + [i-1]; {1,2,3,4} -> {1,3,6,10}
        for (int i = 1; i < occurrences.length; i++) {
            occurrences[i] += occurrences[i-1];
        }

        //Creating new array, result, and filling it with items from original array
        int[] result = new int[array.length];   //This array is removed in the modified algorithms
        for (int i = result.length-1; i >= 0; i--) {
            //Set result's[array item's occurrence] to array item
            result[occurrences[array[i]] - 1] = array[i];

            /* Can also substitute both lines for */
            //result[occurrences[array[i]]-- -1] = array[i];   //post-decrements in same line, but hard to read

            //Decrement used occurrence
            occurrences[array[i]] -= 1;
        }

        return result;
    }

    /**
     * This is a modified counting sort.
     * It works with objects when modified.
     * It DOES work with negative numbers.
     *
     * **The reason this works with negative numbers is because of the shift variable. Usually,
     * Counting Sort can only use positive numbers because it directly maps these numbers to indices
     * in the occurrence list, Ex:
     * {3,5,6,0,3} ->   0 1 2 3 4 5 6
     *                 {1,0,0,2,0,1,1}
     * and negative numbers cause errors as array[-1] does not exist.
     * Using shift, this allows indices to shift corresponding to the minimum number. Ex:
     * {-3,5,6,0,-3} ->   -3 -2 -1    0 1 2 3 4 5 6
     *                    {2, 0, 0,   1,0,0,0,0,1,1}
     * 
     * Uses space complexity '2n'
     */
    public static int[] CountingSort2(int[] array) {
        //Getting minimum and maximum values
        int min = getMin(array);
        int max = getMax(array);

        //Getting size of occurrence array
        int k = max - min;

        //Creating shift, for negative numbers to be mapped to 0-n indices
        int shift = -1 * min;

        //Creating array of occurrences
        int[] occurrences = new int[k + 1]; //size includes [0-max]

        //Filling occurrences
        for (int i = 0; i < array.length; i++) {
            occurrences[array[i] + shift] += 1;
        }

        //Carrying occurrences over; [i] = [i] + [i-1]; {1,2,3,4} -> {1,3,6,10}
        for (int i = 1; i < occurrences.length; i++) {
            occurrences[i] += occurrences[i-1];
        }

        //Creating new array, result, and filling it with items from original array
        int[] result = new int[array.length];   //This array is removed in the modified algorithms
        for (int i = result.length-1; i >= 0; i--) {
            //Set result's[array item's occurrence] to array item
            result[occurrences[array[i] + shift] - 1] = array[i];

            /* Can also substitute both lines for */
            //result[occurrences[array[i] + shift]-- -1] = array[i];   //post-decrements in same line, but hard to read

            //Decrement used occurrence
            occurrences[array[i] + shift] -= 1;
        }

        return result;
    }

    /**
    * This is another modified counting sort;
     * It does NOT work with objects, only integers.
     * It DOES work with negative numbers.
     * It is also easiest to read.  <---
     * 
     * Uses space complexity 'n' instead of '2n'
     *
     * This algorithm was inspired by a discussion in:
     *      Purdue CS251 - Data Structures and Algorithms - Fall 2021
     *
     * Explanation of algorithm:
     * Occurrences holds how many times a number showed up
     * Ex:
     * array = {3,5,6,0,3}                      0 1 2 3 4 5 6
     *                           occurrences = {1,0,0,2,0,1,1}
     *
     * Now when adding back to original array, go through occurrences
     * and add that index, as many times as it showed up
     * array = {0,-,-,-,-}                      0 1 2 3 4 5 6
     *                           occurrences = {1,0,0,2,0,1,1}
     *                                          ^
     * array = {0,-,-,-,-}                      0 1 2 3 4 5 6
     *                           occurrences = {1,0,0,2,0,1,1}
     *                                            ^
     * array = {0,-,-,-,-}                      0 1 2 3 4 5 6
     *                           occurrences = {1,0,0,2,0,1,1}
     *                                              ^
     * array = {0,3,3,-,-}                      0 1 2 3 4 5 6
     *                           occurrences = {1,0,0,2,0,1,1}
     *                                                ^
     *                   ...
     */
    public static int[] CountingSort3(int[] array) {
        //Getting minimum and maximum values
        int min = getMin(array);
        int max = getMax(array);

        //Getting size of occurrence array
        int k = max - min;

        //Creating shift, for negative numbers to be mapped to 0-n indices
        int shift = -1 * min;

        //Creating array of occurrences
        int[] occurrences = new int[k + 1];
        //for (int i = 0; i < k+1; i++) {C[i]=0;}     //Filling with zeros, not necessary in Java

        //Filling occurrences
        for (int i = 0; i < array.length; i++) {
            occurrences[array[i] + shift] += 1;
        }

        //Finds all numbers which showed up in original array, and adds them back into array numerically
        int openSpot = 0;
        for (int i = 0; i < occurrences.length; i++) {
            while (occurrences[i] != 0) {
                array[openSpot++] = i - shift;
                occurrences[i]--;
            }
        }

        return array;
    }

    /**
     * These functions are for the modified algorithms, which work with negative numbers
     */

    public static int getMin(int[] array) {
        if (array.length < 1){return -1;}

        int min = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min){min=array[i];}
        }

        return min;
    }

    public static int getMax(int[] array) {
        if (array.length < 1){return -1;}

        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max){max=array[i];}
        }

        return max;
    }

}
