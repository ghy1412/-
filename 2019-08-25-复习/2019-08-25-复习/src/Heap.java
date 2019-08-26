import java.util.Arrays;
import java.util.Collections;

public class Heap {
    public static void heapify(int[] array, int size, int index) {
        // 先判断 index 位置处是不是叶子
        // 没有孩子就是叶子
        // 没有左孩子，一定没有右孩子
        // index 处有没有左孩子
        // 查看 index 对应的左孩子应该在的下标是否越界
        int left = 2 * index + 1;
        if (left >= size) {
            return;
        }

        // 找到最大的孩子的下标
        // 1. 只有左孩子             => 左孩子
        // 2. 有左右孩子，左孩子大   => 左孩子
        // 3. 有左右孩子，右孩子大   => 右孩子
        int max = left;
        int right = 2 * index + 2;
        if (right < size) {
            if (array[right] > array[left]) {
                max = right;
            }
        }

        // 判断该位置是否已经满足堆的性质了
        if (array[index] >= array[max]) {
            return;
        }

        swap(array, index, max);
        heapify(array, size, max);
    }

    private static void swap(int[] array, int i, int j) {
        int t = array[i];
        array[i] = array[j];
        array[j] = t;
    }

    public static void createHeap(int[] array, int size) {
        for (int i = (size - 2) / 2; i >= 0; i--) {
            heapify(array, size, i);
        }
    }

    // O(n * log(n))    O(1)
    // 不稳定
    public static void heapSort(int[] array) {
        createHeap(array, array.length);

        for (int i = 0; i < array.length - 1; i++) {
            swap(array, 0, array.length - i - 1);
            heapify(array, array.length - i - 1, 0);
        }

        Arrays.sort(array);
    }

    public static void quickSort(int[] array) {
        quickSortInternal(array, 0, array.length - 1);
    }

    private static void quickSortInternal(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }

        // pivot 下标是 high
        int[] bounds = partition(array, low, high);
        // [low, bounds[0])
        // [bounds[0], bounds[1])
        // [bounds[1], high]
        quickSortInternal(array, low, bounds[0] - 1);
        quickSortInternal(array, bounds[1], high);

    }

    private static int[] partition(int[] array, int low, int high) {
        //    < pivot
        // --------------------------------------
        // |  < pivot | == pivot | ? | > pivot |
        //--------------------------------------
        // low       less,      k,  great,      high
        // array[less] == pivot
        // array[great] > pivot
        int k = low;
        int less = low;
        int great = high;
        int pivot = array[high];

        while (k < great) { // ? {
            if (array[k] == pivot) {
                k++;
            } else if (array[k] < pivot) {
                swap(array, k, less);
                less++;
                k++;
            } else {
                while (k < great && array[great] > pivot) {
                    great--;
                }

                swap(array, k, great);
            }
        }

        return new int[] { less, great };
    }
}
