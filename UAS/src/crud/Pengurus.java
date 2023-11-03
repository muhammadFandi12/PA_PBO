/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;


import databases.Database;
import implement.implementPengurus;
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.modelPengurus;


public class Pengurus implements implementPengurus{
    Connection connection;
    
    final String insert = "INSERT INTO mengurusi (Nama_Hewan, Nama_Karyawan) VALUES (?,?)";
    final String select = "SELECT Nama_Hewan, Nama_Karyawan FROM mengurusi";

    public Pengurus(){
       connection = Database.configDB();
    }
    
    @Override
    public void insert (modelPengurus P){
      PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setString(1, P.getNama_Hewan());
            statement.setString(2, P.getNama_karyawan());

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
    public java.util.List<modelPengurus> getALLPengurus() {
        java.util.List<modelPengurus> lb = null;
        try {
            lb = new ArrayList<modelPengurus>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                modelPengurus p = new modelPengurus();
                p.setNama_Hewan(rs.getString("Nama_Hewan"));
                p.setNama_karyawan(rs.getString("nama_Karyawan"));
                lb.add(p); // Tambahkan objek p ke dalam daftar lb
            }
        } catch (SQLException ex) {
            Logger.getLogger(Pengurus.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
}
