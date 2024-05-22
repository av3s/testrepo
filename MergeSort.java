import java.text.MessageFormat;
import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] A = {5, 2, 4, 6, 100, 1, 9, 3, 2, 6, 25, 8, 15, 10};
        int startPosition = 6;
        int endPosition = A.length - 1;
        System.out.print("Unsorted array :\n\t");
        printArray(A);
        System.out.print(MessageFormat.format("Sorted array from {0} to {1} positions:\n\t", startPosition, endPosition));
        sort(A, startPosition, endPosition);
        printArray(A);
    }

    static void sort(int[] A, int p, int r) {
        if (p < r) {
            int q = (p + r) >> 1; // деление на 2 с помощью сдвига с отсечением остатка
            sort(A, p, q);
            sort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    static void merge(int[] A, int p, int q, int r) {
        //[p..q][q+1..r]
        int leftSubArray[] = new int[q - p + 1];
        int rightSubArray[] = new int[r - q];
        for (int i = 0; i < q - p + 1; i++) {
            leftSubArray[i] = A[p + i];
        }
        for (int j = 0; j < r - q; j++) {
            rightSubArray[j] = A[q + 1 + j];
        }

        int i = 0, j = 0, k = p;
        while ((i < q - p + 1) && (j < r - q)) {
            if (leftSubArray[i] <= rightSubArray[j]) {
                A[k] = leftSubArray[i];
                i++;
            } else {
                A[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        for (; i < q - p + 1; i++) {
            A[k] = leftSubArray[i];
            k++;
        }
        for (; j < r - q; j++) {
            A[k] = rightSubArray[j];
            k++;
        }
    }

    static void printArray(int[] A) {
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.stream(A).forEach(elem -> stringBuilder.append(elem).append(' '));
        System.out.println(stringBuilder);
    }
}

