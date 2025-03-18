// Kelas utama yang menjalankan program (metode main)
public class Main {
    public static void main(String[] args) {
        KarakterGame umum = new KarakterGame("Karakter umum", 100);  // Membuat objek karakter umum dengan nama "Karakter umum" dan kesehatan 100
        Pahlawan brimstone = new Pahlawan("Brimstone", 150); // Membuat objek Pahlawan dengan nama "Brimstone" dan kesehatan 150
        Musuh viper = new Musuh("Viper", 200); // Membuat objek Musuh dengan nama "Viper" dan kesehatan 200

        System.out.println("--- Status Awal ---"); // Menampilkan status awal karakter sebelum pertarungan
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan()); // Menampilkan kesehatan pahlawan
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan()); // Menampilkan kesehatan musuh

        System.out.println("--- Pertarungan Dimulai"); // Memulai pertarungan antara Pahlawan dan Musuh
        brimstone.serang(viper); // Pahlawan menyerang musuh
        viper.serang(brimstone); // Musuh menyerang balik pahlawan
    }
}
