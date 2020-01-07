package sort;

import utils.ArrayTool;

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
            int r = ArrayTool.partitioning(array, p, q);
            sortInside(array, p, r);
            sortInside(array, r + 1, q);
        }
    }

    @Override
    public String toString() {
        return "二路快速排序";
    }
}
