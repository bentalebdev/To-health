package dao;

import models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PatientImp implements PatientDao {
    Connection cnx = connectiondb.getConnection();
    ResultSet rs;

    @Override
    public void Ajouter(Patient patient) {
        PreparedStatement pst = null;
        try {
            String sql = "INSERT INTO patient(nom, prenom, cin, telephone, date_naissance,daterendezvous ,genre, derniere_visite, acte_medicale,etat) VALUES (?,?,?, ?, ?, ?, ?, ?, ?, ?)";
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patient.getNom());
            pst.setString(2, patient.getPrenom());
            pst.setString(3, patient.getCin());
            pst.setInt(4, patient.getTelephone());
            pst.setString(5, patient.getDate_naissance());
            pst.setString(6,patient.getDaterendezvous());
            pst.setString(7, patient.getGenre());
            pst.setString(8, patient.getDerniere_visite());
            pst.setString(9, patient.getActe_medicale());
            pst.setString(10,patient.getEtat());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement pst = null;
        try {
            String sql = "DELETE FROM `patient` WHERE id=?";
            pst = cnx.prepareStatement(sql);
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Patient getPatientById(int id) {
        Patient patient = null;
        try (PreparedStatement pst = cnx.prepareStatement("SELECT * FROM patient WHERE id = ?")) {
            pst.setInt(1, id);
            try (ResultSet rs = pst.executeQuery()) {
                if (rs.next()) {
                    patient = new Patient();
                    patient.setId(rs.getInt("id"));
                    patient.setNom(rs.getString("nom"));
                    patient.setPrenom(rs.getString("prenom"));
                    patient.setCin(rs.getString("cin"));
                    patient.setGenre(rs.getString("genre"));
                    patient.setTelephone(rs.getInt("telephone"));
                    patient.setDate_naissance(rs.getString("date_naissance"));
                    patient.setDerniere_visite(rs.getString("derniere_visite"));
                    patient.setActe_medicale(rs.getString("acte_medicale"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return patient;
    }
    @Override
    public void update(Patient patient) {
        PreparedStatement pst = null;
        try {
            String sql = "UPDATE patient SET nom=?, prenom=?, cin=?, telephone=?, date_naissance=?, daterendezvous=?, genre=?, derniere_visite=?, acte_medicale=?, etat=? WHERE id=?";
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patient.getNom());
            pst.setString(2, patient.getPrenom());
            pst.setString(3, patient.getCin());
            pst.setInt(4, patient.getTelephone());
            pst.setString(5, patient.getDate_naissance());
            pst.setString(6, patient.getDaterendezvous()); // Ensure daterendezvous is set here
            pst.setString(7, patient.getGenre());
            pst.setString(8, patient.getDerniere_visite());
            pst.setString(9, patient.getActe_medicale());
            pst.setString(10, patient.getEtat());
            pst.setInt(11, patient.getId());
            pst.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (pst != null) {
                    pst.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public List<Patient> getallPatients() {
        List<Patient> allPatients = new ArrayList<>();
        String query = "SELECT * FROM patient";
        try (PreparedStatement pst = cnx.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setId(rs.getInt("id"));
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setCin(rs.getString("cin"));
                patient.setGenre(rs.getString("genre"));
                patient.setDate_naissance(rs.getString("date_naissance"));
                patient.setDaterendezvous(rs.getString("daterendezvous"));
                patient.setDerniere_visite(rs.getString("derniere_visite"));
                patient.setTelephone(rs.getInt("telephone"));
                patient.setActe_medicale(rs.getString("acte_medicale"));
                patient.setEtat(rs.getString("etat"));

                allPatients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPatients;
    }
}