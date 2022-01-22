/**
 * Shell Sort
 *
 * Shell Sort Algorithm
 * Runs in O(n^3/2) runtime
 * This one is weird. Kinda like
 * insertion sort, but with different size jumps.
 * Still a work in progress.
 *
 * Sources:
 *
 * @author Alex Plump
 * @version January XX, 2022
 *
 **/

public class ShellSort {
    public static int[] ShellSort(int[] array) {
        //Creating jump array
        int createJump=0;
        while(((Math.pow(3,createJump)-1) / 2) < array.length) {createJump++;}
        int[] jumps = new int[createJump];
        for (int i = createJump-1; i >= 0; i--) {jumps[i]=(((int)Math.pow(3,createJump)-1) / 2);}
        /* Explanation: When doing jumps, most effective jump amount is 1/2*(3^n -1).
        * So best jumps are 1,2,4,13,40,... */




        //Return sorted array
        return array;
    }
}
