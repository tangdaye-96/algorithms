package sort;

import structure.Heap;

/**
 * Time       : 2020/1/4 21:35
 * Author     : tangdaye
 * Description: 堆排序,原地排序，不稳定排序
 */
public class HeapSort implements SortStrategy {

    @Override
    public int[] sort(int[] array) {
        Heap heap = new Heap(array);
        heap.sort();
        return array;
    }

    @Override
    public String toString() {
        return "堆排序";
    }
}
