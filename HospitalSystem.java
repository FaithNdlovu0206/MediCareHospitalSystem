/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitalsystem1;

/**
 *
 * @author User
 */
import java.util.*;

public class HospitalSystem {
    public List<Patient> patients = new ArrayList<>();
    public String[][] wardBeds = new String[4][5]; // 4x5 layout
    public Map<String, String> bedToPatientMap = new HashMap<>(); // BedID -> PatientID

    public HospitalSystem() {
        int count = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                wardBeds[i][j] = "B" + String.format("%02d", count++);
            }
        }
    }

    // Prevent duplicate ID
    public boolean registerPatient(Patient p) {
        if (searchPatient(p.getPatientId())!= null) return false;
        patients.add(p);
        return true;
    }

    public Patient searchPatient(String id) {
        for (Patient p : patients) if (p.getPatientId().equalsIgnoreCase(id)) return p;
        return null;
    }

    public boolean deletePatient(String id) {
        Patient p = searchPatient(id);
        if (p!= null) {
            if (p instanceof Inpatient) releaseBed(((Inpatient) p).getBedNumber());
            patients.remove(p);
            return true;
        }
        return false;
    }

    // Feature 2: Bed Management
    public boolean allocateBed(String patientId, String bedId) {
        Patient p = searchPatient(patientId);
        if (p == null || p.getCategory()!= PatientCategory.INPATIENT) return false;
        if (bedToPatientMap.containsKey(bedId)) return false;
        if (bedToPatientMap.size() >= 20) return false;

        bedToPatientMap.put(bedId, patientId);
        if (p instanceof Inpatient) ((Inpatient) p).setBedNumber(bedId);
        return true;
    }

    public void releaseBed(String bedId) {
        bedToPatientMap.remove(bedId);
    }

    public void displayWardLayout() {
        System.out.println("\n--- WARD LAYOUT (X = Occupied) ---");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 5; j++) {
                String bed = wardBeds[i][j];
                String status = bedToPatientMap.containsKey(bed)? "[X]" : "[ ]";
                System.out.print(bed + status + " ");
            }
            System.out.println();
        }
    }

    public void displayAvailableBeds() {
        System.out.println("Available Beds:");
        for (String[] row : wardBeds) {
            for (String bed : row) {
                if (!bedToPatientMap.containsKey(bed)) System.out.print(bed + " ");
            }
        }
        System.out.println();
    }

    public void displayOccupiedBeds() {
        System.out.println("Occupied Beds: " + bedToPatientMap.keySet());
    }

    public void generateReports() {
        System.out.println("\n--- WARD REPORT ---");
        System.out.println("Total Patients: " + patients.size());
        System.out.println("Occupied Beds: " + bedToPatientMap.size());
        double occupancy = (bedToPatientMap.size() / 20.0) * 100;
        System.out.printf("Occupancy: %.2f%%\n", occupancy);
    }

    public void displayAllPatients() {
        if (patients.isEmpty()) System.out.println("No patients registered.");
        else {
            patients.sort(Comparator.comparing(Patient::getLastName));
            for (Patient p : patients) p.displayDetails();
        }
    }
}