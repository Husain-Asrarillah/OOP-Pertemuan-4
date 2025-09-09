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

    private Scanner input = new Scanner(System.in);

    public void insertData() {
        try {
            System.out.print("Judul: ");
            String judul = input.nextLine();
            System.out.print("Pengarang: ");
            String pengarang = input.nextLine();
            System.out.print("Tahun: ");
            int tahun = Integer.parseInt(input.nextLine());
            System.out.print("Genre: ");
            String genre = input.nextLine();

            String sql = "INSERT INTO komik (judul, pengarang, tahun, genre) VALUES (?,?,?,?)";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, judul);
            pstmt.setString(2, pengarang);
            pstmt.setInt(3, tahun);
            pstmt.setString(4, genre);

            pstmt.executeUpdate();
            System.out.println("Data berhasil ditambahkan!");
        } catch (Exception e) {
            System.out.println("Error insert: " + e.getMessage());
        }
    }
}
