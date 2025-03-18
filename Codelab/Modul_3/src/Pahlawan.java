// Kelas Pahlawan merupakan turunan dari KarakterGame (Menggunakan Inheritance)
class Pahlawan extends KarakterGame {
    // Constructor yang menggunakan kata kunci "super" untuk memanggil constructor parent
    public Pahlawan(String nama, int kesehatan){
        super(nama, kesehatan); //Memanggil constructor dari parent class (KarakterGame)
    }

    // Override metode serang agar Pahlawan menyerang dengan pedang
    @Override
    public void serang(KarakterGame target){
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan pedang!"); // Menampilkan teks serangan pahlawan
        target.setKesehatan(target.getKesehatan() - 20); // Mengurangi kesehatan target sebanyak 20
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan()); // Menampilkan status kesehatan target setelah diserang
    }
}
