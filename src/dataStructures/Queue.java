package dataStructures;

public class Queue<T> {
    private final T[] queue;
    private int size;

    public Queue(int size) {
        this.size = 0;
        queue = (T[]) new Object[size];
    }

    public void enqueue(T data) {
        if (size == queue.length) {
            throw new IndexOutOfBoundsException("Queue is full");
        }
        queue[size] = data;
        size++;
    }

    public T dequeue() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        T data = queue[0];
        for (int i = 0; i < size - 1; i++) {
            queue[i] = queue[i + 1];
        }
        size--;
        return data;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Queue is empty");
        }
        return queue[0];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += queue[i] + " ";
        }
        return result.trim();
    }
}