package sort;

/**
 * Time       : 2020/1/7 17:17
 * Author     : tangdaye
 * Description: 计数排序，限定待排序整数在一定范围内，稳定，需要额外空间
 */
public class CountingSort implements SortStrategy {
    /**
     * Description: array的长度是n，所有整数限定在[0,2n)内
     */
    @Override
    public int[] sort(int[] array) {
        int n = array.length;
        int[] result = new int[n];
        int[] counts = new int[2 * n];
        // 初始化为0
        for (int i = 0; i < 2 * n; i++) {
            counts[i] = 0;
        }
        for (int index : array) {
            counts[index] += 1;
        }
        int index = 0;
        for (int i = 0; i < 2 * n; i++) {
            while (counts[i] > 0) {
                result[index] = i;
                index += 1;
                counts[i]--;
            }
        }
        return result;
    }

    @Override
    public String toString() {
        return "计数排序";
    }
}
