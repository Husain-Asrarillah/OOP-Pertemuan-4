package pertemuankeempat;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteData extends Connect {
    public void deleteData() {
        Scanner scanner = new Scanner(System.in);
        int count = 0;

        while (count < 10) {
            try {
                // cek apakah ada data dulu
                String checkSql = "SELECT COUNT(*) AS total FROM toko_komik_jadoel";
                ResultSet rs = conn.createStatement().executeQuery(checkSql);
                if (rs.next() && rs.getInt("total") == 0) {
                    System.out.println("Belum ada data. Kamu harus insert dulu.");
                    break;
                }

                System.out.print("Masukkan ID komik yang ingin dihapus: ");
                int id = Integer.parseInt(scanner.nextLine());

                String sql = "DELETE FROM toko_komik_jadoel WHERE id=?";
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, id);

                int rows = pstmt.executeUpdate();
                if (rows > 0) {
                    System.out.println("Data berhasil dihapus!");
                } else {
                    System.out.println("Data dengan ID tersebut tidak ditemukan.");
                }

            } catch (SQLException e) {
                System.out.println("Gagal delete: " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("Input ID harus berupa angka!");
            }

            count++;
            if (count >= 10) {
                System.out.println("Batas maksimum percobaan delete (10 kali) telah tercapai.");
                break;
            }

            System.out.print("Mau delete lagi? (y/n): ");
            String choice = scanner.nextLine();

            if (choice.equalsIgnoreCase("y")) {
                continue;
            } else if (choice.equalsIgnoreCase("n")) {
                System.out.println("Sesi delete selesai. Silakan kembali ke menu utama.");
                break;
            } else {
                System.out.println("Input tidak valid, kembali ke menu utama.");
                break;
            }
        }
    }
}
