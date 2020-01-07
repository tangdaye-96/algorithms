package practise.jian_zhi_offer;

import divide_and_conquer.BinarySearch;
import utils.MatrixTool;

import java.util.Date;

/**
 * Time       : 2020/1/4 23:21
 * Author     : tangdaye
 * Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInMatrix {

    interface FindMethod {
        boolean find(int target, int[][] array);
    }

    static class MyFind implements FindMethod {
        @Override
        public boolean find(int target, int[][] array) {
            return FindInMatrix.find(target, array);
        }
    }

    static class AnswerFind implements FindMethod {
        @Override
        public boolean find(int target, int[][] array) {
            return FindInMatrix.find2(target, array);
        }
    }

    /**
     * Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * r s
     * t u
     * Input:       目标整数target，二维数组array
     * Output:      目标整数是否在二维数组中
     */
    private static boolean find(int target, int[][] array) {
        if (array.length == 0) return false;
        if (array[0].length == 0) return false;
        return findInside(target, array, 0, 0, array.length, array[0].length);
    }

    private static boolean find2(int target, int[][] array) {
        if (array.length == 0) return false;
        if (array[0].length == 0) return false;
        int i = 0, j = array[0].length - 1;
        while (i < array.length && j >= 0) {
            if (array[i][j] == target) return true;
            else if (array[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }


    /**
     * Description: 目标整数target是否在array的st和uv之间
     */
    private static boolean findInside(int target, int[][] array, int s, int t, int u, int v) {
        int m = u - s, n = v - t;
        if (m < 1 || n < 1) return false;
        if (m == 1) {
            int[] newArray = new int[n];
            System.arraycopy(array[s], t, newArray, 0, n);
            return BinarySearch.search(target, newArray) >= 0;
        }
        if (n == 1) {
            int[] newArray = new int[m];
            for (int i = 0; i < m; i++) {
                newArray[i] = array[s + i][t];
            }
            return BinarySearch.search(target, newArray) >= 0;
        }
        int ele1 = array[s + m / 2 - 1][t + n / 2 - 1];
        int ele2 = array[s + m / 2][t + n / 2];
        if (ele1 == target) return true;
        if (ele2 == target) return true;
        if (target < ele1) {
            return findInside(target, array, s, t, s + m / 2 - 1, t + n / 2 - 1)//左上
                    || findInside(target, array, s, t + n / 2 - 1, s + m / 2 - 1, v)//右上
                    || findInside(target, array, s + m / 2 - 1, t, u, t + n / 2 - 1);//左下
        }
        if (target > ele2) {
            return findInside(target, array, s + m / 2 + 1, t + n / 2 + 1, u, v)//右下
                    || findInside(target, array, s, t + n / 2 + 1, s + m / 2 + 1, v)//右上
                    || findInside(target, array, s + m / 2, t, u, t + n / 2 + 1);//左下
        }
        return findInside(target, array, s, t + n / 2, s + m / 2, v) //右上
                || findInside(target, array, s + m / 2, t, u, t + n / 2); //左下
    }

    private static long test(FindMethod method, int[][] array, int target) {
        long start = new Date().getTime();
        System.out.println(method.find(target, array));
        long end = new Date().getTime();
        return end - start;
    }

    public static void main(String[] args) {
        int t = 20000;
        int[][] array = MatrixTool.generateSortedMatrix(t, t);
        int target = (int) (Math.random() * t * 4);
        FindMethod myFind = new MyFind();
        FindMethod answerFind = new AnswerFind();
        System.out.println(test(myFind, array, target));
        System.out.println(test(answerFind, array, target));
    }
}
