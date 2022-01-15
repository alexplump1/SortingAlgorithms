import java.util.Random;

public class RunSort {
    public static void main(String[] args) {
        //Variables for creating array
        int minNum = 0;
        int maxNum = 1000;
        int numOfElements = 100;

        //Creating array
        int[] myArray = createIntArray(minNum, maxNum, numOfElements);

        //Sorting Algorithms
        myArray = BubbleSort.BubbleSort(myArray);


        //Checking correct sorting
        assert(checkSorted(myArray));
        System.out.println("Worked");
    }

    private static int[] createIntArray(int min, int max, int num) {
        if (num<2) {return null;}   //if not enough items, don't create
        int[] newArray = new int[num];
        Random randomItem = new Random();
        for (int i = 0; i < num; i++) {
            newArray[i] = randomItem.nextInt(max-min)+min;
        }
        return newArray;
    }

    private static boolean checkSorted(int[] sortedArray) {
        if(sortedArray==null){return true;}
        for (int i = 0; i < sortedArray.length-1; i++) {
            if (sortedArray[i] > sortedArray[i+1]) {
                return false;
            }
        }
        return true;
    }
}