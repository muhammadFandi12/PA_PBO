/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import implement.implementPengurus;
import view.Menu_Pengurus_Hewan;
import model.modelPengurus;
import java.util.List;
import javax.swing.JOptionPane;
import model.modelTabelPengurus;
import crud.Pengurus;
/**
 *
 * @author NITRO 5
 */
public class controllerPengurus {
    Menu_Pengurus_Hewan fraMenu_Pengurus_Hewan;
    implementPengurus imPengurus;
    List<modelPengurus> listPengurus;
    
    
    public controllerPengurus(Menu_Pengurus_Hewan fraHewan){
        this.fraMenu_Pengurus_Hewan = fraHewan;
        imPengurus =  new Pengurus();
        listPengurus = imPengurus.getALLPengurus();
    }
    
    public void isiTable(){
        listPengurus = imPengurus.getALLPengurus();
        modelTabelPengurus mtp = new modelTabelPengurus(listPengurus);
        fraMenu_Pengurus_Hewan.getTabelModelPengurus().setModel(mtp);
    }
    
    public void insert() {
        modelPengurus mp = new modelPengurus();
        String selectedHewan = fraMenu_Pengurus_Hewan.getComboHewan().getSelectedItem().toString();
        String selectedPengurus = fraMenu_Pengurus_Hewan.getComboPengurus().getSelectedItem().toString();

        if (!selectedHewan.isEmpty() && !selectedPengurus.isEmpty()) {
            mp.setNama_Hewan(selectedHewan);
            mp.setNama_karyawan(selectedPengurus);

            imPengurus.insert(mp);
            JOptionPane.showMessageDialog(null, "DATA BERHASIL DISIMPAN");
        } else {
            JOptionPane.showMessageDialog(fraMenu_Pengurus_Hewan, "DATA TIDAK BOLEH KOSONG");
        }
    }

    public void isifield(int row){
        fraMenu_Pengurus_Hewan.getComboHewan().setSelectedItem(listPengurus.get(row).getNama_Hewan());
        fraMenu_Pengurus_Hewan.getComboPengurus().setSelectedItem(listPengurus.get(row).getNama_karyawan());
    }
    
    
    public void reset(){
        fraMenu_Pengurus_Hewan.getComboHewan().setSelectedItem("---NAMA HEWAN---");
        fraMenu_Pengurus_Hewan.getComboPengurus().setSelectedItem("---NAMA PENGURUS---");
    }
    
    


}
