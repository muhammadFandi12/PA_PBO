# Capstone-project-kelompok 15
nama : muhammad fandi perdana (094)
nama : putri nadila maharani (084)


# PENDATAAN PETERNAKAN
data peternakan adalah langkah penting dalam memastikan pengelolaan peternakan yang efisien dan berkelanjutan. Data admin berperan dalam menjaga keamanan dan pengendalian akses ke sistem, memastikan bahwa hanya pihak yang berwenang yang dapat mengakses informasi dalam peternakan. Dengan pengelolaan data admin yang baik,pemilik peternakan dapat memastikan bahwa sistem terlindungi dari akses yang tidak sah, menjaga kerahasiaan informasi sensitif, dan mematuhi peraturan 
keamanan data.Entitas karyawan menjadi aspek penting dalam manajemen peternakan. Informasi tentang karyawan, seperti nama, jabatan, umur, dan jenis kelamin, membantu dalam penjadwalan kerja, pemantauan kinerja, dan pengelolaan tim dengan efisien. Dengan data karyawan yang terdokumentasi dengan baik, pemilik peternakan dapatmemastikan bahwa semua anggota tim memiliki peran yang jelas dan sesuai dengan kebutuhan operasional.Sementara itu, entitas hewan dalam manajemen peternakan digunakan untuk memberi informasi tentang hewan, seperti jenis, jumlah, dan asal kandang. Dengan pencatatan data hewan yang sistematis, pemilik peternakan dapat melakukan pemantauan yang efektif, perencanaan pemeliharaan, serta pengambilan keputusan yang tepat untuk meningkatkan 
produktivitas hewan.


# FLOWCHART
![PA_flow drawio](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/65b3f2c0-b9f2-45c6-bcc8-9b61d3ac27ff)



# KELAS
![image](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/fd200ff7-8a3a-4184-92a2-821a9cbfb9ca)




# KODINGAN BESERTA PENJELASANNYA


![image](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/c6e3c327-2f6d-4c92-9e50-40ca2d51aea7)




Codingan ini adalah bagian dari sebuah program Java yang digunakan untuk mengatur koneksi ke database MySQL. Dalam kode ini, ada beberapa komponen utama:

package databases;: Ini adalah deklarasi paket (package) di Java. Paket ini berfungsi untuk mengorganisasi kelas-kelas dalam proyek Java. Dalam hal ini, kelas Database ditempatkan dalam paket "databases."
import java.sql.*;: Ini adalah pernyataan untuk mengimpor semua kelas yang terkait dengan JDBC (Java Database Connectivity), yang digunakan untuk berinteraksi dengan database. public class Database {: Ini adalah deklarasi kelas utama dalam kode. Kelas ini diberi nama "Database." private static Connection mysqlconfig;: Ini adalah deklarasi variabel statis mysqlconfig yang bertipe Connection. Variabel ini digunakan untuk menyimpan koneksi ke database. Dideklarasikan sebagai statis, sehingga hanya ada satu salinan variabel ini di seluruh aplikasi. public static Connection configDB() {: Ini adalah deklarasi metode configDB() yang mengembalikan objek Connection. Metode ini digunakan untuk mengatur koneksi ke database.
Dalam blok try-catch, koneksi ke database MySQL dikonfigurasi. Detail koneksi seperti URL database (url), nama pengguna (user), dan kata sandi (password) telah ditentukan.
url: Menunjukkan URL database MySQL yang akan digunakan. Dalam contoh ini, database disimpan di server lokal pada port 3306 dengan nama "peternakan."
user: Menunjukkan nama pengguna yang digunakan untuk mengakses database. Dalam contoh ini, nama pengguna adalah "root."
password: Menunjukkan kata sandi yang digunakan untuk mengakses database. Dalam contoh ini, tidak ada kata sandi yang ditetapkan.
Jika ada kesalahan dalam blok try, pesan kesalahan akan dicetak ke konsol menggunakan System.err.println(). Terakhir, objek Connection yang telah dikonfigurasi (jika berhasil) akan dikembalikan dari metode configDB().







![WhatsApp Image 2023-11-04 at 02 47 36_1e9e3c91](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/15bcfcb4-2bbd-4126-bc01-44873db184dc)







![3](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/9cedf0c2-9723-49ac-b097-7ff4ff327ff9)




Kode ini adalah definisi dari kelas Java bernama modelHewan yang digunakan untuk merepresentasikan objek data terkait hewan dalam suatu sistem. Kelas ini memiliki empat atribut data (ID, Hewan, Jumlah, dan Kandang) yang mewakili informasi tentang hewan. Setiap atribut memiliki metode getter (getNamaAtribut) dan setter (setNamaAtribut) yang memungkinkan akses dan modifikasi nilai-nilai atribut tersebut. Dengan menggunakan kelas ini, Anda dapat membuat objek yang menyimpan informasi tentang hewan, seperti ID, jenis hewan, jumlah, dan kandang tempat hewan tersebut berada.





![4](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/f4827c7f-e98a-4662-9c04-791f3d6ae5e9)




![5](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/b8ad6892-291b-4e25-a6be-19ca5ba306c8)








Kode ini adalah definisi dari kelas Java bernama modelKaryawan yang digunakan untuk merepresentasikan objek data terkait karyawan dalam suatu sistem. Kelas ini memiliki lima atribut data (ID_karyawan, nama_Karyawan, jabatan, umur, dan jenis_Kelamin) yang mewakili informasi tentang karyawan. Setiap atribut memiliki metode getter (getNamaAtribut) dan setter (setNamaAtribut) yang memungkinkan akses dan modifikasi nilai-nilai atribut tersebut. Dengan menggunakan kelas ini, Anda dapat membuat objek yang menyimpan informasi tentang karyawan, seperti ID karyawan, nama, jabatan, umur, dan jenis kelamin.








![6](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/97344472-7793-41fd-9dc8-bc28e7b842a6)



Kode ini adalah definisi dari kelas Java bernama `modelPengurus` yang digunakan untuk merepresentasikan hubungan antara hewan dan karyawan dalam suatu sistem. Kelas ini memiliki dua atribut data (Nama_Hewan dan nama_karyawan) yang mewakili hubungan atau asosiasi antara nama hewan dan nama karyawan. Setiap atribut memiliki metode getter (getNamaAtribut) dan setter (setNamaAtribut) yang memungkinkan akses dan modifikasi nilai-nilai atribut tersebut. Dengan menggunakan kelas ini, Anda dapat membuat objek yang menyimpan informasi tentang pengurus yang merawat atau mengelola hubungan antara hewan dan karyawan, khususnya dalam hal penugasan atau perawatan hewan oleh karyawan tertentu.










![WhatsApp Image 2023-11-04 at 03 01 34_1f24aeb9](https://github.com/muhammadFandi12/PA_PBO/assets/127529693/114ba4ae-957e-4087-b73b-3d503cd9af27)

Kode ini adalah definisi dari sebuah antarmuka (interface) Java bernama implementHewan. Antarmuka ini berisi deklarasi beberapa metode yang akan diimplementasikan oleh kelas-kelas lain yang ingin berinteraksi dengan objek-objek modelHewan. Antarmuka ini mendefinisikan lima metode:

insert(modelHewan b): Metode ini digunakan untuk menyisipkan (insert) objek modelHewan ke dalam suatu sistem atau database.

update(modelHewan b): Metode ini digunakan untuk memperbarui (update) objek modelHewan dalam sistem atau database.

delete(int ID): Metode ini digunakan untuk menghapus (delete) objek modelHewan berdasarkan ID tertentu.

getALL(): Metode ini mengembalikan daftar semua objek modelHewan yang ada dalam sistem.

getCariHewan(String Hewan): Metode ini digunakan untuk mencari objek-objek modelHewan berdasarkan nama hewan tertentu (parameter "Hewan") dan mengembalikan daftar objek yang sesuai.














packages crud 

Kode ini adalah implementasi dari sebuah kelas Java bernama `Hewan` yang mengimplementasikan antarmuka `implementHewan`. Kelas ini digunakan untuk melakukan operasi CRUD (Create, Read, Update, Delete) pada entitas hewan dalam database. Berikut penjelasan singkatnya:

1. Kelas `Hewan` menghubungkan ke database menggunakan objek `Connection` yang diinisialisasi dengan koneksi dari kelas `Database`.

2. Kelas ini mendefinisikan beberapa pernyataan SQL (SQL statements) untuk operasi CRUD yang melibatkan tabel "hewan" dalam database.

3. Metode `insert(modelHewan b)` digunakan untuk menyisipkan data hewan baru ke dalam database. Ini menggunakan objek `PreparedStatement` untuk mempersiapkan pernyataan SQL dan mengembalikan ID yang dihasilkan untuk hewan yang baru disisipkan.

4. Metode `update(modelHewan b)` digunakan untuk memperbarui data hewan dalam database. Ini mengambil objek `modelHewan` dan memperbarui data yang sesuai dalam tabel "hewan" berdasarkan ID.

5. Metode `delete(int ID)` digunakan untuk menghapus data hewan dari database berdasarkan ID yang diberikan.

6. Metode `getCariHewan(String Hewan)` digunakan untuk mencari data hewan berdasarkan nama hewan (dengan menggunakan SQL LIKE). Hasil pencarian akan dikembalikan dalam bentuk daftar objek `modelHewan`.

7. Metode `getALL()` digunakan untuk mendapatkan semua data hewan dari database dalam bentuk daftar objek `modelHewan`.

Kelas ini memberikan implementasi konkret untuk operasi-operasi yang didefinisikan dalam antarmuka `implementHewan`, sehingga dapat digunakan untuk berinteraksi dengan dan mengelola data hewan dalam database.








contrroler hewan
Ini adalah kode Java untuk sebuah kelas controllerHewan yang mengendalikan aplikasi terkait entitas "Hewan." Kode ini digunakan dalam suatu aplikasi berbasis Java Swing untuk mengelola data hewan. Berikut adalah ringkasan dari kode tersebut:

1. Import paket-paket yang diperlukan.
2. Deklarasi variabel-variabel kelas, seperti frameMenu (kelas Menu_Hewan), ImplemetHewan (implementHewan), dan listHewan (List<modelHewan>).
3. Konstruktor kelas controllerHewan untuk menginisialisasi variabel-variabel.
4. Metode reset() untuk mengosongkan input teks pada form.
5. Metode isiTable() untuk mengisi tabel dengan data hewan dari database.
6. Metode isiField(int row) untuk mengisi input teks dengan data hewan yang dipilih dari tabel.
7. Metode insert() untuk menyimpan data hewan baru ke database setelah memeriksa validitas input.
8. Metode update() untuk mengupdate data hewan yang ada di database.
9. Metode delete() untuk menghapus data hewan dari database.
10. Metode isiTabelCariNama() dan cariNama() untuk mencari data hewan berdasarkan nama.
11. Kode ini berhubungan dengan antarmuka pengguna Swing (GUI) yang mungkin digunakan untuk mengelola data hewan, seperti menambah, mengubah, atau menghapus entri.



















































