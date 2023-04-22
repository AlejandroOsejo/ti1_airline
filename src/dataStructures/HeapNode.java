package dataStructures;

public class HeapNode<K extends Comparable<K>, V> implements Comparable<HeapNode<K, V>> {
    private K key;
    private V value;

    public HeapNode(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    @Override
    public int compareTo(HeapNode<K, V> o) {
        return this.key.compareTo(o.getKey());
    }

    public String toString() {
        return key + " " + value;
    }
}
