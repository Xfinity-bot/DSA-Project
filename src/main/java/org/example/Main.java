package org.example;

public class Main {

    public static void main(String[] args){
        PatientRecord patientRecord = new PatientRecord();

        // Add some patient records
        int id1 = patientRecord.addPatient("Alice", 70);
        int id2 = patientRecord.addPatient("Bob", 80);
        int id3 = patientRecord.addPatient("Charlie", 75);

        // Display all patient records
        patientRecord.displayPatients();

        // Delete a patient record
        patientRecord.deletePatient(id2);

        // Display all patient records again
        patientRecord.displayPatients();
    }

}