/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteData extends Connect {
    public void deleteData() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            try {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT COUNT(*) AS total FROM komik");
                rs.next();
                if (rs.getInt("total") == 0) {
                    System.out.println("Belum ada data, kamu harus insert dulu.");
                    break;
                }

                System.out.print("Masukkan ID yang mau dihapus: ");
                int id = sc.nextInt();
                sc.nextLine();

                String sql = "DELETE FROM toko_komik_jadoel WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setInt(1, id);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Data berhasil dihapus!");
                } else {
                    System.out.println("ID tidak ditemukan.");
                }
            } catch (Exception e) {
                System.out.println("Gagal delete: " + e.getMessage());
            }

            System.out.print("Mau delete lagi? (y/n): ");
            String lagi = sc.nextLine();
            if (lagi.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
