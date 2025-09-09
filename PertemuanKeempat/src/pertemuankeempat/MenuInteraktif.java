/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Husain
 */
import java.util.Scanner;

public class MenuInteraktif {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\n=== MENU CRUD KOMIK ===");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Read Data");
            System.out.println("4. Update Data");
            System.out.println("5. Delete Data");
            System.out.println("0. Exit");
            System.out.print("Pilih menu: ");
            String choice = input.nextLine();

            switch (choice) {
                case "1":
                    new CreateTable().createTable();
                    break;
                case "2":
                    new InsertData().insertData();
                    break;
                case "3":
                    new ReadData().readData();
                    break;
                case "4":
                    new UpdateData().updateData();
                    break;
                case "5":
                    new DeleteData().deleteData();
                    break;
                case "0":
                    System.out.println("Keluar...");
                    return;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }
    }
}
