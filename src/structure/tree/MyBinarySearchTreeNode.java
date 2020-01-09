package structure.tree;


import structure.list.MyLinkedList;

/**
 * Time       : 2020/1/9 22:32
 * Author     : tangdaye
 * Description: 二叉搜索树节点
 */
public class MyBinarySearchTreeNode<T extends Comparable<T>> extends MyBinaryTreeNode<T> {
    public MyBinarySearchTreeNode(T value) {
        super(value);
    }

    public MyBinarySearchTreeNode(T[] values) {
        super(values);
    }

    @Override
    public MyBinaryTreeNode<T> search(T value) {
        if (this.value == null) return null;
        int temp = this.value.compareTo(value);
        if (temp > 0) {
            if (left != null) return left.search(value);
            return null;
        } else if (temp < 0) {
            if (right != null) return right.search(value);
            return null;
        }
        return this;
    }

    @Override
    public boolean insert(T value) {
        if (this.value == null) {
            this.value = value;
            left = null;
            right = null;
            parent = null;
            size = 1;
            return true;
        }
        int temp = this.value.compareTo(value);
        if (temp == 0) return false;
        MyBinarySearchTreeNode<T> node = new MyBinarySearchTreeNode<>(value);
        // 找合适的位置塞进去
        if (temp > 0) {
            if (left != null) {
                if (left.insert(value)) {
                    size++;
                    return true;
                }
                return false;
            } else {
                left = node;
                node.parent = this;
                size++;
                return true;
            }
        } else {
            if (right != null) {
                if (right.insert(value)) {
                    size++;
                    return true;
                }
                return false;
            } else {
                right = node;
                node.parent = this;
                size += 1;
                return true;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] x = {3, 1, 0, 4, 5, -1};
        MyBinarySearchTreeNode<Integer> root = new MyBinarySearchTreeNode<>(x);
        MyLinkedList<Integer> result = new MyLinkedList<>();
        root.midOrder(result);
        System.out.println(result);
    }
}
