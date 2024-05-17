package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {
    void Ajouter(Patient patient);

    void DeletePatient(String id);

    List<Patient> getallPatients();
}
