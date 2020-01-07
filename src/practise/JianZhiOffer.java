package practise;

/**
 * Time       : 2020/1/4 23:21
 * Author     : tangdaye
 * Description: 剑指Offer
 */
public class JianZhiOffer {

    /**
     * Description: 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     * Input:       目标整数target，二维数组array
     * Output:      目标整数是否在二维数组中
     */
    private static boolean find(int target, int[][] array) {
        // 切成四块？可以用MatrixTool中的方法

        return false;
    }


    public static void main(String[] args) {
        int[][] array = {
                {1, 2, 3, 4, 5},
                {2, 3, 4, 5, 6},
                {3, 4, 5, 6, 7},
                {4, 5, 6, 7, 8},
                {5, 6, 7, 8, 9},
        };
        System.out.println(find(8, array));
    }
}
