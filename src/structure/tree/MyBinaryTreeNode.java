package structure.tree;

import structure.list.MyLinkedList;

/**
 * Time       : 2020/1/9 21:54
 * Author     : tangdaye
 * Description: 二叉树的节点
 */
public abstract class MyBinaryTreeNode<R> {
    R value;
    MyBinaryTreeNode<R> left;
    MyBinaryTreeNode<R> right;
    MyBinaryTreeNode<R> parent;
    int size;

    MyBinaryTreeNode(R[] values) {
        for (R value : values) {
            insert(value);
        }
    }

    MyBinaryTreeNode(R value) {
        this.value = value;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.size = 1;
    }

    public MyBinaryTreeNode<R> search(R value) {
        if (this.value.equals(value)) return this;
        if (left != null) return left.search(value);
        if (right != null) return right.search(value);
        return null;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    public void midOrder(MyLinkedList<R> result) {
        if (left != null) left.midOrder(result);
        result.add(this.value);
        if (right != null) right.midOrder(result);
    }

    public abstract boolean insert(R value);

}
