package dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
}
