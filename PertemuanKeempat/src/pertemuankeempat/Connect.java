/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connect {
    protected static Connection conn; // shared untuk semua class turunan

    public Connect() {
        if (conn == null) { // koneksi dibuat hanya sekali
            try {
                String url = "jdbc:postgresql://localhost:5432/KuliahPBO";
                String user = "postgres";
                String password = "170206";

                conn = DriverManager.getConnection(url, user, password);
                System.out.println("Koneksi berhasil!");
            } catch (SQLException e) {
                System.out.println("Koneksi gagal: " + e.getMessage());
            }
        }
    }
}
