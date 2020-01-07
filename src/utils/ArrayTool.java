package utils;

/**
 * Time       : 2020/1/4 21:03
 * Author     : tangdaye
 * Description: 数组相关工具
 */
public class ArrayTool {
    public static int[] generation(int size) {
        int[] result = new int[size];
        int i = 0;
        while (i < size) {
            result[i] = (int) (Math.random() * size * 2);
            i += 1;
        }
        return result;
    }

    public static int[] generationSorted(int size) {
        int[] result = new int[size];
        result[0] = 0;
        int i = 1;
        while (i < size) {
            result[i] = (int) (result[i - 1] + (Math.random() * 5));
            i += 1;
        }
        return result;
    }

    public static String arrayToString(int[] array) {
        return arrayToString(array, array.length);
    }

    public static String arrayToString(int[] array, int length) {
        if (length > array.length)
            length = array.length;
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < length; i++) {
            sb.append(array[i]);
            if (i != length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
