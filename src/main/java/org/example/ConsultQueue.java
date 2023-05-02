package org.example;

import java.util.NoSuchElementException;

public class ConsultQueue {
    private int[] heap;
    private int size;
    private int capacity;

    public ConsultQueue(int capacity) {
        heap = new int[capacity];
        size = 0;
        this.capacity = capacity;
    }

    public  void enqueue(int patientId) {
        if (size == capacity) {
            throw new IllegalStateException("Consult queue is full");
        }
        heap[size] = patientId;
        siftUp(size);
        size++;
    }

    public int dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Consult queue is empty");
        }
        int max = heap[0];
        size--;
        heap[0] = heap[size];
        siftDown(0);
        return max;
    }

    public int size() {
        return size;
    }
    public void display() {
        System.out.print("Consult queue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println();
    }
    private void siftUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && heap[index] > heap[parent]) {
            swap(index, parent);
            siftUp(parent);
        }
    }

    private void siftDown(int index) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < size && heap[left] > heap[max]) {
            max = left;
        }
        if (right < size && heap[right] > heap[max]) {
            max = right;
        }
        if (max != index) {
            swap(index, max);
            siftDown(max);
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
