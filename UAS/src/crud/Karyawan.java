/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package crud;

import databases.Database;
import java.sql.*;
import implement.implementKaryawan;
import java.util.ArrayList;

import java.util.logging.*;




/**
 *
 * @author NITRO 5
 */
import model.modelKaryawan;
public class Karyawan implements implementKaryawan{
    Connection connection;
    final String insert = "INSERT INTO karyawan (ID_karyawan, nama_Karyawan, jabatan, umur, jenis_Kelamin) VALUES (?,?,?,?,?);";
    final String update = "UPDATE karyawan set nama_karyawan=?, jabatan=?, umur=?, jenis_Kelamin=? where ID_Karyawan=?;";
    final String delete = "DELETE FROM karyawan where ID_karyawan=?;";
    final String select = "SELECT * FROM karyawan;";
    final String carinama = "SELECT * FROM karyawan where nama_Karyawan like ?";
    
      public Karyawan(){
       connection = Database.configDB();
    }
    
    @Override
    public void insert (modelKaryawan A){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert);
            statement.setInt(1, A.getID_karyawan());
            statement.setString(2, A.getNama_Karyawan());
            statement.setString(3, A.getJabatan());
            statement.setInt(4, A.getUmur());
            statement.setString(5, A.getJenis_Kelamin());
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
    public void update (modelKaryawan A){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, A.getNama_Karyawan());
            statement.setString(2, A.getJabatan());
            statement.setInt(3, A.getUmur());
            statement.setString(4, A.getJenis_Kelamin());
            statement.setInt(5, A.getID_karyawan());
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
    public void delete (int ID_Karyawan){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);
            statement.setInt(1, ID_Karyawan);
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
    public java.util.List<modelKaryawan> getCariKaryawan(String nama_Karyawan){
        java.util.List<modelKaryawan> lb = null;
        try {
            lb = new ArrayList<modelKaryawan>();
            PreparedStatement st = connection.prepareStatement(carinama);
            st.setString(1, "%" + nama_Karyawan + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                modelKaryawan mk = new modelKaryawan();
                mk.setID_karyawan(rs.getInt("ID_karyawan"));
                mk.setNama_Karyawan(rs.getString("nama_Karyawan"));
                mk.setJabatan(rs.getString("jabatan"));
                mk.setUmur(rs.getInt("umur"));
                mk.setJenis_Kelamin(rs.getString("jenis_Kelamin"));
                lb.add(mk);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
    @Override
    public java.util.List<modelKaryawan> getALLkaryawan(){
        java.util.List<modelKaryawan> lb = null;
        try {
            lb = new ArrayList<modelKaryawan>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()){
                modelKaryawan A = new modelKaryawan();
                A.setID_karyawan(rs.getInt("ID_karyawan"));
                A.setNama_Karyawan(rs.getString("nama_Karyawan"));
                A.setJabatan(rs.getString("jabatan"));
                A.setUmur(rs.getInt("umur"));
                A.setJenis_Kelamin(rs.getString("jenis_Kelamin"));
                lb.add(A);
            }
        } catch (SQLException ex) {
            Logger.getLogger(Hewan.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lb;
    }
    
}
