package dao;
import models.utilisateurs;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class utlisateurIMP implements Intutlisateur{
    Connection cnx = connectiondb.getConnection();
    ResultSet RS ;
  @Override
    public void connect(String username , String password)
    {
        String sql = "select nom , prenom from utilisateur ";
        try
        {
            PreparedStatement pst = cnx.prepareStatement(sql);

        }catch (Exception e){System.out.print(e);}
    }
}
