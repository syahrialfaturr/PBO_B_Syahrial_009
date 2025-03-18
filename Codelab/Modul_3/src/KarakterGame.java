// Kelas yang digunakan sebagai dasar bagi karakter dalam game
// Menggunakan konsep Encapsulation dengan atribut private
class KarakterGame {
    private String nama; // Variabel untuk menyimpan nama karakter (menggunakan enkapsulasi private)
    private int kesehatan; // Variabel untuk menyimpan jumlah kesehatan karakter (menggunakan enkapsulasi private)

    // Constructor
    public KarakterGame(String nama, int kesehatan){
        this.nama = nama; // Inisialisasi nama karakter
        this.kesehatan = kesehatan; // Inisialisasi jumlah kesehatan karakter
    }

    // Metode (Getter) untuk mendapatkan nama karakter
    public String getNama() {
        return nama;
    }

    // Metode (Getter) untuk mendapatkan jumlah kesehatan karakter
    public int getKesehatan() {
        return kesehatan;
    }

    // Metode (Setter) untuk mengubah jumlah kesehatan karakter
    public void setKesehatan(int kesehatan){
        this.kesehatan = kesehatan;
    }

    // Metode serang yang akan diwarisi atau digunakan oleh subclass (akan di-Override)
    public void serang(KarakterGame target){
        System.out.println(nama + " menyerang " + target.getNama() + "!"); // Menampilkan teks saat karakter menyerang
    }
}
