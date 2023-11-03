package implement;

import model.modelKaryawan;
import java.util.List;

public interface implementKaryawan {
    public void insert(modelKaryawan A);
    public void update(modelKaryawan A);
    public void delete(int ID_karyawan);
    
    List<modelKaryawan> getALLkaryawan();
    List<modelKaryawan> getCariKaryawan(String nama_karyawan);
}
