import javax.swing.*;
import java.sql.*;
import java.util.Collection;

public class EtudiantDao implements  EtudiantDaoCrud{


    Connection connect;
    public EtudiantDao(String url,String username,String password){
                connect=Myconnection.getConnection(url,username,password);

    }
    @Override
    public int insertEtudiant(String nom, String prenom, int cin, double moy) {
        String req="insert into etudiant values (?,?,?,?)";//1 2 3 4
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setInt(3,cin);
            ps.setDouble(4,moy);
            a=ps.executeUpdate();
            System.out.println("insert de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err insert");
            JOptionPane.showMessageDialog(null,"il y a quelque chose qui ne marche pas!\nessayez de changer le CIN");
        }
        return a;
    }

    @Override
    public int modifierEtudiant(String nom, String prenom, int cin, double moy) {
        String req="update etudiant set nom= ?, prenom=? , moyenne=? where cin=?";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setString(1,nom);
            ps.setString(2,prenom);
            ps.setDouble(3,moy);
            ps.setInt(4,cin);
            a=ps.executeUpdate();
            System.out.println("update de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err modifier");
        }
        return a;
    }

    @Override
    public int supprimerEtudiant(int cin) {
        String req="delete from etudiant where cin=?";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setInt(1,cin);

            a=ps.executeUpdate();
            System.out.println("suppression de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err supprimer");
        }
        return a;
    }

    @Override
    public int supprimerTous() {
        String req="delete from etudiant where true";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            a=ps.executeUpdate();
            System.out.println("suppression de TOUS le tableau est terminé");
        } catch (SQLException e) {
            System.out.println("err supprimerTous");
        }
        return a;
    }

    ResultSet selection(String req){
        Statement st= null;
        ResultSet rs = null;
        try {
            st = connect.createStatement();

            if(st!=null) {


                rs = st.executeQuery(req);

                System.out.println("\nTable Etudiant:");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;

    }
    public void  aff(ResultSet rs){

            try {
                while (rs.next()){
                    String nom=rs.getString(1);
                    String prenom=rs.getString(2);
                    int cin=rs.getInt(3);
                    double m=rs.getDouble(4);
                    System.out.println(nom+" "+prenom+"  "+cin+" "+m);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


    }
    @Override
    public void afficheAll() {
        String r = "select * from etudiant";
        ResultSet st= selection(r);
        aff(st);

    }


}
