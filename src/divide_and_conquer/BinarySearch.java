package divide_and_conquer;

import utils.ArrayTool;


/**
 * Time       : 2020/1/5 20:41
 * Author     : tangdaye
 * Description: 二分法搜索
 */
public class BinarySearch {
    public static int search(int target, int[] array) {
        return searchInside(target, array, 0, array.length);
    }

    private static int searchInside(int target, int[] array, int start, int end) {
        if (start >= end) {
            return -1;
        }
        if (end - start == 1) {
            return array[start] == target ? start : -1;
        }
        int mid = (start + end + 1) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (array[mid] < target) {
            return searchInside(target, array, mid + 1, end);
        }
        return searchInside(target, array, start, mid);
    }

    public static void main(String[] args) {
        int[] array = ArrayTool.generationSorted(10);
        int target = 8;
        System.out.println("数组：" + ArrayTool.arrayToString(array));
        System.out.println("目标：" + target);
        System.out.println("下标：" + search(target, array));

    }
}
