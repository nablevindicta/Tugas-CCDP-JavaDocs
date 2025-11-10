package taskmanager;

/**
 * Exception yang dilempar ketika tugas dengan ID tertentu tidak ditemukan.
 */
public class TaskNotFoundException extends Exception {

    /**
     * Membuat exception baru dengan pesan tertentu.
     *
     * @param message pesan detail tentang error
     */
    public TaskNotFoundException(String message) {
        super(message);
    }
}
