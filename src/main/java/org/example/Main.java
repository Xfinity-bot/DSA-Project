package org.example;

public class Main {

    public void driver(){

    }

    public static void main(String[] args){
        PatientRecord patientRecord = new PatientRecord();
        ConsultQueue queue = new ConsultQueue(100);

        // Add some patient records
        int id1 = patientRecord.addPatient("Alice", 70);
       queue.enqueue(70);
        int id2 = patientRecord.addPatient("Bob", 80);
        queue.enqueue(80);
        int id3 = patientRecord.addPatient("Charlie", 75);
        queue.enqueue(75);

        // Display all patient records
        patientRecord.displayPatients();
System.out.println("-----------------");
queue.display();
        System.out.println("-----------------");
        // Delete a patient record

        queue.dequeue();

        // Display all patient records again
        patientRecord.displayPatients();
        System.out.println("-----------------");
        queue.display();
        System.out.println("-----------------");
        queue.dequeue();
        System.out.println("-----------------");
        queue.display();
        System.out.println("-----------------");
    }

}