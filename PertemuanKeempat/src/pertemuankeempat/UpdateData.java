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

    private Scanner input = new Scanner(System.in);

    public void updateData() {
        try {
            // cek dulu apakah ada data
            String cekSql = "SELECT COUNT(*) FROM komik";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cekSql);
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Belum ada data, silakan insert dulu.");
                return;
            }

            System.out.print("Masukkan ID yang mau diupdate: ");
            int id = Integer.parseInt(input.nextLine());

            System.out.print("Judul baru: ");
            String judul = input.nextLine();
            System.out.print("Pengarang baru: ");
            String pengarang = input.nextLine();
            System.out.print("Tahun baru: ");
            int tahun = Integer.parseInt(input.nextLine());
            System.out.print("Genre baru: ");
            String genre = input.nextLine();

            String sql = "UPDATE komik SET judul=?, pengarang=?, tahun=?, genre=? WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, judul);
            pstmt.setString(2, pengarang);
            pstmt.setInt(3, tahun);
            pstmt.setString(4, genre);
            pstmt.setInt(5, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil diupdate!");
            } else {
                System.out.println("ID tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error update: " + e.getMessage());
        }
    }
}
