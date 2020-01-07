package sort;

/**
 * Time       : 2020/1/4 23:40
 * Author     : tangdaye
 * Description: 二路归并排序,并不是一个原地排序的算法，需要额外的空间，但这里我把它们复制回原数组了，稳定的
 */
public class MergeSort implements SortStrategy {

    @Override
    public int[] sort(int[] array) {
        sortInside(array, 0, array.length);
        return array;
    }

    private void sortInside(int[] array, int start, int end) {
        if (start == end || end - start == 1) {
            return;
        }
        int mid = (start + end + 1) / 2;
        sortInside(array, start, mid);
        sortInside(array, mid, end);
        merge(array, start, mid, end);

    }

    private void merge(int[] array, int start, int mid, int end) {
        int[] a = new int[mid - start], b = new int[end - mid], result = new int[end - start];
        if (mid - start > 0) System.arraycopy(array, start, a, 0, mid - start);
        if (end - mid > 0) System.arraycopy(array, mid, b, 0, end - mid);
        int i = 0, j = 0; //开始归并
        // 算了明天再说吧，我室友在秀恩爱，我要吐了
        while (i < a.length && j < b.length) {
            if (a[i] < b[j]) {
                result[i + j] = a[i];
                i++;
            } else {
                result[i + j] = b[j];
                j++;
            }
        }
        // 剩余的合并进去，这两个只有一个会执行
        while (i < a.length) {
            result[i + j] = a[i];
            i++;
        }
        while (j < b.length) {
            result[i + j] = b[j];
            j++;
        }
        // 复制回原数组
        if (end - start >= 0) System.arraycopy(result, 0, array, start, end - start);
    }

    @Override
    public String toString() {
        return "二路归并排序";
    }
}
