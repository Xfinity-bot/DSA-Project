package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;
//test
public class ConsultQueue {
    private int[] heap;
    private int size;
    private int capacity;

    private PatientRecord record;

    public ConsultQueue(int capacity, PatientRecord record) {
        heap = new int[capacity];
        size = 0;
        this.capacity = capacity;
        this.record = record;
           }

    public  void enqueue(int patientId) {
        if (size == capacity) {
            throw new IllegalStateException("Consult queue is full");
        }
        heap[size] = patientId;
        shiftUp(size);
        size++;
    }
    public String next(){
        if(size==0){
            throw new NoSuchElementException("Consult queue is empty");
        }
        return record.getPatient(heap[0]).name;
    }
    public int dequeue() {
        if (size == 0) {
            throw new NoSuchElementException("Consult queue is empty");
        }
        int max = heap[0];
        size--;
        heap[0] = heap[size];
        shiftDown(0,heap);
        return max;
    }

    public int size() {
        return size;
    }
    public void display( int size) {
        int tmpSize=size;
        if (tmpSize == 0) {
            throw new NoSuchElementException("Consult queue is empty");
        }
        int[] tempHeap = Arrays.copyOf(heap, tmpSize);

        System.out.println("------------");
        while (tmpSize>0) {

            int tmpMax = tempHeap[0];

            System.out.print(record.getPatient(tmpMax).id+ "    ");
            System.out.print(record.getPatient(tmpMax).name+ "    ");
            System.out.println(record.getPatient(tmpMax).age+ "    ");

            tmpSize--;

            tempHeap[0] = tempHeap[tmpSize];

           // System.out.print(record.getPatient(heap[tmpMax]).name);


        }
        System.out.println("------------");
//
    }
    private void shiftUp(int index) {
        int parent = (index - 1) / 2;
        if (index > 0 && record.getPatient(heap[index]).age > record.getPatient(heap[parent]).age) {
            swap(index, parent);
            shiftUp(parent);
        }
    }

    private int[] shiftDown(int index, int[] heap) {
        int left = 2 * index + 1;
        int right = 2 * index + 2;
        int max = index;
        if (left < size && record.getPatient(heap[left]).age > record.getPatient(heap[max]).age) {
            max = left;
        }
        if (right < size && record.getPatient(heap[right]).age > record.getPatient(heap[max]).age) {
            max = right;
        }
        if (max != index) {
            swap(index, max);
            shiftDown(max,heap);
        }
        return heap;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
