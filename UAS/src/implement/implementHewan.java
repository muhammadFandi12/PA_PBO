/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package implement;

import model.modelHewan;


public interface implementHewan {
    public void insert(modelHewan b);
    public void update(modelHewan b);
    public void delete(int ID);
    
    public java.util.List<modelHewan> getALL();
    public java.util.List<modelHewan> getCariHewan(String Hewan);
    
}
