import java.util.Arrays;

public class SearchAndSort implements SearchAndSortInterface {

    // Two-Way Linear Search
    @Override
    public int twoWayLinearSearch(int[] array, int target) {
        for (int i = 0; i <= array.length / 2; i++) {
            if (array[i] == target) return i;
            if (array[array.length - 1 - i] == target) return array.length - 1 - i;
        }
        return -1;
    }

    // Two-Way Bubble Sort (non-destructive)
    @Override
    public int[] twoWayBubbleSort(int[] array) {
        int[] sorted = Arrays.copyOf(array, array.length);
        int left = 0;
        int right = sorted.length - 1;
        boolean swapped;

        do {
            swapped = false;

            for (int i = left; i < right; i++) {
                if (sorted[i] > sorted[i + 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i + 1];
                    sorted[i + 1] = temp;
                    swapped = true;
                }
            }

            right--;

            for (int i = right; i > left; i--) {
                if (sorted[i] < sorted[i - 1]) {
                    int temp = sorted[i];
                    sorted[i] = sorted[i - 1];
                    sorted[i - 1] = temp;
                    swapped = true;
                }
            }

            left++;

        } while (swapped);

        return sorted;
    }

    // Selection Sort
    @Override
    public void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int minIdx = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIdx]) {
                    minIdx = j;
                }
            }
            // swap
            int temp = array[minIdx];
            array[minIdx] = array[i];
            array[i] = temp;
        }
    }

    // Main for testing
    public static void main(String[] args) {
        SearchAndSort lab = new SearchAndSort();

        int[] array = {5, 3, 8, 1, 4, 7};
        int target = 4;

        System.out.println("Original array: " + Arrays.toString(array));

        // Two-Way Linear Search
        int index = lab.twoWayLinearSearch(array, target);
        System.out.println("Two-Way Linear Search: Index of " + target + " is " + index);

        // Two-Way Bubble Sort
        int[] bubbleSorted = lab.twoWayBubbleSort(array);
        System.out.println("Two-Way Bubble Sort result: " + Arrays.toString(bubbleSorted));

        // Bonus Sort
        int[] arrayForBonusSort = Arrays.copyOf(array, array.length);
        lab.sort(arrayForBonusSort);
        System.out.println("Bonus Sort result: " + Arrays.toString(arrayForBonusSort));
    }
}
