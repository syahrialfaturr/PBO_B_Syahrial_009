// Kelas Hewan
public class Hewan {
    // Atribut untuk menyimpan informasi  tentang hewan
    String nama; // Menyimpan nama hewan
    String suara; // Menyimpan suara hewan
    String jenis; // Menyimpan jenis hewan

    // Konstruktor untuk menginisialisasi objek hewan
    public Hewan(String nama, String suara, String jenis){
        this.nama = nama; // Menetapkan nilai parameter nama ke atribut nama
        this.suara = suara; // Menetapkan nilai parameter suara ke atribut suara
        this.jenis = jenis; // Menetapkan nilai parameter jenis ke atribut jenis
    }
   // Method untuk menampilkan informasi hewan
    void infoHewan(){
        System.out.println("Nama: " + nama); // Menampilkan nama hewan
        System.out.println("Suara: " + suara); // Menampilkan suara hewan
        System.out.println("Jenis: " + jenis); // Menampilkan jenis hewan
    }
}