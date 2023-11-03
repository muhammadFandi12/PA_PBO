
package crud;
import java.sql.*;
import implement.implementHewan;
import databases.Database;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import model.modelHewan;


 public class Hewan implements implementHewan{
    Connection connection;
    final String insert = "INSERT INTO hewan (Hewan, Jumlah, Kandang) VALUES (?,?,?);";
    final String update = "UPDATE hewan set Hewan=?, Jumlah=?, Kandang=? where ID=?;";
    final String delete = "DELETE FROM hewan where ID=?;";
    final String select = "SELECT * FROM hewan;";
    final String carinama = "SELECT * FROM hewan where Hewan like ?";
    
    public Hewan(){
       connection = Database.configDB();
    }
    
    @Override
    public void insert (modelHewan b){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, statement.RETURN_GENERATED_KEYS);
            statement.setString(1, b.getHewan());
            statement.setString(2, b.getJumlah());
            statement.setString(3, b.getKandang());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                int id = rs.getInt(1);
                b.setID(id);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void update (modelHewan b){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, b.getHewan());
            statement.setString(2, b.getJumlah());
            statement.setString(3, b.getKandang());
            statement.setInt(4, b.getID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public void delete (int ID){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, ID);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
    
    @Override
    public java.util.List<modelHewan> getCariHewan(String Hewan){
        java.util.List<modelHewan> lb = null;
        try {
            lb = new ArrayList<modelHewan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + Hewan + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                modelHewan b = new modelHewan();
                b.setID(rs.getInt("ID"));
                b.setHewan(rs.getString("Hewan"));
                b.setJumlah(rs.getString("Jumlah"));
                b.setKandang(rs.getString("Kandang"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
     
    
    
    @Override
    public java.util.List<modelHewan> getALL(){
        java.util.List<modelHewan> lb = null;
        try {
            lb = new ArrayList<modelHewan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                modelHewan b = new modelHewan();
                b.setID(rs.getInt("ID"));
                b.setHewan(rs.getString("Hewan"));
                b.setJumlah(rs.getString("Jumlah"));
                b.setKandang(rs.getString("Kandang"));
                lb.add(b);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }   
    
    
    
}
