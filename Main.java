/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.medicarehospitalsystem1;

/**
 *
 * @author User
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HospitalSystem hospital = new HospitalSystem();

        while (true) {
            System.out.println("\n=== MediCare Hospital System ===");
            System.out.println("1. Register Patient");
            System.out.println("2. Search Patient");
            System.out.println("3. Delete Patient");
            System.out.println("4. Allocate Bed");
            System.out.println("5. View All Patients");
            System.out.println("6. Exit");
            System.out.print("Choice: ");
            String choice = sc.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.print("ID (e.g. P001): ");
                    String id = sc.nextLine();
                    System.out.print("First Name: ");
                    String fName = sc.nextLine();
                    System.out.print("Last Name: ");
                    String lName = sc.nextLine();
                    System.out.print("Age: ");
                    int age = Integer.parseInt(sc.nextLine());
                    System.out.print("Gender: ");
                    String gender = sc.nextLine();
                    System.out.print("Medical Condition: ");
                    String condition = sc.nextLine();
                    System.out.print("Category (1=Inpatient, 2=Outpatient): ");
                    String catChoice = sc.nextLine();

                    Patient newPatient = null;
                    if (catChoice.equals("1")) {
                        PatientCategory category = PatientCategory.INPATIENT;
                        System.out.print("Ward Number (e.g. Ward A): ");
                        String ward = sc.nextLine();
                        newPatient = new Inpatient(id, fName, lName, age, gender, condition, ward, "Not Allocated");
                    } else {
                        PatientCategory category = PatientCategory.OUTPATIENT;
                        newPatient = new Outpatient(id, fName, lName, age, gender, condition, category);
                    }

                    if (hospital.registerPatient(newPatient)) {
                        System.out.println("Patient Registered Successfully!");
                    } else {
                        System.out.println("ERROR: Patient ID already exists!");
                    }
                }

                case "2" -> {
                    System.out.print("Enter ID to search: ");
                    String searchId = sc.nextLine();
                    Patient found = hospital.searchPatient(searchId);
                    if (found != null) {
                        System.out.println("Found: " + found.firstName + " " + found.lastName + " - " + found.category);
                    } else {
                        System.out.println("Patient not found!");
                    }
                }

                case "3" -> {
                    System.out.print("Enter ID to delete: ");
                    String delId = sc.nextLine();
                    if (hospital.deletePatient(delId)) {
                        System.out.println("Deleted!");
                    } else {
                        System.out.println("Not found!");
                    }
                }

                case "4" -> {
                    System.out.print("Enter Patient ID: ");
                    String pId = sc.nextLine();
                    System.out.print("Enter Bed Number (e.g. B01): ");
                    String bed = sc.nextLine();
                    if (hospital.allocateBed(pId, bed)) {
                        System.out.println("Bed Allocated!");
                    } else {
                        System.out.println("Failed! Bed occupied or patient is outpatient or not found.");
                    }
                }

                case "5" -> {
                    for (Patient p : hospital.patients) {
                        System.out.println(p.patientId + " - " + p.firstName + " " + p.lastName);
                    }
                }

                case "6" -> {
                    System.out.println("Bye!");
                    System.exit(0);
                }

                default -> System.out.println("Invalid choice!");
            }
        }
    }
}