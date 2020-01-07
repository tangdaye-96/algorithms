package sort;

/**
 * Time       : 2020/1/7 00:07
 * Author     : tangdaye
 * Description: 快速排序, 原地排序算法，不稳定的
 * 的确是最快速的算法，基本上和默认的排序是一样的
 * 算法的美妙之处在于，如果每次partitioning的结果都一致，尽管可能不均衡，比如1：9分布（而不是理想的5：5分布）
 * 实际上最后的复杂度并不会变化（都是n*lgn,只是系数稍有不同）
 */
public class QuickSort implements SortStrategy {

    @Override
    public int[] sort(int[] array) {
        sortInside(array, 0, array.length);
        return array;
    }

    private void sortInside(int[] array, int p, int q) {
        if (p < q) {
            int r = partitioning(array, p, q);
            sortInside(array, p, r);
            sortInside(array, r + 1, q);
        }
    }

    private int partitioning(int[] array, int p, int q) {
        // 因为要原地排序，所以这段代码真的是非常漂亮的的一段代码
        // 循环不变量：从p到i+1之间的数字不比array[p]大，从i+1到j+1之间的数字比array[p]大
        // 随机选取主元,交换第一个元素和主元
        int randomIndex = (int) (Math.random() * (q - p) + p);
        int pivot = array[randomIndex];
        array[randomIndex] = array[p];
        array[p] = pivot;
        int i = p;
        for (int j = p + 1; j < q; j++) {
            if (array[j] <= pivot) {
                i++;
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }
        int temp = array[i];
        array[i] = array[p];
        array[p] = temp;
        return i;
    }

    @Override
    public String toString() {
        return "二路快速排序";
    }
}
