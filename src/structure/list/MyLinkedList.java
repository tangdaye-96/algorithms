package structure.list;

import java.util.Iterator;

/**
 * Time       : 2020/1/8 21:59
 * Author     : tangdaye
 * Description: 自己实现一个链表
 */
public class MyLinkedList<T> implements MyList<T> {
    MyListNode<T> root;
    private MyListNode<T> last;
    int size;

    public MyLinkedList() {
        root = new MyListNode<>(null);
        last = root;
        size = 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            MyListNode<T> current = root;

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
        MyListNode<T> newLast = new MyListNode<>(value);
        last.next = newLast;
        last = newLast;
        size += 1;
    }

    @Override
    public T[] toArray(T[] array) {
        @SuppressWarnings("unchecked")
        int i = 0;
        for (T ele : this) {
            array[i] = ele;
            i += 1;
        }
        return array;
    }

    @Override
    public T get(int i) {
        if (i < 0) throw new IndexOutOfBoundsException();
        int index = -1;
        MyListNode<T> current = root;
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
}
