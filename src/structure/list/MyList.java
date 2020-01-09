package structure.list;

/**
 * Time       : 2020/1/8 22:36
 * Author     : tangdaye
 * Description: 列表接口
 */
public interface MyList<T> extends Iterable<T> {
    T get(int i);

    void add(T value);

    T[] toArray(T[] array);
}
