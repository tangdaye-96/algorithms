package sort;

/**
 * Time       : 2020/1/4 20:34
 * Author     : tangdaye
 * Description: 插入排序，原地排序算法，稳定
 */
public class InsertionSort implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        for (int i = 1; i < n; i++) {
            int key = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > key) { //  这里是大于比较，所以是稳定的（相同的元素会保持原来的顺序）
                array[j + 1] = array[j];
                j--;
            }
            array[j + 1] = key;
        }
        return array;
    }

    @Override
    public String toString() {
        return "插入排序";
    }
}
