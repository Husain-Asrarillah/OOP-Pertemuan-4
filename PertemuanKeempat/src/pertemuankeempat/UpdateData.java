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

public class UpdateData extends Connect {
    public void updateData() {
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

                System.out.print("Masukkan ID yang mau diupdate: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan judul baru   : ");
                String judul = sc.nextLine();
                System.out.print("Masukkan pengarang baru : ");
                String pengarang = sc.nextLine();
                System.out.print("Masukkan tahun terbit baru : ");
                int tahun = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan genre baru   : ");
                String genre = sc.nextLine();

                String sql = "UPDATE toko_komik_jadoel SET judul=?, pengarang=?, tahun=?, genre=? WHERE id=?";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, judul);
                ps.setString(2, pengarang);
                ps.setInt(3, tahun);
                ps.setString(4, genre);
                ps.setInt(5, id);

                int rows = ps.executeUpdate();
                if (rows > 0) {
                    System.out.println("Data berhasil diupdate!");
                } else {
                    System.out.println("ID tidak ditemukan.");
                }
            } catch (Exception e) {
                System.out.println("Gagal update: " + e.getMessage());
            }

            System.out.print("Mau update lagi? (y/n): ");
            String lagi = sc.nextLine();
            if (lagi.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
