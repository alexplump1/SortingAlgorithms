/**
 * Shell Sort
 *
 * Shell Sort Algorithm
 * Runs in O(n^3/2) runtime
 * This one is weird. Kinda like
 * insertion sort, but with different size jumps.
 *
 * Sources:
 *
 * @author Alex Plump
 * @version February 1, 2022
 *
 **/

public class ShellSort {
    public static int[] ShellSort(int[] array) {
        //Check for size < 2
        if (array.length < 2){return array;}

        /* Creating jump array */

        //Get number for iterations
        int createJump=0;
        while(((Math.pow(3,createJump)-1) / 2) < array.length) {createJump++;}

        //Create and fill array
        int[] jumps = new int[createJump];
        jumps[0]=1;jumps[1]=2;
        for (int i = 2; i < createJump-1; i++) {jumps[i]=(((int)Math.pow(3,createJump)-1) / 2);}
        /* Explanation: When doing jumps, most effective jump amount is 1/2*(3^n -1).
        * So best jumps are 1,2,4,13,40,... */

        //Iterating through jumps
        for (int i = jumps.length-1; i >= 0; i--) {
            int jumpAmount = jumps[i];

            //Do sorting for required indices
            for (int j = 0; j < jumpAmount; j++) {

                //Check every other n item
                for (int k = 1; k < array.length / jumpAmount; k++) {
                    int unsortedIndex = k * jumpAmount;

                    //Moving item left
                    while ((unsortedIndex-jumpAmount) >= 0 && array[unsortedIndex] < array[unsortedIndex-jumpAmount]) {
                        //Shifting items
                        int temp = array[unsortedIndex];
                        array[unsortedIndex] = array[unsortedIndex - jumpAmount];
                        array[unsortedIndex - jumpAmount] = temp;

                        //Moving to next location
                        unsortedIndex -= jumpAmount;
                    }
                }
            }
        }


        //Return sorted array
        return array;
    }
}
