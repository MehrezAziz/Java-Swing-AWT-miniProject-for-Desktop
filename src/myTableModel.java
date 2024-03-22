import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class myTableModel extends AbstractTableModel {

    static String url="jdbc:mysql://127.0.0.1/db_tpjava";
    static String username="root";
    static String password="";
    ArrayList<Object[]> data=new ArrayList<Object[]>();
    ResultSetMetaData rsmd;


    myTableModel(ResultSet rs){
        try {
            rsmd=rs.getMetaData();
            while(rs.next()){
                Object[] ligne=new Object[rsmd.getColumnCount()];
                for(int i=0;i<ligne.length;i++){
                    ligne[i]=rs.getObject(i+1);

                }
                data.add(ligne);
            }

//err insert
        } catch (SQLException e) {
            System.out.println("erreur getMetaData");
        }


    }

    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        try {
            return rsmd.getColumnCount();
        } catch (SQLException e) {
            return 0;
        }
    }

    public void removeRow(int rowIndex,int cin) {
        data.remove(rowIndex);
        EtudiantDao etudiant=new EtudiantDao(url,username,password);
        etudiant.supprimerEtudiant(cin);
        fireTableRowsDeleted(rowIndex, rowIndex);

    }
    public void removeAllRows() {

        EtudiantDao etudiant=new EtudiantDao(url,username,password);
        etudiant.supprimerTous ();
        fireTableRowsDeleted(0, data.size());
        data.clear();
    }
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data.get(rowIndex)[columnIndex];
    }

    @Override
    public String getColumnName(int column) {
        try {
            return rsmd.getColumnName(column+1);
        } catch (SQLException e) {
            return "";
        }
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        if(getColumnName(columnIndex).equalsIgnoreCase("cin")) //le cin est interdit de le modifier
            return false;
        return true;
    }

    void insertEtudiant(String nom,String prenom,int cin,double moyenne){

        EtudiantDao etudiant=new EtudiantDao(url,username,password);
        int a=etudiant.insertEtudiant(nom,prenom,cin,moyenne);
        if(a!=0)
        {
            data.add(new Object[]{nom,prenom,cin,moyenne});
            fireTableDataChanged();//reload
            JOptionPane.showMessageDialog(null,"Ajout terminé avec succé");
        }

    }

    public int columnIndex(String colName){
        for (int i=0; i<getColumnCount();i++){
            if(getColumnName(i).equalsIgnoreCase(colName))
                return i;
        }
        return -1;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

        EtudiantDao etudiant=new EtudiantDao(url,username,password);


        Object dataSecon[];
        dataSecon=data.get(rowIndex);

        dataSecon[columnIndex]=aValue;
        int a=etudiant.modifierEtudiant((String) dataSecon[0], (String) dataSecon[1], (Integer) dataSecon[2],Double.parseDouble(dataSecon[3].toString()));
        fireTableDataChanged();
        if(a>0){
            data.get(rowIndex)[columnIndex]=aValue;

        }


    }
}