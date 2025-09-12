package pertemuankeempat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateData extends Connect {
    public void updateData() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("Masukkan ID komik yang ingin diupdate: ");
                int id = Integer.parseInt(scanner.nextLine());
                System.out.print("Masukkan judul baru: ");
                String judul = scanner.nextLine();
                System.out.print("Masukkan pengarang baru: ");
                String pengarang = scanner.nextLine();
                System.out.print("Masukkan tahun terbit baru: ");
                int tahunTerbit = Integer.parseInt(scanner.nextLine());
                System.out.print("Masukkan genre baru: ");
                String genre = scanner.nextLine();

                String sql = "UPDATE toko_komik_jadoel SET judul=?, pengarang=?, tahun_terbit=?, genre=? WHERE id=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, judul);
                pstmt.setString(2, pengarang);
                pstmt.setInt(3, tahunTerbit);
                pstmt.setString(4, genre);
                pstmt.setInt(5, id);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Data berhasil diupdate!");
                } else {
                    System.out.println("Data dengan ID tersebut tidak ditemukan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal update: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input ID dan tahun terbit harus berupa angka!");
            }

            count++;
            if (count >= 10) {
                System.out.println("Batas maksimum percobaan update (10 kali) telah tercapai.");
                break;
            }

            System.out.print("Mau update lagi? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                continue;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Sesi update selesai. Silakan kembali ke menu utama.");
                break;
            } else {
                System.out.println("Input tidak valid, kembali ke menu utama.");
                break;
            }
        }
    }
}
