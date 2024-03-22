import java.sql.*;

public class bdd {
    //String nomDriver="com.jdbc.mysql.Driver";
    public static  void main(String[] args){


        String url="jdbc:mysql://127.0.0.1/db_tpjava";
        String username="root";
        String password="";

        EtudiantDao dao= new EtudiantDao(url,username,password);
        //int a=dao.insertEtudiant("Tej","Karim",15550552,15);
        //int a=dao.supprimerEtudiant(15550552);
       // int a=dao.modifierEtudiant("Gabsi","Mehdi",14023088,15.2);
        dao.afficheAll();

    }
}
