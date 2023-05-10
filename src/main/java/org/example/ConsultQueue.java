package org.example;

import java.util.Arrays;
import java.util.NoSuchElementException;
//test
public class ConsultQueue {
    private int[] heap;
    private int size;
    private int capacity;

    private static PatientRecord record;

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
        int parent = (size - 1) / 2;
        heapify(heap,size,parent);
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
        heapify(heap,size,0);
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



        int[] tempHeap = Arrays.copyOf(heap, size);
        int[] teemp = heapSort(tempHeap,size);
        System.out.println("------------");
        for(int i=size-1 ;i>=0;i--){
            System.out.print(record.getPatient(teemp[i]).id + " ");
            System.out.print(record.getPatient(teemp[i]).name + " ");
            System.out.print(record.getPatient(teemp[i]).age + " ");
            System.out.println();

        }
        System.out.println("------------");
//
    }


    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
    public int[] heapSort(int[] arr, int size) {


        int n = arr.length;

        // Heap sort
        for (int i = n - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }
     return arr;
    }

    public static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        // Check if left child is smaller than root node
        if (left < n && record.getPatient(arr[left]).age > record.getPatient(arr[largest]).age) {
            largest = left;
        }

        // Check if right child is smaller than root node
        if (right < n && record.getPatient(arr[right]).age > record.getPatient(arr[largest]).age) {
            largest = right;
        }

        // If largest is not root, swap root with largest and recursively heapify the affected subtree
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }
}
