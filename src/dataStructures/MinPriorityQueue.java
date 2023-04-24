package dataStructures;

public class MinPriorityQueue<K extends Comparable<K>, V> {
    private HeapNode<K, V>[] heap;
    private int size;

    public MinPriorityQueue(int capacity) {
        heap = new HeapNode[capacity];
        size = 0;
    }

    public V getMin() {
        return heap[0].getValue();
    }

    public V extractMin() {
        if (heap.length < 1) {
            throw new RuntimeException("Heap underflow");
        }
        V min = heap[0].getValue();
        heap[0] = heap[size - 1];
        size--;
        minHeapify(0);
        return min;
    }

    public void minInsert(K key, V value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap overflow");
        }
        size++;
        heap[size - 1] = new HeapNode<>(key, value);
        int i = size - 1;
        while (i > 0 && heap[parent(i)].getKey().compareTo(heap[i].getKey()) > 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private void swap(int i, int j) {
        HeapNode<K, V> temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void minHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int smallest = i;
        if (left < size && heap[left].getKey().compareTo(heap[i].getKey()) < 0) {
            smallest = left;
        }
        if (right < size && heap[right].getKey().compareTo(heap[smallest].getKey()) < 0) {
            smallest = right;
        }
        if (smallest != i) {
            swap(i, smallest);
            minHeapify(smallest);
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public String toString() {
        String s = "";
        for (int i = 0; i < size; i++) {
            s += heap[i].toString() + "\n";
        }
        return s;
    }
}
