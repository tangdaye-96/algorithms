package sort;

import structure.list.MyLinkedList;
import structure.tree.MyBinarySearchTreeNode;
import utils.ArrayTool;

/**
 * Time       : 2020/1/9 23:20
 * Author     : tangdaye
 * Description: 利用二叉搜索树查找,暂时（我目前实现的）只能排序不同的元素，复杂度nlgn
 */
public class BinarySearchTreeSort implements SortStrategy {
    @Override
    public int[] sort(int[] array) {
        MyLinkedList<Integer> result = new MyLinkedList<>();
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<>(ArrayTool.castIntArray(array));
        root.midOrder(result);
        Integer[] nn = result.toArray(new Integer[array.length]);
        return ArrayTool.castIntegerArray(nn);
    }

    @Override
    public String toString() {
        return "二叉搜索树排序";
    }
}
