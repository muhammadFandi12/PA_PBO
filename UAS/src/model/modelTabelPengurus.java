package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;


public class modelTabelPengurus extends AbstractTableModel{
    List<modelPengurus> listPengurus;

    public modelTabelPengurus(List<modelPengurus> listPengurus) {
        this.listPengurus = listPengurus;
    }

    @Override
    public int getRowCount() {
        return listPengurus.size();
    }

    @Override
    public int getColumnCount() {
        return 2;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Nama Hewan";
            case 1:
                return "Nama Karyawan";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch (column) {
            case 0:
                return listPengurus.get(row).getNama_Hewan();
            case 1:
                return listPengurus.get(row).getNama_karyawan();
            default:
                return null;
        }
    }

    

    

    

    
}
