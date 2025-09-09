/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */
import java.sql.Statement;

public class CreateTable extends Connect {

    public void createTable() {
        try (Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS komik ("
                    + "id SERIAL PRIMARY KEY, "
                    + "judul VARCHAR(100), "
                    + "pengarang VARCHAR(100), "
                    + "tahun INT, "
                    + "genre VARCHAR(50))";
            stmt.executeUpdate(sql);
            System.out.println("Tabel berhasil dibuat.");
        } catch (Exception e) {
            System.out.println("Error create: " + e.getMessage());
        }
    }
}
