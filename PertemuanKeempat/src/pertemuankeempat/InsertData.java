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
import java.util.Scanner;

public class InsertData extends Connect {
    public void insertData() {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            try {
                System.out.print("Masukkan judul   : ");
                String judul = sc.nextLine();
                System.out.print("Masukkan pengarang : ");
                String pengarang = sc.nextLine();
                System.out.print("Masukkan tahun terbit : ");
                int tahun = sc.nextInt();
                sc.nextLine();
                System.out.print("Masukkan genre   : ");
                String genre = sc.nextLine();

                String sql = "INSERT INTO toko_komik_jadoel (judul, pengarang, tahun, genre) VALUES (?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, judul);
                ps.setString(2, pengarang);
                ps.setInt(3, tahun);
                ps.setString(4, genre);
                ps.executeUpdate();

                System.out.println("Data berhasil ditambahkan!");
            } catch (Exception e) {
                System.out.println("Gagal insert: " + e.getMessage());
            }

            System.out.print("Mau insert lagi? (y/n): ");
            String lagi = sc.nextLine();
            if (lagi.equalsIgnoreCase("n")) {
                break;
            }
        }
    }
}
