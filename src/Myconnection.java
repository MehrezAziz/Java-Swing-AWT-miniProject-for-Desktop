import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Myconnection {
    public static Connection getConnection(String url, String username, String password){
        String nomDriver="com.mysql.jdbc.Driver";
        try {
            Class.forName(nomDriver);
            System.out.println("Driver chargé");


        } catch (ClassNotFoundException e) {
            //throw new RuntimeException(e);
            System.out.println("Erreur lors de chargement du driver "+e.getMessage());
        }
        Connection con=null;
        try {
            con= DriverManager.getConnection(url,username,password);
            System.out.println("BDD connected");
        } catch (SQLException e) {
            System.out.println("Erreur de connection de BDD "+e.getMessage());
        }
        return con;
    }
}
