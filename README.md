# Laporan Praktikum Pemrograman Berorientasi Objek  
Pertemuan Keempat  
Nama: Husain Asrarillah  
Mata Kuliah: Pemrograman Berorientasi Objek  
Dosen Pengampu: Bapak Bayu Adhi Nugroho, Ph.D  

---

## Deskripsi
Pada praktikum ini dibuat sebuah aplikasi sederhana berbasis Java dan PostgreSQL untuk mengimplementasikan konsep OOP melalui operasi CRUD (Create, Read, Update, Delete) pada sebuah tabel database.  

Program dijalankan secara interaktif di console, sehingga pengguna dapat memilih menu (Create Table, Insert Data, Update Data, Delete Data, Read Data, Drop Table) menggunakan input dari keyboard.  

---

## Struktur Project
Project terdiri dari beberapa class dengan pembagian sebagai berikut:

- **Connect.java**  
  Kelas utama untuk melakukan koneksi ke database.  
  Menggunakan constructor untuk inisialisasi objek Connection.  
  Atribut `conn` dibuat `protected` agar bisa diakses oleh class turunan.  

- **CreateTable.java**  
  `extends Connect` untuk membuat tabel di database.  
  Menggunakan Statement untuk menjalankan perintah `CREATE TABLE`.  

- **InsertData.java**  
  `extends Connect` untuk menambahkan data ke tabel.  
  Menggunakan PreparedStatement agar query lebih aman.  
  Setelah insert, pengguna ditanya apakah ingin menginsert lagi (y/n) hingga maksimal 10 kali.  

- **ReadData.java**  
  `extends Connect` untuk membaca data dari tabel.  
  Menggunakan ResultSet untuk menampilkan hasil query.  

- **UpdateData.java**  
  `extends Connect` untuk mengubah data berdasarkan ID.  
  Setelah update, pengguna ditanya apakah ingin update lagi (y/n).  

- **DeleteData.java**  
  `extends Connect` untuk menghapus data berdasarkan ID.  
  Jika tabel kosong, program menampilkan pesan: "Belum ada data, kamu harus insert dulu".  

- **DropTable.java**  
  `extends Connect` untuk menghapus tabel dari database.  

- **MenuInteraktif.java**  
  Kelas dengan method `main()`.  
  Menampilkan menu CRUD interaktif menggunakan Scanner.  
  Memanggil method CRUD sesuai pilihan pengguna.  

---

## Konsep OOP yang Diterapkan
1. **Inheritance (Pewarisan)**  
   Semua class CRUD mewarisi koneksi dari class `Connect` dengan `extends Connect`.  

2. **Encapsulation (Enkapsulasi)**  
   Atribut `conn` dibuat `protected`, sehingga hanya bisa diakses oleh class turunan.  

3. **Polymorphism**  
   Beberapa method CRUD memiliki pola pemanggilan yang sama tetapi dengan perilaku berbeda, misalnya `insertData`, `updateData`, `deleteData`.  

4. **Abstraction (Abstraksi)**  
   Detail teknis koneksi database disembunyikan dalam class `Connect`. Class CRUD cukup menggunakan `conn` tanpa harus mengetahui detail koneksi.  

---

## Fitur Interaktif
- Menu CRUD dapat dipilih pengguna dengan input angka.  
- Setelah operasi Insert, Update, atau Delete, pengguna ditanya:  
  ```
  Mau insert lagi? (y/n):
  ```  
  Jika `y` maka operasi diulang, jika `n` kembali ke menu utama.  
- Maksimal pengulangan adalah 10 kali untuk mencegah loop tak terbatas.  

---

## Cara Menjalankan
1. Buat database PostgreSQL, misalnya dengan nama `dbku`.  
2. Sesuaikan konfigurasi `url`, `user`, dan `password` di file `Connect.java`.  
3. Jalankan program melalui `MenuInteraktif.java`.  
4. Pilih menu sesuai kebutuhan melalui console.  

---
