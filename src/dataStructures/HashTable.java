package dataStructures;

import java.util.ArrayList;

public class HashTable<K, V> {
    private int size;
    private ArrayList<HashNode<K, V>> table;

    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(null);
        }
    }

    private int hash(K key) {
        int hash = key.hashCode() % size;
        if (hash < 0) {
            hash += size;
        }
        return hash;
    }

    public void put(K key, V value) {
        int hash = hash(key);
        while (table.get(hash) != null && !table.get(hash).getKey().equals(key)) {
            hash = (hash + 1) % size;
        }
        table.set(hash, new HashNode<K, V>(key, value));
    }

    public V get(K key) {
        int hash = hash(key);
        while (table.get(hash) != null && !table.get(hash).getKey().equals(key)) {
            hash = (hash + 1) % size;

            if (hash == hash(key)) {
                return null;
            }
        }
        if (table.get(hash) == null) {
            return null;
        } else {
            return table.get(hash).getValue();
        }
    }

    public V remove(K key) {
        int hash = hash(key);
        while (table.get(hash) != null && !table.get(hash).getKey().equals(key)) {
            hash = (hash + 1) % size;
        }
        if (table.get(hash) == null) {
            return null;
        } else {
            V value = table.get(hash).getValue();
            table.set(hash, null);
            return value;
        }
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            if (table.get(i) != null) {
                result += table.get(i).toString() + "\n";
            }
        }
        return result;
    }
}
