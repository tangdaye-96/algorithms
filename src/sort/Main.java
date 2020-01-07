package sort;

import utils.ArrayTool;

import java.util.Arrays;
import java.util.Date;

/**
 * Time       : 2020/1/4 20:14
 * Author     : tangdaye
 * Description: 排序算法测试
 */
public class Main {
    private static void test(SortStrategy strategy, int[] array) {
        System.out.println("排序前数组");
        System.out.println(ArrayTool.arrayToString(array));
        int[] newArray = strategy.sort(array);
        System.out.println("使用算法：" + strategy);
        System.out.println("输出");
        System.out.println(ArrayTool.arrayToString(newArray));
        System.out.println("排序后数组");
        System.out.println(ArrayTool.arrayToString(array));
    }

    private static void testPerformance(SortStrategy strategy, int[] array) {
        long start = new Date().getTime();
        strategy.sort(array);
        long end = new Date().getTime();
        System.out.println("使用算法：" + strategy);
        System.out.println("用时" + (end - start) + "毫秒");
    }

    public static void main(String[] args) {
        /*
         *基于比较的排序最快速度是O(n*lgn))
         */
        SortStrategy defaultSort = new SortStrategy() {
            /*
             * Description: 看了一下源码，用的是Dual-Pivot Quick Sort algorithm
             * 也就是所谓的多路快排，基本思想是用两个主元代替快速排序中的一个主元
             */
            @Override
            public int[] sort(int[] array) {
                Arrays.sort(array);
                return array;
            }

            @Override
            public String toString() {
                return "系统算法";
            }
        };
        SortStrategy quickSort = new QuickSort();
        SortStrategy heapSort = new HeapSort();
        SortStrategy mergeSort = new MergeSort();
        SortStrategy insertionSort = new InsertionSort();
        testPerformance(defaultSort, ArrayTool.generation(100));
    }
}
