
package controller;
import implement.implementHewan;
import model.modelHewan;
import crud.Hewan;
import view.Menu_Hewan;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelTabelHewan;


public class controllerHewan {
    Menu_Hewan frameMenu;
    implementHewan ImplemetHewan;
    List<modelHewan> listHewan;
    
    public controllerHewan(Menu_Hewan framemenu){
        this.frameMenu = framemenu;
        ImplemetHewan = new Hewan();
        listHewan = ImplemetHewan.getALL();
    }
    
    public void  reset(){
        frameMenu.getTxtIDhewan().setText("");
        frameMenu.getTxtNamaHewan().setText("");
        frameMenu.getTxtJumlahHewan().setText("");
        frameMenu.getKandang().setSelectedItem("PILIH KANDANG");
    }
    
    public void isiTable(){
        listHewan = ImplemetHewan.getALL();
        modelTabelHewan mth = new modelTabelHewan(listHewan);
        frameMenu.getTabelModelHewan().setModel(mth);
    }
    
    public void isiField (int row) {
        frameMenu.getTxtIDhewan().setText(listHewan.get(row).getID().toString());
        frameMenu.getTxtNamaHewan().setText(listHewan.get(row).getHewan());
        frameMenu.getTxtJumlahHewan().setText(listHewan.get(row).getJumlah());
        frameMenu.getKandang().setSelectedItem(listHewan.get(row).getKandang());
    }
    
    public void insert() {
        String namaHewan = frameMenu.getTxtNamaHewan().getText().trim();
        String jumlahHewan = frameMenu.getTxtJumlahHewan().getText().trim();

            if (namaHewan.matches("[a-zA-Z]+") && jumlahHewan.matches("\\d+")) {
                modelHewan mh = new modelHewan();
                mh.setHewan(namaHewan);
                mh.setJumlah(jumlahHewan);
                mh.setKandang(frameMenu.getKandang().getSelectedItem().toString());

                ImplemetHewan.insert(mh);
                JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
            } else {
                JOptionPane.showMessageDialog(frameMenu, "Data tidak valid. Pastikan nama hewan hanya berisi huruf dan jumlah hewan hanya berisi digit numerik.");
            }
    }



//    public void insert() {
//        if(!frameMenu.getTxtNamaHewan().getText().trim().isEmpty()& !frameMenu.getTxtJumlahHewan().getText().trim().isEmpty()){
//            modelHewan mh = new modelHewan();
//            mh.setHewan(frameMenu.getTxtNamaHewan().getText());
//            mh.setJumlah(frameMenu.getTxtJumlahHewan().getText());
//            mh.setKandang(frameMenu.getKandang().getSelectedItem().toString());
//
//            ImplemetHewan.insert(mh);
//            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
//        } else {
//            JOptionPane.showMessageDialog(frameMenu, "DATA TIDAK BOLEH KOSONG" );
//        }
//    }
    
    public void update(){
        if(!frameMenu.getTxtIDhewan().getText().trim().isEmpty()){
            modelHewan mh = new modelHewan();
            mh.setHewan(frameMenu.getTxtNamaHewan().getText());
            mh.setJumlah(frameMenu.getTxtJumlahHewan().getText());
            mh.setKandang(frameMenu.getKandang().getSelectedItem().toString());
            mh.setID(Integer.parseInt(frameMenu.getTxtIDhewan().getText()));
            
            ImplemetHewan.update(mh);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UPDATE");
        }else {
            JOptionPane.showMessageDialog(frameMenu, "SILAHKAN PILIH DATA YG AKAN DI UPDATE");
        }
    }
    
    public void delete(){
        if(!frameMenu.getTxtIDhewan().getText().trim().isEmpty()){
            int ID = Integer.parseInt(frameMenu.getTxtIDhewan().getText());
            ImplemetHewan.delete(ID);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
        }else {
            JOptionPane.showMessageDialog(frameMenu, "SILAHKAN PILIH DATA YG AKAN DI HAPUS");
        }
    }
    
    public void isiTabelCariNama(){
        listHewan = ImplemetHewan.getCariHewan(frameMenu.getTxtCariData().getText());
        modelTabelHewan mth = new modelTabelHewan(listHewan);
        frameMenu.getTabelModelHewan().setModel(mth);
    }
    
    public void cariNama(){
        if(!frameMenu.getTxtCariData().getText().trim().isEmpty()){
            ImplemetHewan.getCariHewan(frameMenu.getTxtCariData().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frameMenu, "SILAHKAN PILIH DATA !!!");
        }
    }
}

