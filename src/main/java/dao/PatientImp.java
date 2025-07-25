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
            String sql = "INSERT INTO patient(nom, prenom, cin, telephone, date_naissance, genre, derniere_visite, acte_medicale) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pst = cnx.prepareStatement(sql);
            pst.setString(1, patient.getNom());
            pst.setString(2, patient.getPrenom());
            pst.setString(3, patient.getCin());
            pst.setInt(4, patient.getTelephone());
            pst.setString(5, patient.getDate_naissance());
            pst.setString(6, patient.getGenre());
            pst.setString(7, patient.getDerniere_visite());
            pst.setString(8, patient.getActe_medicale());
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
        String query = "SELECT nom, prenom, cin, genre, date_naissance, derniere_visite, telephone, acte_medicale FROM patient";
        try (PreparedStatement pst = cnx.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                Patient patient = new Patient();
                patient.setNom(rs.getString("nom"));
                patient.setPrenom(rs.getString("prenom"));
                patient.setCin(rs.getString("cin"));
                patient.setGenre(rs.getString("genre"));
                patient.setDate_naissance(rs.getString("date_naissance"));
                patient.setDerniere_visite(rs.getString("derniere_visite"));
                patient.setTelephone(rs.getInt("telephone"));
                patient.setActe_medicale(rs.getString("acte_medicale"));

                allPatients.add(patient);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allPatients;
    }
}




