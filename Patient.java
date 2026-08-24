/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitalsystem1;

/**
 *
 * @author User
 */
public class Patient {
    public final String patientId;
    public String firstName;
    public String lastName;
    public int age;
    public final String gender;
    public String medicalCondition;
    public final PatientCategory category;

    public Patient(String patientId, String firstName, String lastName, int age,
                   String gender, String medicalCondition, PatientCategory category) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.medicalCondition = medicalCondition;
        this.category = category;
    }

    // Getters and Setters
    public String getPatientId() { return patientId; }
    public String getLastName() { return lastName; }
    public PatientCategory getCategory() { return category; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public void setAge(int age) { this.age = age; }
    public void setMedicalCondition(String cond) { this.medicalCondition = cond; }

    public void displayDetails() {
        System.out.println("ID: " + patientId + " | Name: " + firstName + " " + lastName +
                           " | Age: " + age + " | Gender: " + gender +
                           " | Condition: " + medicalCondition + " | Category: " + category);
    }
}