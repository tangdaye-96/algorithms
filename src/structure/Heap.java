package structure;

import utils.ArrayTool;

/**
 * Time       : 2020/1/7 01:18
 * Author     : tangdaye
 * Description: 最大堆数据结构
 */
public class Heap {
    private int size;
    private int length;
    private int[] data;

    public Heap(int[] data) {
        this.data = data;
        this.size = data.length;
        this.length = data.length;
        for (int i = length / 2; i >= 0; i--)
            heapify(i);
    }

    // 使得下标为index的元素为根元素的子树变成最大堆,这里必须假定left和right已经是最大堆（叶节点视为最大堆）
    private void heapify(int index) {
        int maxIndex = index;
        int left = 2 * index;
        int right = 2 * index + 1;
        if (left < length && data[left] > data[maxIndex]) {
            maxIndex = left;
        }
        if (right < length && data[right] > data[maxIndex]) {
            maxIndex = right;
        }
        if (maxIndex != index) {
            int temp = data[index];
            data[index] = data[maxIndex];
            data[maxIndex] = temp;
            heapify(maxIndex);
        }
    }

    public void sort() {
        while (length > 1) {
            int temp = data[0];
            data[0] = data[length-1];
            data[length-1] = temp;
            length--;
            heapify(0);
        }
    }

    @Override
    public String toString() {
        return ArrayTool.arrayToString(data, length);
    }

    public static void main(String[] args) {
        int[] x = {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
        Heap heap = new Heap(x);
        System.out.println(heap);
    }
}
