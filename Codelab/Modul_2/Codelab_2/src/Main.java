// Kelas main untuk menjalankan program
public class Main {
    public static void  main(String[] args) {
        // Membuat objek rekening dengan menggunakan konstruktor
        RekeningBank rekening1 = new RekeningBank("202410370110009", "Syahrial Nur Faturrahman", 1000000);
        RekeningBank rekening2 = new RekeningBank("202410370110017", "Farid Al Farizi", 500000);

        // Menampilkan informasi awal rekening
        rekening1.infoRekening();
        rekening2.infoRekening();

        //Melakukan transaksi setoran
        rekening1.setorUang(500000); // Syahrial setor uang Rp500.000
        rekening2.setorUang(200000); // Farid setor uang Rp200.000

        // Melakukan transaksi penarikan
        rekening1.tarikUang(500000); // Syahrial menarik Rp500.000
        rekening2.tarikUang(800000); // Farid menarik Rp800.000 (saldo tidak cukup)

        //Menampilkan informasi rekening setelah transaksi
        rekening1.infoRekening();
        rekening2.infoRekening();
    }
}
