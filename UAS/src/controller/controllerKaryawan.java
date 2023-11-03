package controller;

import implement.implementKaryawan;
import model.modelKaryawan;
import view.Menu_Karyawan;
import java.util.List;
import model.modelTabelKaryawan;
import crud.Karyawan;
import javax.swing.JOptionPane;


public class controllerKaryawan {
    Menu_Karyawan frameMenus;
    implementKaryawan ImplemetKaryawans;
    List<modelKaryawan> listKaryawans;
    String namePattern = "^[A-Za-z ]+$";
    
    public controllerKaryawan(Menu_Karyawan frameMenu){
        this.frameMenus = frameMenu;
        ImplemetKaryawans = new Karyawan();
        listKaryawans = ImplemetKaryawans.getALLkaryawan();
    }
    
    
    public void  reset(){
        frameMenus.getTxtID_Karyawan().setText("");
        frameMenus.getTxtNamaKaryawan().setText("");
        frameMenus.getTxtJabatan().setText("");
        frameMenus.getTxtUmur().setText("");
        frameMenus.getTxtJenis_Kelamin().setText("");    
    }
    
    public void isiTable(){
        listKaryawans = ImplemetKaryawans.getALLkaryawan();
        modelTabelKaryawan mtk = new modelTabelKaryawan(listKaryawans);
        frameMenus.getTabelModelKaryawan().setModel(mtk);
    }
    
    public void isiField (int row) {
        frameMenus.getTxtID_Karyawan().setText(listKaryawans.get(row).getID_karyawan().toString());
        frameMenus.getTxtNamaKaryawan().setText(listKaryawans.get(row).getNama_Karyawan());
        frameMenus.getTxtJabatan().setText(listKaryawans.get(row).getJabatan());
        frameMenus.getTxtUmur().setText(listKaryawans.get(row).getUmur().toString());
        frameMenus.getTxtJenis_Kelamin().setText(listKaryawans.get(row).getJenis_Kelamin());        
    }
    
        public void insert() {
        String idKaryawan = frameMenus.getTxtID_Karyawan().getText().trim();
        String namaKaryawan = frameMenus.getTxtNamaKaryawan().getText().trim();
        String jabatan = frameMenus.getTxtJabatan().getText().trim();
        String umur = frameMenus.getTxtUmur().getText().trim();
        String jenisKelamin = frameMenus.getTxtJenis_Kelamin().getText().trim();

        if (idKaryawan.matches("\\d+") &&
            !namaKaryawan.isEmpty() && namaKaryawan.matches("[a-zA-Z]+") &&
            !jabatan.isEmpty() && jabatan.matches("[a-zA-Z]+") &&
            umur.matches("\\d+") &&
            !jenisKelamin.isEmpty() && jenisKelamin.matches("[a-zA-Z]+")) {

            modelKaryawan mk = new modelKaryawan();
            mk.setID_karyawan(Integer.parseInt(idKaryawan));
            mk.setNama_Karyawan(namaKaryawan);
            mk.setJabatan(jabatan);
            mk.setUmur(Integer.parseInt(umur));
            mk.setJenis_Kelamin(jenisKelamin);

            ImplemetKaryawans.insert(mk);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
        } else {
            JOptionPane.showMessageDialog(frameMenus, "DATA TIDAK SESUAI FORMAT ATAU ADA KOLOM KOSONG");
        }
    }


//    public void insert() {
//        if(!frameMenus.getTxtID_Karyawan().getText().trim().isEmpty()&!frameMenus.getTxtNamaKaryawan().getText().trim().isEmpty()& !frameMenus.getTxtJabatan().getText().trim().isEmpty()& !frameMenus.getTxtUmur().getText().trim().isEmpty()& !frameMenus.getTxtJenis_Kelamin().getText().trim().isEmpty()){
//            modelKaryawan mk = new modelKaryawan();
//            mk.setID_karyawan(Integer.parseInt(frameMenus.getTxtID_Karyawan().getText()));
//            mk.setNama_Karyawan(frameMenus.getTxtNamaKaryawan().getText());
//            mk.setJabatan(frameMenus.getTxtJabatan().getText());
//            mk.setUmur(Integer.parseInt(frameMenus.getTxtUmur().getText()));
//            mk.setJenis_Kelamin(frameMenus.getTxtJenis_Kelamin().getText());
//             
//            ImplemetKaryawans.insert(mk);
//            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
//        } else {
//            JOptionPane.showMessageDialog(frameMenus, "DATA TIDAK BOLEH KOSONG" );
//        }
//    }
    
    public void update(){
        if(!frameMenus.getTxtID_Karyawan().getText().trim().isEmpty()){
            modelKaryawan mk = new modelKaryawan();
            mk.setID_karyawan(Integer.parseInt(frameMenus.getTxtID_Karyawan().getText()));
            mk.setNama_Karyawan(frameMenus.getTxtNamaKaryawan().getText());
            mk.setJabatan(frameMenus.getTxtJabatan().getText());
            mk.setUmur(Integer.parseInt(frameMenus.getTxtUmur().getText()));
            ImplemetKaryawans.update(mk);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DI UPDATE");
        }else {
            JOptionPane.showMessageDialog(frameMenus, "SILAHKAN PILIH DATA YG AKAN DI UPDATE");
        }
    }
    
    

    
    public void delete(){
        if(!frameMenus.getTxtID_Karyawan().getText().trim().isEmpty()){
            int ID = Integer.parseInt(frameMenus.getTxtID_Karyawan().getText());
            ImplemetKaryawans.delete(ID);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DIHAPUS");
        }else {
            JOptionPane.showMessageDialog(frameMenus, "SILAHKAN PILIH DATA YG AKAN DI HAPUS");
        }
    }
    
    public void isiTabelCariNama(){
        listKaryawans = ImplemetKaryawans.getCariKaryawan(frameMenus.getTxtCariNama().getText());
        modelTabelKaryawan mtk = new modelTabelKaryawan(listKaryawans);
        frameMenus.getTabelModelKaryawan().setModel(mtk);
    }
    
    public void cariNama(){
        if(!frameMenus.getTxtCariNama().getText().trim().isEmpty()){
            ImplemetKaryawans.getCariKaryawan(frameMenus.getTxtCariNama().getText());
            isiTabelCariNama();
        } else {
            JOptionPane.showMessageDialog(frameMenus, "SILAHKAN PILIH DATA !!!");
        }
    }
}

