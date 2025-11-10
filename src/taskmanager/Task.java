package taskmanager;

import java.time.LocalDate;

/**
 * Representasi satu tugas dalam sistem manajemen tugas.
 * <p>
 * Setiap tugas memiliki id unik, judul, deskripsi, tanggal jatuh tempo,
 * prioritas, dan status apakah sudah selesai atau belum.
 */
public class Task {

    /**
     * ID unik untuk tugas.
     */
    private final int id;

    /**
     * Judul singkat tugas.
     */
    private String title;

    /**
     * Deskripsi detail tugas.
     */
    private String description;

    /**
     * Tanggal jatuh tempo tugas.
     */
    private LocalDate dueDate;

    /**
     * Prioritas dari tugas.
     */
    private TaskPriority priority;

    /**
     * Menandakan apakah tugas sudah selesai.
     */
    private boolean completed;

    /**
     * Membuat instance tugas baru.
     *
     * @param id          ID unik tugas
     * @param title       judul tugas, tidak boleh null atau kosong
     * @param description deskripsi tugas, boleh null
     * @param dueDate     tanggal jatuh tempo, boleh null jika tidak ditentukan
     * @param priority    prioritas tugas, tidak boleh null
     * @throws IllegalArgumentException jika judul kosong atau null, atau priority null
     */
    public Task(int id,
                String title,
                String description,
                LocalDate dueDate,
                TaskPriority priority) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tugas tidak boleh kosong.");
        }
        if (priority == null) {
            throw new IllegalArgumentException("Prioritas tugas tidak boleh null.");
        }
        this.id = id;
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = priority;
        this.completed = false;
    }

    /**
     * Mengembalikan ID unik tugas.
     *
     * @return ID tugas
     */
    public int getId() {
        return id;
    }

    /**
     * Mengembalikan judul tugas.
     *
     * @return judul tugas
     */
    public String getTitle() {
        return title;
    }

    /**
     * Mengubah judul tugas.
     *
     * @param title judul baru, tidak boleh null atau kosong
     * @throws IllegalArgumentException jika judul kosong atau null
     */
    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Judul tugas tidak boleh kosong.");
        }
        this.title = title;
    }

    /**
     * Mengembalikan deskripsi tugas.
     *
     * @return deskripsi tugas, bisa null
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mengubah deskripsi tugas.
     *
     * @param description deskripsi baru, boleh null
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Mengembalikan tanggal jatuh tempo tugas.
     *
     * @return tanggal jatuh tempo, bisa null jika tidak diset
     */
    public LocalDate getDueDate() {
        return dueDate;
    }

    /**
     * Mengubah tanggal jatuh tempo tugas.
     *
     * @param dueDate tanggal jatuh tempo baru, boleh null
     */
    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    /**
     * Mengembalikan prioritas tugas.
     *
     * @return prioritas tugas
     */
    public TaskPriority getPriority() {
        return priority;
    }

    /**
     * Mengubah prioritas tugas.
     *
     * @param priority prioritas baru, tidak boleh null
     * @throws IllegalArgumentException jika priority null
     */
    public void setPriority(TaskPriority priority) {
        if (priority == null) {
            throw new IllegalArgumentException("Prioritas tugas tidak boleh null.");
        }
        this.priority = priority;
    }

    /**
     * Mengecek apakah tugas sudah selesai.
     *
     * @return {@code true} jika tugas selesai, {@code false} jika belum
     */
    public boolean isCompleted() {
        return completed;
    }

    /**
     * Menandai tugas sebagai selesai.
     */
    public void markAsCompleted() {
        this.completed = true;
    }

    /**
     * Menandai tugas sebagai belum selesai.
     */
    public void markAsNotCompleted() {
        this.completed = false;
    }

    /**
     * Mengembalikan representasi tugas dalam bentuk string yang mudah dibaca.
     *
     * @return string berisi informasi singkat tentang tugas
     */
    @Override
    public String toString() {
        return "Task{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dueDate=" + dueDate +
                ", priority=" + priority +
                ", completed=" + completed +
                '}';
    }
}
