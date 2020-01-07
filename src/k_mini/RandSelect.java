package k_mini;

import utils.ArrayTool;

/**
 * Time       : 2020/1/7 21:13
 * Author     : tangdaye
 * Description: 随机选择法，线性时间找到第k小的
 */
public class RandSelect implements KMini {
    @Override
    public int kNumber(int[] array, int k) {
        return selectInside(array, 0, array.length, k - 1);
    }

    @Override
    public int median(int[] array) {
        int n = array.length;
        if (n % 2 == 1) return kNumber(array, (n - 1) / 2);
        return (kNumber(array, n / 2) + kNumber(array, n / 2 - 1)) / 2;
    }

    /**
     * Description: 在数组array的pq范围内找到第i小的元素，i从0开始，到n-1结束
     */
    private int selectInside(int[] array, int p, int q, int i) {
        if (p >= q) return array[p];
        int r = ArrayTool.partitioning(array, p, q);
        int k = r - p + 1;
        if (i == k) return array[r];
        if (i < k) return selectInside(array, p, r, i);
        return selectInside(array, r + 1, q, i - k);
    }

    public static void main(String[] args) {
        int[] array = ArrayTool.generationSorted(11);
        System.out.println(ArrayTool.arrayToString(array));
        System.out.println(new RandSelect().median(array));
    }
}
