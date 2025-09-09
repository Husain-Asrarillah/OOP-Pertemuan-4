# Laporan Praktikum Pertemuan Keempat  
**Mata Kuliah:** Pemrograman Berorientasi Objek  
**Nama:** Husain Asrarillah  
**Dosen:** Bapak Bayu Adhi Nugroho, Ph.D.  

---

## 📌 Tujuan Praktikum
1. Menghubungkan Java (NetBeans) dengan PostgreSQL menggunakan JDBC.  
2. Mengimplementasikan operasi **CRUD** (Create, Read, Update, Delete) dalam program Java.  
3. Menerapkan konsep **Object-Oriented Programming (OOP)** dengan pewarisan (`extends`).  
4. Membuat aplikasi interaktif berbasis console dengan menu pilihan.  

---

## 📂 Struktur Project
```
pertemuankeempat
├── Connect.java        # Koneksi database (class induk)
├── CreateTable.java    # Membuat tabel "komik"
├── InsertData.java     # Menambahkan data baru
├── ReadData.java       # Menampilkan data dalam format tabel rapi
├── UpdateData.java     # Mengubah data berdasarkan ID
├── DeleteData.java     # Menghapus data berdasarkan ID
└── MainApp.java        # Menu interaktif sebagai pengendali program
```

---

## 📖 Penjelasan Program
- **Connect.java** → class dasar yang mengatur koneksi ke PostgreSQL. Class CRUD lain melakukan `extends` ke class ini agar dapat menggunakan koneksi.  
- **CreateTable.java** → membuat tabel `komik` jika belum ada di database.  
- **InsertData.java** → menambahkan data baru (judul, pengarang, tahun, genre) yang diinput user.  
- **ReadData.java** → menampilkan data dengan format tabel rapi (`printf`) sehingga lebih mudah dibaca.  
- **UpdateData.java** → mengubah data berdasarkan ID yang dipilih user. Jika tabel kosong, akan muncul pesan peringatan.  
- **DeleteData.java** → menghapus data berdasarkan ID. Jika tabel kosong, program meminta user untuk melakukan insert terlebih dahulu.  
- **MainApp.java** → menyediakan menu interaktif agar user bisa memilih operasi CRUD.  

---

## 📋 Menu Interaktif
Saat dijalankan, program menampilkan menu:
```
===== MENU CRUD KOMIK =====
1. Create Table
2. Insert Data
3. Read Data
4. Update Data
5. Delete Data
0. Exit
Pilih menu: _
```

User dapat memilih nomor sesuai operasi yang diinginkan.  

---

## 🖥️ Contoh Output
**Insert Data**  
```
Masukkan judul   : One Piece
Masukkan pengarang : Eiichiro Oda
Masukkan tahun terbit : 1997
Masukkan genre   : Shonen
Data berhasil ditambahkan!
```

**Read Data**  
```
ID    Judul                Pengarang            Tahun   Genre     
-----------------------------------------------------------------
1     One Piece            Eiichiro Oda         1997    Shonen
2     Naruto               Masashi Kishimoto    1999    Shonen
```


---

## 📝 Kesimpulan
- Program berhasil menghubungkan Java dengan PostgreSQL.  
- Operasi CRUD berjalan dengan baik melalui menu interaktif.  
- Konsep **OOP** diterapkan dengan membagi class sesuai fungsinya, serta penggunaan `extends` untuk mewarisi koneksi database.  
- Format tampilan data dibuat lebih rapi menggunakan tabel agar mudah dibaca.  

---

✍️ **Disusun oleh:**  
**Husain Asrarillah**  
Mata Kuliah Pemrograman Berorientasi Objek  
Dosen: **Bapak Bayu Adhi Nugroho, Ph.D.**  
