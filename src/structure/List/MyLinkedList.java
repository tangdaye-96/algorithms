package structure.List;

import java.util.Iterator;

/**
 * Time       : 2020/1/8 21:59
 * Author     : tangdaye
 * Description: 自己实现一个链表
 */
public class MyLinkedList<T extends Comparable<T>> implements MyList<T> {
    class Node<R> {
        Node<R> next;
        R value;

        Node(R value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> root;
    private Node<T> last;

    public MyLinkedList() {
        root = new Node<>(null);
        last = root;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = root;

            @Override
            public boolean hasNext() {
                return current.next != null;
            }

            @Override
            public T next() {
                current = current.next;
                return current.value;
            }
        };
    }

    @Override
    public void add(T value) {
        Node<T> newLast = new Node<>(value);
        last.next = newLast;
        last = newLast;
    }

    @Override
    public int addWithSort(T value) {
        Node<T> node = new Node<>(value);
        Node<T> pre = root;
        Node<T> current = root.next;
        int index = 0;
        while (current != null) {
            if (current.value.compareTo(value) >= 0) {
                // 就在这塞进去
                pre.next = node;
                node.next = current;
                return index;
            }
            index += 1;
            pre = pre.next;
            current = current.next;
        }
        add(value);
        return index;
    }

    @Override
    public T get(int i) {
        if (i < 0) throw new IndexOutOfBoundsException();
        int index = -1;
        Node<T> current = root;
        while (current != null) {
            if (index == i)
                return current.value;
            index += 1;
            current = current.next;
        }
        throw new IndexOutOfBoundsException();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (T value : this) {
            sb.append(value.toString());
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyList<Integer> l = new MyLinkedList<>();
        System.out.println(l.addWithSort(2));
        System.out.println(l.addWithSort(1));
        System.out.println(l.addWithSort(4));
        System.out.println(l.addWithSort(3));
        System.out.println(l);
    }
}
