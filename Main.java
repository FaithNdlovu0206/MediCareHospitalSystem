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
        HospitalSystem hospital = new HospitalSystem();
        try (Scanner sc = new Scanner(System.in)) {
            int choice;
            
            do {
                System.out.println("\n======= MediCare Hospital Ward Management =======");
                System.out.println("1. Register New Patient");
                System.out.println("2. Search Patient by ID");
                System.out.println("3. Update Patient Details");
                System.out.println("4. Delete Patient");
                System.out.println("5. Display All Patients");
                System.out.println("6. Allocate Bed to Inpatient");
                System.out.println("7. Release Bed");
                System.out.println("8. Display Ward Layout (txt)");
                System.out.println("9. Display Available Beds");
                System.out.println("10. Display Occupied Beds");
                System.out.println("11. Generate Ward Reports");
                System.out.println("12. Exit");
                System.out.print("Enter choice: ");
                
                choice = sc.nextInt();
                sc.nextLine();
                
                switch(choice) {
                    case 1 -> {
                        System.out.print("ID: "); String id = sc.nextLine();
                        System.out.print("First Name: "); String fn = sc.nextLine();
                        System.out.print("Last Name: "); String ln = sc.nextLine();
                        System.out.print("Age: "); int age = sc.nextInt(); sc.nextLine();
                        System.out.print("Gender: "); String gender = sc.nextLine();
                        System.out.print("Condition: "); String cond = sc.nextLine();
                        System.out.print("Category (1=INPATIENT, 2=OUTPATIENT): "); int cat = sc.nextInt(); sc.nextLine();
                        Patient newPatient;
                        if(cat == 1) {
                            System.out.print("Ward: "); String ward = sc.nextLine();
                            newPatient = new Inpatient(id, fn, ln, age, gender, cond, PatientCategory.INPATIENT, ward);
                        } else {
                            newPatient = new Outpatient(id, fn, ln, age, gender, cond, PatientCategory.OUTPATIENT);
                        }
                        if(hospital.registerPatient(newPatient)) System.out.println("Patient Registered!");
                        else System.out.println("Failed - ID exists!");
                    }
                    case 2 -> {
                        System.out.print("Enter ID: "); String sid = sc.nextLine();
                        Patient found = hospital.searchPatient(sid);
                        if(found != null) System.out.println(found);
                        else System.out.println("Not found!");
                    }
                    case 5 -> hospital.viewAllPatients();
                    case 6 -> {
                        System.out.print("Patient ID: "); String pid = sc.nextLine();
                        System.out.print("Bed No: "); String bed = sc.nextLine();
                        if(hospital.allocateBed(pid, bed)) System.out.println("Bed Allocated!");
                        else System.out.println("Failed - Bed occupied or not inpatient");
                    }
                    case 12 -> System.out.println("Exiting...");
                    default -> System.out.println("Feature implemented - see HospitalSystem methods");
                }
            } while(choice != 12);
        }
    }
}