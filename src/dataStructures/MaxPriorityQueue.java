package dataStructures;

import java.util.ArrayList;

public class MaxPriorityQueue<K extends Comparable<K>, V> {
    private HeapNode<K, V>[] heap;
    private int size;

    public MaxPriorityQueue(int capacity) {
        heap = new HeapNode[capacity];
        size = 0;
    }

    public V getMax() {
        return heap[0].getValue();
    }

    public V extractMax() {
        if (heap.length < 1) {
            throw new RuntimeException("Heap underflow");
        }
        V max = heap[0].getValue();
        heap[0] = heap[size - 1];
        size--;
        maxHeapify(0);
        return max;
    }

/*    private void increaseKey(int i, K key, V value) {
        if (key.compareTo(heap[i].getKey()) < 0) {
            throw new RuntimeException("New key is smaller than current key");
        }
        heap[i].setKey(key);
        heap[i].setValue(value);
        while (i > 0 && heap[parent(i)].getKey().compareTo(heap[i].getKey()) < 0) {
            swap(i, parent(i));
            i = parent(i);
        }
    }*/

    public void maxInsert(K key, V value) {
        if (size == heap.length) {
            throw new RuntimeException("Heap overflow");
        }
        size++;
        heap[size - 1] = new HeapNode<>(key, value);
        int i = size - 1;
        while (i > 0 && heap[parent(i)].getKey().compareTo(heap[i].getKey()) < 0) {
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

    private void maxHeapify(int i) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;
        if (left < size && heap[left].getKey().compareTo(heap[i].getKey()) > 0) {
            largest = left;
        }
        if (right < size && heap[right].getKey().compareTo(heap[largest].getKey()) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            maxHeapify(largest);
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