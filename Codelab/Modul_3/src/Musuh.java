// Kelas Musuh merupakan turunan dari KarakterGame (Menggunakan Inheritance)
class Musuh extends KarakterGame {
    // Constructor yang menggunakan kata kunci "super" untuk memanggil constructor parent
    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan); //Memanggil constructor dari parent class (KarakterGame)
    }

    // Override metode serang agar Musuh menyerang dengan sihir
    @Override
    public void serang(KarakterGame target){
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan sihir!"); // Menampilkan teks serangan musuh
        target.setKesehatan(target.getKesehatan() - 15); // Mengurangi kesehatan target sebanyak 15
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());  // Menampilkan status kesehatan target setelah diserang
    }
}
