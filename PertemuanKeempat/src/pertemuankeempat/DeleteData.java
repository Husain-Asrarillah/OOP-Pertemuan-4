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

    private Scanner input = new Scanner(System.in);

    public void deleteData() {
        try {
            String cekSql = "SELECT COUNT(*) FROM komik";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(cekSql);
            rs.next();
            if (rs.getInt(1) == 0) {
                System.out.println("Belum ada data, kamu harus insert dulu.");
                return;
            }

            System.out.print("Masukkan ID yang mau dihapus: ");
            int id = Integer.parseInt(input.nextLine());

            String sql = "DELETE FROM komik WHERE id=?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, id);

            int rows = pstmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Data berhasil dihapus!");
            } else {
                System.out.println("ID tidak ditemukan.");
            }
        } catch (Exception e) {
            System.out.println("Error delete: " + e.getMessage());
        }
    }
}
