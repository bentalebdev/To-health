package dao;

import models.patient;
import dao.connectiondb;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class patientIMP implements Intpatient{

    Connection cnx = connectiondb.getConnection();

    @Override
    public void ajouter(patient p)
    {
        try
        {
            PreparedStatement pst = cnx.prepareStatement("insert into patient () value()");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
