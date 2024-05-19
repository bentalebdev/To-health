package dao;

import models.Patient;

import java.util.List;

public interface PatientDao {
    void Ajouter(Patient patient);
    void delete(int id);

    List<Patient> getallPatients();
}
