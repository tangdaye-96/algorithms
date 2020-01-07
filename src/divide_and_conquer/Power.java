package divide_and_conquer;

import static utils.MatrixTool.*;

/**
 * Time       : 2020/1/5 21:28
 * Author     : tangdaye
 * Description: 乘方问题及其衍生问题
 */
public class Power {
    private static int power(int base, int exp) {
        if (exp == 1) return base;
        int t = power(base, exp / 2);
        if (exp % 2 == 0) {
            return t * t;
        }
        return t * t * base;
    }


    /**
     * Description: a*b，其中a和b是n*n的。
     * 这里没有处理n是奇数的情形（1处理了），所以n限定为2的幂次
     */
    private static int[][] matrixMul(int[][] source1, int[][] source2) {
        int n = source1.length;
        int[][] result = new int[n][n];
        if (n == 1) {
            result[0][0] = source1[0][0] * source2[0][0];
            return result;
        }
        /*
         * r s    a b   e f
         * t u    c d   g h
         * 朴素算法：T(n) = 8T(n/2)+O(n^2) => T(n) = O(n^3) (主定理情况1)
         * r = ae+bg
         * s = af+bh
         * t = ce+dg
         * u = cf+dh
         * 斯特拉森算法：T(n) = 7T(n/2)+O(n^2) => T(n) = O(n^(log_2^7)) (主定理情况1)
         * p1=a(f-h) p2=(a+b)h p3=(c+d)e p4=d(g-e)
         * p5=(a+d)(e+h) p6=(b-d)(g+h) p7=(a-c)(e+f)
         * r=p5+p4-p2+p6 (r=ae+ah+de+dh+dg-de-ah-bh+bd+bh-dg-dh=ae+bd)
         * s=p1+p2 (s=af-ah+ah+bh=af+bh)
         * t=p3+p4 (t=ce+de+dg-de=ce+dg)
         * u=p5+p1-p3-p7 (u=ae+ah+de+dh+af-ah-ce-de-ae-af+ce+cf=cf+dh)
         */
        int[][] a = subMatrix(source1, 0, 0, n / 2, n / 2),
                b = subMatrix(source1, 0, n / 2, n / 2, n),
                c = subMatrix(source1, n / 2, 0, n, n / 2),
                d = subMatrix(source1, n / 2, n / 2, n, n);
        int[][] e = subMatrix(source2, 0, 0, n / 2, n / 2),
                f = subMatrix(source2, 0, n / 2, n / 2, n),
                g = subMatrix(source2, n / 2, 0, n, n / 2),
                h = subMatrix(source2, n / 2, n / 2, n, n);
        int[][] p1 = matrixMul(a, matrixMinus(f, h)),
                p2 = matrixMul(matrixAdd(a, b), h),
                p3 = matrixMul(matrixAdd(c, d), e),
                p4 = matrixMul(d, matrixMinus(g, e)),
                p5 = matrixMul(matrixAdd(a, d), matrixAdd(e, h)),
                p6 = matrixMul(matrixMinus(b, d), matrixAdd(g, h)),
                p7 = matrixMul(matrixMinus(a, c), matrixAdd(e, f));
        int[][] r = matrixAdd(matrixMinus(matrixAdd(p5, p4), p2), p6),
                s = matrixAdd(p1, p2),
                t = matrixAdd(p3, p4),
                u = matrixMinus(matrixMinus(matrixAdd(p1, p5), p3), p7);
        mergeMatrix(result, r, 0, 0);
        mergeMatrix(result, s, 0, n / 2);
        mergeMatrix(result, t, n / 2, 0);
        mergeMatrix(result, u, n / 2, n / 2);
        return result;
    }

    /**
     * Description: 返回二阶矩阵base的exp次方
     */
    private static int[][] power(int[][] base, int exp) {
        if (exp == 1) {
            return base;
        }
        int[][] temp = power(base, exp / 2);
        if (exp % 2 == 0) {
            return matrixMul(temp, temp);
        }
        return matrixMul(matrixMul(temp, temp), base);

    }

    // 返回数列0，1，1，2的第n项（0是第0项）
    private static int fib(int n) {
        int[][] x = {{1, 1}, {1, 0}};
        return power(x, n)[0][1];
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
