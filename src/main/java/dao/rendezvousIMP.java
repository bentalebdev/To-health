package dao;
import models.rendezvous;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
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
    public List<rendezvous> getall(String jour)
    {

        List<rendezvous> allrendezvous =new ArrayList<>();
        String strquery = "select nom , prenom , cin , telephone , jour , date_heure from rendezvous where jour =? ";
        try
        {
            PreparedStatement pst = cnx.prepareStatement(strquery);
            java.sql.Date jourDate = java.sql.Date.valueOf(jour);
            pst.setDate(1, jourDate);
            rs = pst.executeQuery();

            while(rs.next())
            {
                rendezvous r = new rendezvous();
                r.setNom(rs.getString(1));
                r.setPrenom(rs.getString(2));
                r.setCin(rs.getString(3));
                r.setTelephone(rs.getInt(4));
                r.setDate(String.valueOf(rs.getDate(5)));
                r.setDate_heure(rs.getString(6));

                allrendezvous.add(r);

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
    public void delete(String cin)
    {
        String strquery = "delete FROM rendezvous where cin = ?";
        try
        {
            PreparedStatement pst = cnx.prepareStatement(strquery);
            pst.setString(1,cin);
            pst.executeUpdate();
        }
        catch (Exception e){System.out.print(e);}
    }

    @Override
    public void update(rendezvous rendezvous)
    {

    }

    @Override
    public List<String> getheurreserve(String jour) {
        List<String> heurs = new ArrayList<>();
        try {
            PreparedStatement pst = cnx.prepareStatement("select date_heure from rendezvous where jour = ? ");
            pst.setString(1,jour);
            rs = pst.executeQuery();
            while (rs.next())
            {
                heurs.add(rs.getString("date_heure"));
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return heurs;
    }

    public int getrdntoday()
    {
        int count = 0 ;
        try
        {
            PreparedStatement pst = cnx.prepareStatement("select count(*) as count from rendezvous where jour = CURRENT_DATE");
            rs = pst.executeQuery();
            while (rs.next())
            {
                count = rs.getInt("count");

            }

        }catch (Exception e ){System.out.print(e);}
        return count;
    }

    public List<String> getheur(String jour)
    {
        List<String> heursdispo = new ArrayList<>();
        try {


            String sql = "WITH heures_disponibles AS ( SELECT '08:00' AS heure UNION ALL SELECT '09:00' UNION ALL SELECT '10:00' UNION ALL SELECT '11:00' UNION ALL SELECT '12:00' UNION ALL SELECT '13:00' UNION ALL SELECT '14:00' UNION ALL SELECT '15:00' UNION ALL SELECT '16:00' UNION ALL SELECT '17:00' ) SELECT heure FROM heures_disponibles LEFT JOIN rendezvous r ON r.jour = ? AND r.date_heure = heures_disponibles.heure WHERE r.date_heure IS NULL ";
            PreparedStatement pst = cnx.prepareStatement(sql);
            java.sql.Date jourDATE = java.sql.Date.valueOf(jour);
            pst.setDate(1,jourDATE);

            rs = pst.executeQuery();
            while (rs.next())
            {
                heursdispo.add(rs.getString(1));
            }
            return heursdispo;
        }catch (Exception e){System.out.print(e);}
        return heursdispo;
    }


}
