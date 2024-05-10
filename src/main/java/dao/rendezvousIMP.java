package dao;
import models.rendezvous;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class rendezvousIMP implements IntRendezvous{

Connection cnx = connectiondb.getConnection();
    ResultSet rs;
    @Override
    public void prendre(rendezvous r) {
        try
        {
            PreparedStatement pst = cnx.prepareStatement("INSERT INTO rendezvous(nom , prenom , cin , telephone , jour , date_heure) values(? , ? , ? , ? , ? , ?) ");
            pst.setString(1, r.getNom());
            pst.setString(2, r.getPrenom() );
            pst.setString(3,r.getCin() );
            pst.setInt(4, r.getTelephone() );
            pst.setString(5, r.getDate() );
            pst.setString(6, r.getDate_heure() );
            pst.executeUpdate();
            pst.close();
        }catch (Exception e){System.out.print(e);}


    }

    @Override
    public List<rendezvous> getall()
    {

        List<rendezvous> allrendezvous =new ArrayList<>();
        String strquery = "select * from rendezvous";
        try
        {
            PreparedStatement pst = cnx.prepareStatement(strquery);
            rs = pst.executeQuery(strquery);

            while(rs.next())
            {
                rendezvous rendezvous = new  rendezvous();
                rendezvous.setNom(rs.getString(1));
                rendezvous.setPrenom(rs.getString(2));
                rendezvous.setCin(rs.getString(3));
                rendezvous.setTelephone(rs.getInt(4));
                rendezvous.setDate(rs.getString(5));
                rendezvous.setDate_heure(rs.getString(6));

                allrendezvous.add(rendezvous);
            }


        }catch (Exception e){System.out.print(e);}
        return allrendezvous;
    }

    @Override
    public rendezvous getbydate(String date)
    {

        return null;
    }
    @Override
    public void delete(rendezvous rendezvous)
    {

    }

    @Override
    public void update(rendezvous rendezvous)
    {

    }
}
