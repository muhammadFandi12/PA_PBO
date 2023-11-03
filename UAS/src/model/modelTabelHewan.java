
package model;
import javax.swing.table.AbstractTableModel;
import java.util.List;


public class modelTabelHewan extends AbstractTableModel{

    List<modelHewan> listHewan;
    
    public modelTabelHewan(List<modelHewan> listHewan){
        this.listHewan = listHewan;
    }
    
    @Override
    public int getRowCount() {
        return listHewan.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    
    @Override
    public String getColumnName(int  column) {
        switch (column){
            case 0:
                return "ID";
            case 1:
                return "Hewan";
            case 2:
                return "Jumlah";
            case 3:
                return "Kandang";
            default:
                return null;
        }
    }
    @Override
    public Object getValueAt(int row, int column) {
        switch (column){
            case 0:
                return listHewan.get(row).getID();
            case 1:
                return listHewan.get(row).getHewan();
            case 2:
                return listHewan.get(row).getJumlah();
            case 3:
                return listHewan.get(row).getKandang();
            default:
                return null;
        }
    }
    
}
