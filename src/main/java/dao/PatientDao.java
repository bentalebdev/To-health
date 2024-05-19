package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {
    void Ajouter(Patient patient);
    void delete(int id);
    public Patient getPatientById(int id);

    void update(Patient patient);

    List<Patient> getallPatients();
}
