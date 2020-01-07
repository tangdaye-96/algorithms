package utils;

/**
 * Time       : 2020/1/4 21:03
 * Author     : tangdaye
 * Description: 数组相关工具
 */
public class ArrayTool {
    public static int partitioning(int[] array, int p, int q) {
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
