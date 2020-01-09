package structure.list;

/**
 * Time       : 2020/1/9 21:49
 * Author     : tangdaye
 * Description: 链表中的节点
 */
class MyListNode<R> {
    MyListNode<R> next;
    R value;

    MyListNode(R value) {
        this.value = value;
        this.next = null;
    }
}
