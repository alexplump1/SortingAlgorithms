import java.util.ArrayList;

/**
 * Bucket Sort
 *
 * Bucket Sort Algorithm
 * Runs in O(n) runtime*, worst case scenario - O(n^2)
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January 17, 2022
 *
 **/

public class BucketSort {
    /**
     * Quick Note about bucket sort. It can be O(n) based off how many buckets are used,
     * and can also be O(n^2) depending on which additional sorting algorithm it is paired with.
     *
     * My implementation uses 10 buckets and insertion sort
     * */
    private static int[] mapping;
    public static int[] BucketSort(int[] array, int min, int max) {
        //Initializer for number of buckets used
        int numOfBuckets = 10;

        //Create map, like a hash map
        mapping = new int[numOfBuckets];
        fillMap(min, max);

        //Create list of buckets
        ArrayList<Integer>[] bucketList = new ArrayList[numOfBuckets];

        //Defining each bucket
        for (int i = 0; i < bucketList.length; i++) {
            bucketList[i] = new ArrayList<>();
        }

        //Adding integers to their respective buckets
        for (int currentInt : array) {
            //Check if null, and add to that bucket
            bucketList[getBucketNum(currentInt)].add(currentInt);
        }

        //Sorting each Bucket; This determines runtime. Because I use insertion sort, runtime is O(n^2)
        for (int i = 0; i < bucketList.length; i++) {
            //Convert bucket to array
            int[] bucketArray = new int[bucketList[i].size()];

            //Copying numbers to array
            for (int j = 0; j < bucketArray.length; j++) {
                bucketArray[j] = bucketList[i].get(j);
            }

            //Sorting bucket array
            bucketArray = InsertionSort.InsertionSort(bucketArray);

            //Copying sorted numbers back to list
            for (int j = 0; j < bucketArray.length; j++) {
                bucketList[i].set(j,bucketArray[j]);
            }
        }

        array = combineBuckets(bucketList, array.length);

        //Return sorted array
        return array;
    }

    private static int[] combineBuckets(ArrayList<Integer>[] bucketList, int size) {
        //Creating sorted array
        int[] array = new int[size];

        //Variable to keep track of index
        int arrayIndex = 0;

        //Iterate through all sorted buckets and copy numbers to array
        for (int i = 0; i < bucketList.length; i++) {
            for (int j = 0; j < bucketList[i].size(); j++) {
                array[arrayIndex++] = bucketList[i].get(j);
            }
        }

        return array;
    }

    //This could use some optimization
    private static void fillMap(int min, int max) {
        int range = max - min;
        mapping[0] = min;
        for (int i = 1; i < mapping.length; i++) {
            mapping[i] = i * (range / mapping.length);
        }
    }

    private static int getBucketNum(int number) {
        for (int i = 0; i < mapping.length-1; i++) {
            if (mapping[i] <= number && number < mapping[i+1]) {
                return i;
            }
        }

        return mapping.length-1;
    }
}
