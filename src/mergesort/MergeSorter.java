package mergesort;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class MergeSorter implements Callable<List<Integer>> {
    private List<Integer> arrayToSort;
    private ExecutorService executorService;

    public MergeSorter(List<Integer> arrayToSort, ExecutorService executorService) {
        this.arrayToSort = arrayToSort;
        this.executorService = executorService;
    }

    @Override
    public List<Integer> call() throws Exception {
        // S1. breaking condition
        if (arrayToSort.size() <= 1) {
            return arrayToSort;
        }

        // S2. find the mid of array.
        int mid = arrayToSort.size() / 2;

        // S3. create leftArray
        List<Integer> leftArray = new ArrayList<>();

        for (int i = 0; i < mid; ++i) { // leftArray = [1,2,3]
            leftArray.add(arrayToSort.get(i));
        }

        // S4. create leftArray
        List<Integer> rightArray = new ArrayList<>();

        for (int i = mid; i < arrayToSort.size(); ++i) { // [4,5,6]
            rightArray.add(arrayToSort.get(i));
        }

        /**
         * Now Left and Right SubArrays Are Created...
         * You would want the Merge-Sort to run on those Left and Right Sub Arrays.
         */

        MergeSorter leftMergeSorter = new MergeSorter(leftArray, executorService); // [1,2,3]  --- 2
        MergeSorter rightMergeSorter = new MergeSorter(rightArray, executorService);

        /**
         * left: 1,2,3
         *
         *
         */


        // calling the self func again...
        List<Integer> leftSortedArray = leftMergeSorter.call();
        List<Integer> rightSortedArray = rightMergeSorter.call();

        List<Integer> sortedArray = new ArrayList<>();

        int i = 0;
        int j = 0;

        /**
         * Now we would need the arrays .... because we want to merge them.
         */

        while (i < leftSortedArray.size() && j < rightSortedArray.size()) {
            if (leftSortedArray.get(i) < rightSortedArray.get(j)) {
                sortedArray.add(leftSortedArray.get(i));
                ++i;
            } else {
                sortedArray.add(rightSortedArray.get(j));
                ++j;
            }
        }

        while (i < leftSortedArray.size()) {
            sortedArray.add(leftSortedArray.get(i));
            ++i;
        }

        while (j < rightSortedArray.size()) {
            sortedArray.add(rightSortedArray.get(j));
            ++j;
        }

        return sortedArray;
    }
}

