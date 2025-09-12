/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */
// DROP TABLE
import java.sql.Statement;

public class DropTable extends Connect {

    public void dropTable() {
        try (Statement stmt = conn.createStatement()) {
            String sql = "DROP TABLE IF EXISTS toko_komik_jadoel";
            stmt.executeUpdate(sql);
            System.out.println("Tabel berhasil dihapus.");
        } catch (Exception e) {
            System.out.println("Error drop: " + e.getMessage());
        }
    }
}
