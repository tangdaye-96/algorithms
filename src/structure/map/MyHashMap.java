package structure.map;

import structure.list.MyLinkedList;
import structure.list.MySortLinkedList;

/**
 * Time       : 2020/1/8 21:39
 * Author     : tangdaye
 * Description: 简单哈希映射，不会自增长
 */
public class MyHashMap<K extends Comparable<K>, V> implements MyMap<K, V> {
    class MapEntry<K extends Comparable<K>, V> implements Comparable<MapEntry<K, V>> {
        private K key;
        private V value;

        MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        K getKey() {
            return key;
        }

        V getValue() {
            return value;
        }

        V setValue(V v) {
            V result = value;
            value = v;
            return result; // 返回的是以前的结果
        }

        @Override
        public int hashCode() {
            return key == null ? 0 : key.hashCode() ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof MapEntry)) return false;
            @SuppressWarnings("unchecked")
            MapEntry me = (MapEntry) obj;
            return (key == null ? me.getKey() == null : key.equals(me.getKey())) &&
                    (value == null ? me.getValue() == null : value.equals(me.getValue()));
        }

        @Override
        public String toString() {
            return String.format("%s->%s", key.toString(), value.toString());
        }

        @Override
        public int compareTo(MapEntry<K, V> o) {
            return key.compareTo(o.key);
        }
    }

    static class IntegerHolder implements Comparable<IntegerHolder> {
        int ele;

        IntegerHolder(int ele) {
            this.ele = ele;
        }

        @Override
        public int hashCode() {
            return ele;
        }

        @Override
        public String toString() {
            return ele + "";
        }

        @Override
        public int compareTo(IntegerHolder o) {
            return Integer.compare(ele, o.ele);
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof IntegerHolder)) return false;
            return ele == ((IntegerHolder) obj).ele;
        }
    }

    private static final int SIZE = 997;
    @SuppressWarnings("unchecked")
    private MySortLinkedList<MapEntry<K, V>>[] buckets = new MySortLinkedList[SIZE];

    @Override
    public V put(K key, V value) {
        V oldValue = null;
        int index = Math.abs(key.hashCode()) % SIZE; // 散列码与size的余数，选取hash函数时，可以从一系列函数族中随机选择一个函数
        if (buckets[index] == null) {
            buckets[index] = new MySortLinkedList<>();// 如果某个bucket上还没有list，新建一个
        }
        // 插入这个list
        MySortLinkedList<MapEntry<K, V>> bucket = buckets[index];
        boolean found = false;
        for (MapEntry<K, V> current : bucket) {
            if (current.getKey().equals(key)) {
                oldValue = current.getValue();
                current.setValue(value);// 如果某个位置的current的key和key完全一致，替换它
                found = true;
                break;
            }
        }
        if (!found) {
            bucket.addWithSort(new MapEntry<>(key, value));
        }
        return oldValue;
    }

    @Override
    public V get(K key) {
        int index = Math.abs(key.hashCode()) % SIZE;
        if (buckets[index] == null) return null;
        for (MapEntry<K, V> pair : buckets[index]) {
            if (pair.getKey().equals(key)) return pair.getValue();
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (MyLinkedList<MapEntry<K, V>> bucket : buckets) {
            if (bucket != null) {
                sb.append(bucket.toString());
                sb.append(",");
            }
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append("}");
        return sb.toString();
    }

    public static void main(String[] args) {
        MyMap<IntegerHolder, String> m = new MyHashMap<>();
        m.put(new IntegerHolder(998), "abcde");
        m.put(new IntegerHolder(1), "abcdef");
        m.put(new IntegerHolder(34), "abcdef");
        System.out.println(m);
    }

}
