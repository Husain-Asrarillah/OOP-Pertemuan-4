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
        Scanner sc = new Scanner(System.in);

        InsertData insert = new InsertData();
        UpdateData update = new UpdateData();
        DeleteData delete = new DeleteData();
        ReadData read = new ReadData();
        DropTable drop = new DropTable();
        CreateTable create = new CreateTable();

        int pilihan;

        do {
            System.out.println("\n=== MENU CRUD TOKO KOMIK JADOEL ===");
            System.out.println("1. Create Table");
            System.out.println("2. Insert Data");
            System.out.println("3. Read Data");
            System.out.println("4. Update Data");
            System.out.println("5. Delete Data");
            System.out.println("6. Drop Table");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = sc.nextInt();
            sc.nextLine(); // buang enter

            switch (pilihan) {
                case 1:
                    create.createTable();
                    break;
                case 2:
                    insert.insertData();
                    break;
                case 3:
                    read.readData();
                    break;
                case 4:
                    update.updateData();
                    break;
                case 5:
                    delete.deleteData();
                    break;
                case 6:
                    drop.dropTable();
                    break;
                case 0:
                    System.out.println("Keluar program. Bye!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 0);
    }
}
