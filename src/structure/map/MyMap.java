package structure.map;

/**
 * Time       : 2020/1/8 21:36
 * Author     : tangdaye
 * Description: 映射接口
 */
public interface MyMap<K extends Comparable<K>, V> {
    V put(K key, V value);

    V get(K key);
}
