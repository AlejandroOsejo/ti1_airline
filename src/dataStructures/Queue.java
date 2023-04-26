package dataStructures;

public class Queue<T> {
    private T[] queue;
    private int size;

    public Queue(int length) {
        this.size = 0;
        queue = (T[]) new Object[length];
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

    public T[] getQueue() {
        return queue;
    }

    public void setQueue(T[] queue, int size) {
        this.size = size;
        this.queue = queue;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < size; i++) {
            result += queue[i] + " ";
        }
        return result.trim();
    }
}