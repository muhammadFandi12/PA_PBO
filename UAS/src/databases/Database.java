
package databases;
import java.sql.*;
/**
 *
 * @author NITRO 5
 */
public class Database {
    private static Connection mysqlconfig; 
    public static Connection configDB(){
        try {
            String url = "jdbc:mysql://localhost:3306/peternakan";
            String user = "root";
            String password = ""; 
            mysqlconfig = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            System.err.println("Koneksi gagal"+e.getMessage());
        }
        return mysqlconfig;
    }
}    

