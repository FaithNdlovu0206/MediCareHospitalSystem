/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.medicarehospitalsystem1;

/**
 *
 * @author User
 */
public class Inpatient extends Patient {
    public String ward;
    public String bedNumber = "Not Allocated";

    public Inpatient(String patientId, String firstName, String lastName, int age, String gender, String medicalCondition, String ward, String not_Allocated) {
        super(patientId, firstName, lastName, age, gender, medicalCondition, category);
        this.ward = ward;
    }

    public String getWard() {
        return ward;
    }

    public String getBedNumber() {
        return bedNumber;
    }

    public void setBedNumber(String bedNumber) {
        this.bedNumber = bedNumber;
    }
}