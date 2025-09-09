Laporan Praktikum Pertemuan Keempat
Mata Kuliah: Pemrograman Berorientasi Objek
Nama: Husain Asrarillah
Dosen: Bapak Bayu Adhi Nugroho, Ph.D.

📌 Tujuan Praktikum
Menghubungkan Java (NetBeans) dengan PostgreSQL.

Membuat program CRUD (Create, Read, Update, Delete) dengan konsep OOP dan inheritance (extends).

Membiasakan penggunaan JDBC (Java Database Connectivity) untuk operasi database.

Membuat aplikasi interaktif dengan menu berbasis console.

📂 Struktur Project
pertemuankeempat
├── Connect.java        # Class dasar untuk koneksi database
├── CreateTable.java    # Membuat tabel "komik"
├── InsertData.java     # Menambahkan data baru
├── ReadData.java       # Menampilkan data (dengan format tabel rapi)
├── UpdateData.java     # Mengubah data berdasarkan ID
├── DeleteData.java     # Menghapus data berdasarkan ID
├── DropTable.java      # Menghapus tabel (opsional)
└── MainApp.java        # Menu interaktif, pemanggil semua class CRUD
📖 Penjelasan Tiap Class
1. Connect.java
Mengatur koneksi ke PostgreSQL menggunakan:

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
Connection digunakan di semua class turunan.

Jika koneksi berhasil → tampil pesan "Koneksi berhasil!".

2. CreateTable.java
Membuat tabel komik jika belum ada.

Menggunakan Statement karena query tanpa parameter.

3. InsertData.java
Input data komik dari user (judul, pengarang, tahun, genre).

Menggunakan:

Scanner → ambil input user.

PreparedStatement → eksekusi query INSERT dengan parameter ?.

4. ReadData.java
Menampilkan semua data dari tabel komik.

Menggunakan:

Statement → eksekusi query SELECT.

ResultSet → membaca hasil query.

Data ditampilkan dalam format tabel rapi dengan printf.

5. UpdateData.java
Mengubah data berdasarkan ID.

Sebelum update, dicek dulu apakah tabel kosong (SELECT COUNT(*)).

Menggunakan:

Scanner → ambil input dari user.

Statement + ResultSet → cek jumlah data.

PreparedStatement → query UPDATE ... WHERE id=?.

6. DeleteData.java
Menghapus data berdasarkan ID.

Jika tabel kosong, tampil pesan "Belum ada data, kamu harus insert dulu."

Menggunakan kombinasi Scanner, Statement, ResultSet, dan PreparedStatement.

7. DropTable.java
Menghapus tabel komik dari database.

Menggunakan Statement karena query sederhana tanpa parameter.

8. MainApp.java
Menyediakan menu interaktif dengan pilihan:

1. Create Table
2. Insert Data
3. Read Data
4. Update Data
5. Delete Data
6. Drop Table
0. Exit
Menggunakan Scanner untuk input pilihan menu.

Setiap menu memanggil class CRUD terkait.

🔑 Ringkasan Import per Class
Class	Import Digunakan	Kegunaan
Connect	Connection, DriverManager, SQLException	Membuat dan mengatur koneksi DB
CreateTable	Statement	Eksekusi query CREATE TABLE
InsertData	PreparedStatement, Scanner	Input user & eksekusi query INSERT
ReadData	Statement, ResultSet	Eksekusi SELECT dan baca hasilnya
UpdateData	PreparedStatement, Statement, ResultSet, Scanner	Cek data, input user, eksekusi UPDATE
DeleteData	PreparedStatement, Statement, ResultSet, Scanner	Cek data, input user, eksekusi DELETE
DropTable	Statement	Eksekusi query DROP TABLE
MainApp	Scanner	Input menu interaktif
📝 Kesimpulan
Dengan OOP, setiap operasi CRUD bisa dipisahkan ke class masing-masing.

Connect menjadi class dasar yang di-extends oleh class CRUD lain.

Penggunaan Statement, PreparedStatement, dan ResultSet dibedakan sesuai kebutuhan query.

Aplikasi bisa berjalan interaktif di console dengan menu pilihan.

✍️ Disusun oleh:
Husain Asrarillah
Mata Kuliah Pemrograman Berorientasi Objek
Dosen: Bapak Bayu Adhi Nugroho, Ph.D.
