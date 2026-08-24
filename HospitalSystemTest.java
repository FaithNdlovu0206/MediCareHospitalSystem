/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
/**
 *
 * @author User
 */
import com.mycompany.medicarehospitalsystem1.HospitalSystem;
import com.mycompany.medicarehospitalsystem1.Inpatient;
import com.mycompany.medicarehospitalsystem1.Outpatient;
import com.mycompany.medicarehospitalsystem1.Patient;
import com.mycompany.medicarehospitalsystem1.PatientCategory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class HospitalSystemTest {

    public HospitalSystem hospital;
    public Patient inpatient;
    public Patient outpatient;

    @BeforeEach
    void setUp() {
        hospital = new HospitalSystem();
        inpatient = new Inpatient("P001", "Faith", "Ndlovu", 22, "Female", "Flu", PatientCategory.INPATIENT, "Ward A");
        outpatient = new Outpatient("P002", "John", "Doe", 30, "Male", "Headache", PatientCategory.OUTPATIENT);
    }

    @Test
    void testRegisterPatient() {
        assertTrue(hospital.registerPatient(inpatient));
        assertEquals(1, hospital.patients.size());
    }

    @Test
    void testPreventDuplicateID() {
        hospital.registerPatient(inpatient);
        Patient duplicate = new Inpatient("P001", "Jane", "Smith", 25, "Female", "Cold", PatientCategory.INPATIENT, "Ward B");
    }

    @Test
    void testSearchPatientFound() {
        hospital.registerPatient(inpatient);
        Patient found = hospital.searchPatient("P001");
        assertNotNull(found);
    }

    @Test
    void testSearchPatientNotFound() {
        assertNull(hospital.searchPatient("P999"));
    }

    @Test
    void testDeletePatient() {
        hospital.registerPatient(inpatient);
        assertTrue(hospital.deletePatient("P001"));
    }

    @Test
    void testAllocateBedSuccess() {
        hospital.registerPatient(inpatient);
        assertTrue(hospital.allocateBed("P001", "B01"));
    }

    @Test
    void testAllocateBedAlreadyOccupied() {
        hospital.registerPatient(inpatient);
        Patient p2 = new Inpatient("P003", "Bob", "Lee", 40, "Male", "Fever", PatientCategory.INPATIENT, "Ward A");
        hospital.registerPatient(p2);
        hospital.allocateBed("P001", "B01");
        assertFalse(hospital.allocateBed("P003", "B01"));
    }

    @Test
    void testAllocateBedOnlyInpatient() {
        hospital.registerPatient(outpatient);
        assertFalse(hospital.allocateBed("P002", "B02"));
    }
}