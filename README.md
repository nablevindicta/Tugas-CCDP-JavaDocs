# Manajemen Tugas – Proyek Java dengan JavaDocs

Proyek ini adalah aplikasi sederhana **manajemen tugas (task manager)** berbasis Java yang didokumentasikan menggunakan **JavaDocs**.  

---

## 1. Teknologi yang Digunakan

- **Bahasa**: Java
- **Minimal Versi**: Java 8 (contoh di sini menggunakan JDK 8+ / JDK 24)
- **IDE yang disarankan**:
  - IntelliJ IDEA  
- **Tool dokumentasi**: `javadoc` (bawaan JDK)

---

## 2. Struktur Proyek

Contoh struktur folder proyek:

```text
Manajemen-Project-javadocs/
├─ src/
│  └─ taskmanager/
│     ├─ TaskPriority.java
│     ├─ Task.java
│     ├─ TaskNotFoundException.java
│     ├─ TaskManager.java
│     └─ Main.java
├─ docs/              (hasil generate JavaDocs, berisi HTML)
└─ README.md
```

---

## 3. Deskripsi Kelas Utama

### `TaskPriority`

Enum yang merepresentasikan tingkat prioritas tugas:

- `LOW`
- `MEDIUM`
- `HIGH`

### `Task`

Mewakili satu tugas, dengan atribut utama:

- `id` – ID unik untuk setiap tugas
- `title` – judul tugas
- `description` – deskripsi tugas
- `dueDate` – tanggal jatuh tempo (`LocalDate`)
- `priority` – prioritas tugas (`TaskPriority`)
- `completed` – status apakah tugas sudah selesai atau belum

### `TaskManager`

Kelas yang mengelola kumpulan tugas, dengan fungsi:

- `addTask(Task task)` – menambahkan tugas baru ke daftar
- `removeTaskById(int id)` – menghapus tugas berdasarkan ID
- `findTaskById(int id)` – mencari tugas berdasarkan ID
- `completeTask(int id)` – menandai tugas sebagai selesai
- `getAllTasks()` – mengembalikan semua tugas
- `getPendingTasks()` – mengembalikan tugas yang belum selesai
- `getCompletedTasks()` – mengembalikan tugas yang sudah selesai

### `TaskNotFoundException`

Exception khusus yang digunakan untuk menandai bahwa tugas dengan ID tertentu tidak ditemukan saat dicari melalui `TaskManager`.

### `Main`

Kelas utama yang berisi method `main`, berfungsi sebagai titik masuk program.  
Di dalamnya terdapat contoh:

- Pembuatan objek `Task`
- Penambahan tugas ke `TaskManager`
- Menandai tugas sebagai selesai
- Menampilkan daftar tugas di console

---

## 4. Cara Menjalankan Proyek

### 4.1. Menjalankan di IntelliJ IDEA

1. Buka proyek di **IntelliJ IDEA**.
2. Pastikan JDK sudah diset di **Project SDK**.
3. Di panel **Project**, buka `src/taskmanager/Main.java`.
4. Klik ikon ▶ di sebelah method `main`, atau:
   - Klik kanan pada `Main.java` → **Run 'Main.main()'**.
5. Contoh output yang diharapkan:

   ```text
   == Semua Tugas ==
   Task{id=1, title='Belajar JavaDocs', dueDate=..., priority=HIGH, completed=false}
   Task{id=2, title='Refactor Kode', dueDate=..., priority=MEDIUM, completed=false}

   == Tugas Selesai ==
   Task{id=1, title='Belajar JavaDocs', dueDate=..., priority=HIGH, completed=true}

   == Tugas Belum Selesai ==
   Task{id=2, title='Refactor Kode', dueDate=..., priority=MEDIUM, completed=false}
