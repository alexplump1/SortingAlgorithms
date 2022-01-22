/**
 * Radix Sort
 *
 * Radix Sort Algorithm
 * Runs in O(n*k) runtime
 * n = number of elements, k = max size of elements
 * Usually ran on strings
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 22, 2022
 *
 **/

import java.util.ArrayList;

public class RadixSort {
    public static String[] RadixSort(String[] array, int maxSize) {
        //Create alphabetic buckets
        ArrayList<String> shortStrings = new ArrayList<>(0);
        ArrayList<String>[] buckets = new ArrayList[26];
        for (int i = 0; i < buckets.length; i++) {buckets[i]=new ArrayList<>(0);} //Initialize arraylist[]

        //Boolean for sorting from first character or last character
        boolean sortForward = true;

        //Index for sorting
        int index;
        if (sortForward) {index = maxSize-1;} else {index = 0;}

        //"Sorting" Strings
        for (int i = 0; i < maxSize; i++) {
            //Putting strings into buckets based off character
            for (String s : array) {
                if (s.length() < index) {
                    shortStrings.add(s);
                } else {
                    buckets[((int) s.charAt(index)) - 97].add(s);
                }
            }

            //Moving Strings from buckets back to array
            int backIndex = 0;
            while (shortStrings.size() > 0) {
                array[backIndex++] = shortStrings.remove(0);
            }
            for (int j = 0; j < buckets.length; j++) {
                while (buckets[j].size() > 0) {
                    array[backIndex++] = buckets[j].remove(0);
                }
            }

            //Decrementing character index
            if (sortForward){index--;}else{index++;}
        }

        //Return "sorted" array
        return array;
    }
}
