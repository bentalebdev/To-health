package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {
    void Ajouter(Patient patient);

    Patient getPatientById(int id);

    void DeletePatient(String id);

    List<Patient> getallPatients();
}
