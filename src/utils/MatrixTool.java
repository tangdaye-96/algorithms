package utils;

/**
 * Time       : 2020/1/7 00:08
 * Author     : tangdaye
 * Description: 矩阵相关工具
 */
public class MatrixTool {
    /**
     * Description: 取矩阵source ij元素和st元素之间在子矩阵(包括ij所在行列，不包括st所在行列)
     */
    public static int[][] subMatrix(int[][] source, int i, int j, int s, int t) {
        int[][] result = new int[s - i][t - j];
        for (int x = i; x < s; x++) {
            if (t - j >= 0) System.arraycopy(source[x], j, result[x - i], 0, t - j);
        }
        return result;
    }

    /**
     * Description: 将subMatrix合并进source,位置从i，j开始
     */
    public static void mergeMatrix(int[][] source, int[][] subMatrix, int i, int j) {
        int m = subMatrix.length, n = subMatrix[0].length;
        for (int x = 0; x < m; x++) {
            System.arraycopy(subMatrix[x], 0, source[i + x], j, n);
        }
    }

    /**
     * Description: 矩阵的加法，a和b都是m*n的
     */
    public static int[][] matrixAdd(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] + b[i][j];
            }
        }
        return result;
    }


    /**
     * Description: 矩阵的减法，a和b都是m*n的
     */
    public static int[][] matrixMinus(int[][] a, int[][] b) {
        int m = a.length, n = a[0].length;
        int[][] result = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = a[i][j] - b[i][j];
            }
        }
        return result;
    }

    /**
     * Description: 每一行每一列都单调增的矩阵
     */
    public static int[][] generateSortedMatrix(int m, int n) {
        int[][] result = new int[m][n];
        // 第一行
        for (int i = 0; i < m; i++) {
            if (i == 0) result[0][i] = 0;
            else result[0][i] = (int) (result[0][i - 1] + Math.random() * 2);
        }
        // 第一列
        for (int i = 0; i < n; i++) {
            if (i == 0) result[i][0] = 0;
            else result[i][0] = (int) (result[i - 1][0] + Math.random() * 2);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int left = (int) (result[i][j - 1] + Math.random() * 2);
                int top = (int) (result[i - 1][j] + Math.random() * 2);
                result[i][j] = left >= top ? left : top;
            }
        }
        return result;
    }
}
