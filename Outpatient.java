/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitalsystem1;

/**
 *
 * @author User
 */


public class Outpatient extends Patient {
    public Outpatient(String patientId, String firstName, String lastName, int age, String gender, String medicalCondition, PatientCategory category) {
        super(patientId, firstName, lastName, age, gender, medicalCondition, category);
    }
}
