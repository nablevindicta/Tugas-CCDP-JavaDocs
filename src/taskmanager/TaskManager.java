package taskmanager;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Kelas yang bertanggung jawab mengelola kumpulan tugas.
 * <p>
 * Menyediakan operasi untuk menambah, menghapus, mencari, dan menampilkan tugas.
 */
public class TaskManager {

    /**
     * Daftar semua tugas yang dikelola.
     */
    private final List<Task> tasks = new ArrayList<>();

    /**
     * Menambahkan tugas baru ke dalam daftar.
     *
     * @param task objek tugas yang akan ditambahkan, tidak boleh null
     * @throws IllegalArgumentException jika task bernilai null
     */
    public void addTask(Task task) {
        if (task == null) {
            throw new IllegalArgumentException("Task tidak boleh null.");
        }
        tasks.add(task);
    }

    /**
     * Menghapus tugas berdasarkan ID.
     *
     * @param id ID tugas yang akan dihapus
     * @return {@code true} jika tugas ditemukan dan dihapus, {@code false} jika tidak ditemukan
     */
    public boolean removeTaskById(int id) {
        return tasks.removeIf(task -> task.getId() == id);
    }

    /**
     * Mencari tugas berdasarkan ID.
     *
     * @param id ID tugas yang dicari
     * @return objek {@link Task} jika ditemukan
     * @throws TaskNotFoundException jika tugas dengan ID tersebut tidak ditemukan
     */
    public Task findTaskById(int id) throws TaskNotFoundException {
        for (Task task : tasks) {
            if (task.getId() == id) {
                return task;
            }
        }
        throw new TaskNotFoundException("Tugas dengan ID " + id + " tidak ditemukan.");
    }

    /**
     * Mengembalikan daftar semua tugas yang ada.
     * <p>
     * List yang dikembalikan tidak dapat dimodifikasi dari luar.
     *
     * @return list tidak dapat diubah berisi semua tugas
     */
    public List<Task> getAllTasks() {
        return Collections.unmodifiableList(tasks);
    }

    /**
     * Mengembalikan daftar tugas yang belum selesai.
     *
     * @return list tidak dapat diubah berisi tugas yang belum selesai
     */
    public List<Task> getPendingTasks() {
        List<Task> pending = new ArrayList<>();
        for (Task task : tasks) {
            if (!task.isCompleted()) {
                pending.add(task);
            }
        }
        return Collections.unmodifiableList(pending);
    }

    /**
     * Mengembalikan daftar tugas yang sudah selesai.
     *
     * @return list tidak dapat diubah berisi tugas yang sudah selesai
     */
    public List<Task> getCompletedTasks() {
        List<Task> done = new ArrayList<>();
        for (Task task : tasks) {
            if (task.isCompleted()) {
                done.add(task);
            }
        }
        return Collections.unmodifiableList(done);
    }

    /**
     * Menandai tugas tertentu sebagai selesai berdasarkan ID.
     *
     * @param id ID tugas yang akan ditandai selesai
     * @throws TaskNotFoundException jika tugas dengan ID tersebut tidak ditemukan
     */
    public void completeTask(int id) throws TaskNotFoundException {
        Task task = findTaskById(id);
        task.markAsCompleted();
    }
}
