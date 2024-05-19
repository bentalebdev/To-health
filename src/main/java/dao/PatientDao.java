package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {
    void Ajouter(Patient patient);


    Patient getPatientById(int id);

    void DeletePatientByCin(String cin);

    List<Patient> getallPatients();
    Patient patientbycin(String cin);
}
