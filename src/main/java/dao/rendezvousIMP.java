package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import models.rendezvous;

public class rendezvousIMP implements IntRendezvous{

Connection cnx = connectiondb.getConnection();
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
         ResultSet rs;
        List<rendezvous> allrendezvous =new ArrayList<>();
        String strquery = "select *from rendezvous";

        try
        {
            PreparedStatement pst = cnx.prepareStatement(strquery);
            rs = pst.executeQuery(strquery);

            while(rs.next())
            {
                rendezvous rendezvous1 = new rendezvous();
                rendezvous1.setNom(rs.getString(1));
                rendezvous1.setPrenom(rs.getString(2));
                rendezvous1.setCin(rs.getString(3));
                rendezvous1.setTelephone(rs.getInt(4));
                rendezvous1.setDate(rs.getString(5));
                rendezvous1.setDate_heure(rs.getString(6));

                allrendezvous.add(rendezvous1);
            }


        }catch (Exception e){System.out.print(e);}
        return allrendezvous;
    }

}
