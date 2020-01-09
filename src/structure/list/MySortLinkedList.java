package structure.list;

/**
 * Time       : 2020/1/9 21:47
 * Author     : tangdaye
 * Description: 可排序的链表
 */
public class MySortLinkedList<T extends Comparable<T>> extends MyLinkedList<T> {

    public int addWithSort(T value) {
        MyListNode<T> node = new MyListNode<>(value);
        MyListNode<T> pre = root;
        MyListNode<T> current = root.next;
        int index = 0;
        while (current != null) {
            if (current.value.compareTo(value) >= 0) {
                // 就在这塞进去
                pre.next = node;
                node.next = current;
                size += 1;
                return index;
            }
            index += 1;
            pre = pre.next;
            current = current.next;
        }
        add(value);
        return index;
    }

    public static void main(String[] args) {
        MySortLinkedList<Integer> l = new MySortLinkedList<>();
        System.out.println(l.addWithSort(2));
        System.out.println(l.addWithSort(1));
        System.out.println(l.addWithSort(4));
        System.out.println(l.addWithSort(3));
        System.out.println(l);
    }
}
