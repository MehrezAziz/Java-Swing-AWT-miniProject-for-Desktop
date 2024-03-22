package oo;

import javax.swing.*;
import java.sql.*;
import  java.util.*;
import java.util.Date;


public class Formation implements  formationCRUD{
    private int id;
    private String titre,lieu;
    private boolean certification;
    private Date dateF;

    public Formation(int id, String titre,String lieu, boolean certif, Date date){
        this.id=id;
        this.titre=titre;
        this.lieu=lieu;
        certification=certif;
        dateF=date;

    }
    Connection connect;
    public Formation(String url,String username,String password){
        connect= generale.Myconnection.getConnection(url,username,password);

    }
    ResultSet selection(String req){
        Statement st= null;
        ResultSet rs = null;
        try {
            st = connect.createStatement();

            if(st!=null) {


                rs = st.executeQuery(req);

                System.out.println("\nTable Formation:");

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return rs;

    }
    public void  aff(ResultSet rs){

        try {
            while (rs.next()){
                int id= rs.getInt(1);
                String titre=rs.getString(2);
                Date date= rs.getDate(3);
                String lieu=rs.getString(4);
                boolean certif=rs.getBoolean(5);
                System.out.println(id+" "+titre+"  "+date+" "+lieu+ " "+ certif);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
    @Override
    public void afficheAll() {
        String r = "select * from formation";
        ResultSet st= selection(r);
        aff(st);

    }

    @Override
    public int insertFormation(int id, String titre, Date datef, String lieu, boolean certificat) {
        String req="insert into etudiant values (?,?,?,?,?)";//1 2 3 4 5
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setInt(1,id);
            ps.setString(2,titre);
            ps.setDate(3, (java.sql.Date) datef);
            ps.setString(4,lieu);
            ps.setBoolean(5,certificat);
            a=ps.executeUpdate();
            System.out.println("insert de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err insert formation");
            JOptionPane.showMessageDialog(null,"il y a quelque chose qui ne marche pas!\nessayez de changer le CIN");
        }
        return a;
    }

    @Override
    public int modifierEtudiant(int id, String titre, Date datef, String lieu, boolean certificat) {
        String req="update formation set  titre=? , datef=?, lieu=? , certificat=? where id=?";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setString(1,titre);
            ps.setDate(2, (java.sql.Date) datef);
            ps.setString(3,lieu);
            ps.setBoolean(4,certificat);
            ps.setInt(5,id);
            a=ps.executeUpdate();
            System.out.println("update de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err modifier formation");
        }
        return a;
    }

    @Override
    public int supprimerEtudiant(int id) {
        String req="delete from formation where id=?";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            ps.setInt(1,id);

            a=ps.executeUpdate();
            System.out.println("suppression de "+a+" element(s) terminé");
        } catch (SQLException e) {
            System.out.println("err supprimer formation");
        }
        return a;
    }



    @Override
    public int supprimerTous() {
        String req="delete from formation where true";
        int a=0;
        try {
            PreparedStatement ps= connect.prepareStatement(req);
            a=ps.executeUpdate();
            System.out.println("suppression de TOUS le tableau est terminé");
        } catch (SQLException e) {
            System.out.println("err supprimerTous formation");
        }
        return a;
    }

    public Date getDateF() {
        return dateF;
    }

    public int getId() {
        return id;
    }

    public String getLieu() {
        return lieu;
    }

    public String getTitre() {
        return titre;
    }

    public void setCertification(boolean certification) {
        this.certification = certification;
    }

    public void setDateF(Date dateF) {
        this.dateF = dateF;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }
}
