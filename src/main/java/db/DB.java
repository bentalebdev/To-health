package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB {
    public static Connection con = null;
    public  static Connection getCon() throws  Exception{
        if(con==null)
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/anpe_db";
            con = DriverManager.getConnection(url,"root","");
        }
        return con;
    }
}
