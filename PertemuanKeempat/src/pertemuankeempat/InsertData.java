package pertemuankeempat;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertData extends Connect {
    public void insertData() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (count < 10) {
            try {
                System.out.print("Masukkan judul   : ");
                String judul = scanner.nextLine();
                System.out.print("Masukkan pengarang : ");
                String pengarang = scanner.nextLine();
                System.out.print("Masukkan tahun terbit : ");
                int tahunTerbit = Integer.parseInt(scanner.nextLine());
                System.out.print("Masukkan genre   : ");
                String genre = scanner.nextLine();

                String sql = "INSERT INTO toko_komik_jadoel(judul, pengarang, tahun, genre) VALUES (?, ?, ?, ?)";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, judul);
                pstmt.setString(2, pengarang);
                pstmt.setInt(3, tahunTerbit);
                pstmt.setString(4, genre);

                pstmt.executeUpdate();
                System.out.println("Data berhasil ditambahkan!");

            } catch (SQLException e) {
                System.out.println("Gagal insert: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input tahun terbit harus berupa angka!");
            }

            count++;
            if (count >= 10) {
                System.out.println("Batas maksimum percobaan insert (10 kali) telah tercapai.");
                break;
            }

            System.out.print("Mau insert lagi? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                continue;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Sesi insert selesai. Silakan kembali ke menu utama.");
                break;
            } else {
                System.out.println("Input tidak valid, kembali ke menu utama.");
                break;
            }
        }
    }
}
