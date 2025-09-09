/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */
import java.sql.ResultSet;
import java.sql.Statement;

public class ReadData extends Connect {

    public void readData() {
        try (Statement stmt = conn.createStatement()) {
            String sql = "SELECT * FROM komik ORDER BY id";
            ResultSet rs = stmt.executeQuery(sql);

            System.out.printf("%-5s %-20s %-20s %-6s %-15s%n",
                    "ID", "Judul", "Pengarang", "Tahun", "Genre");
            System.out.println("------------------------------------------------------------------");

            boolean adaData = false;
            while (rs.next()) {
                adaData = true;
                System.out.printf("%-5d %-20s %-20s %-6d %-15s%n",
                        rs.getInt("id"),
                        rs.getString("judul"),
                        rs.getString("pengarang"),
                        rs.getInt("tahun"),
                        rs.getString("genre"));
            }
            if (!adaData) {
                System.out.println("Belum ada data di tabel.");
            }
        } catch (Exception e) {
            System.out.println("Error read: " + e.getMessage());
        }
    }
}
