package taskmanager;

import java.time.LocalDate;

/**
 * Kelas utama untuk menjalankan contoh sederhana penggunaan {@link TaskManager}.
 */
public class Main {

    /**
     * Titik masuk program.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        TaskManager manager = new TaskManager();

        // Membuat beberapa tugas contoh
        Task task1 = new Task(1, "Belajar JavaDocs",
                "Membuat dokumentasi proyek menggunakan JavaDocs",
                LocalDate.now().plusDays(2),
                TaskPriority.HIGH);

        Task task2 = new Task(2, "Refactor Kode",
                "Merapikan struktur kode agar lebih mudah dipelihara",
                LocalDate.now().plusDays(5),
                TaskPriority.MEDIUM);

        // Menambahkan tugas ke manager
        manager.addTask(task1);
        manager.addTask(task2);

        // Menampilkan semua tugas
        System.out.println("== Semua Tugas ==");
        manager.getAllTasks().forEach(System.out::println);

        // Menandai satu tugas sebagai selesai
        try {
            manager.completeTask(1);
        } catch (TaskNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }

        // Menampilkan tugas yang sudah selesai
        System.out.println("\n== Tugas Selesai ==");
        manager.getCompletedTasks().forEach(System.out::println);

        // Menampilkan tugas yang belum selesai
        System.out.println("\n== Tugas Belum Selesai ==");
        manager.getPendingTasks().forEach(System.out::println);
    }
}
