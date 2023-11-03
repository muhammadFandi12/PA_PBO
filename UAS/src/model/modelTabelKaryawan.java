/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NITRO 5
 */
public class modelTabelKaryawan extends AbstractTableModel{
    List<modelKaryawan> listkKaryawans;
    
    public modelTabelKaryawan(List<modelKaryawan> listKaryawans){
        this.listkKaryawans = listKaryawans;
    }
    
    @Override
    public int getRowCount() {
        return listkKaryawans.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    
    @Override
    public String getColumnName(int  column) {
        switch (column){
            case 0:
                return "ID_karyawan";
            case 1:
                return "nama_Karyawan";
            case 2:
                return "jabatan";
            case 3:
                return "umur";
            case 4:
                return "jenis_Kelamin";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return listkKaryawans.get(row).getID_karyawan();
            case 1:
                return listkKaryawans.get(row).getNama_Karyawan();
            case 2:
                return listkKaryawans.get(row).getJabatan();
            case 3:
                return listkKaryawans.get(row).getUmur();
            case 4:
                return listkKaryawans.get(row).getJenis_Kelamin();
            default:
                return null;
        }
    }
}
