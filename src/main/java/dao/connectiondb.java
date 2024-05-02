package dao;
import java.sql.Connection;
import java.sql.DriverManager;
public class connectiondb {
    private static Connection connection;
    static
    {
     try {
         Class.forName("com.mysql.cj.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/cabinet";
         connection = DriverManager.getConnection(url,"root","");
     } catch (Exception e) {System.out.print(e);}
    }

    public static Connection getConnection(){return connection;}
}
