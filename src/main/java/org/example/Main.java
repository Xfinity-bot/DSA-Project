package org.example;

import java.util.Scanner;

public class Main {

    public void driver(){

    }

    public static void main(String[] args){
        PatientRecord patientRecord = new PatientRecord();
        ConsultQueue queue = new ConsultQueue(100,patientRecord);
        Scanner sc=new Scanner(System.in);
        int x ;


        // Add some patient records
        int id1 = patientRecord.addPatient("Alice", 90);
       queue.enqueue(id1);
        int id2 = patientRecord.addPatient("Bob", 90);
        queue.enqueue(id2);
        int id3 = patientRecord.addPatient("Charlie", 75);
        queue.enqueue(id3);

    while(true){
        System.out.println("1.Display");
        System.out.println("2.Insert Patient Data");
        System.out.println("3.Display Next Patient");
        System.out.println("4.Delete Patient");
        System.out.println("5.Exit");
        x= sc.nextInt();
        System.out.println(x);
        switch(x){
            case 1 : queue.display();
            break;
            case 2 : System.out.println("Enter Patient Name");
               String name = sc.next();
                        System.out.println("Enter Patient Age");
                        int age = sc.nextInt();
                System.out.println(name) ;  break;
            case 3 : break;
            case 4 : queue.dequeue();
            System.out.println("deleted");
            break;
            case 5 : System.exit(0);
            default:System.out.println("Invalid Entry");

        }
    }
    }

}