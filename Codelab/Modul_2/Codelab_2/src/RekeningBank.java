// Kelas RekeningBank untuk menyimpan data rekening bank
public class RekeningBank {
    String nomorRekening; // Menyimpan nomor rekening
    String namaPemilik; // Menyimpan nama pemilik rekening
    double saldo; // Menyimmpan saldo rekening

    // Konstruktror untuk menginisialisasi objek RekeningBank
    public RekeningBank(String nomorRekening, String namaPemilik, double saldo){
        this.nomorRekening = nomorRekening; // Menyimpan nomor rekening yang diberikan saat pembuatan objek
        this.namaPemilik = namaPemilik; // Menyimpan nama pemilik sesuai dengan data yang dimasukkan
        this.saldo = saldo; // Mengatur saldo awal sesuai dengan jumlah yang diberikan
    }

    // Method untuk menampilkan informasi rekening
    void infoRekening() {
        System.out.println("Nomor Rekening: " + nomorRekening); // Menampilkan nomor rekening
        System.out.println("Nama pemilik: " + namaPemilik); // Menampilkan nama pemilik
        System.out.println("Saldo: " + saldo); // Menampilkan saldo
        System.out.println("-------------------------------"); // Garis pemisah agar output lebih rapi
    }

    // Method untuk menyetor uang ke rekening
        void setorUang (double jumlah){
            if (jumlah > 0) { // Memeriksa jumlah setoran lebih dari 0
                saldo += jumlah; // Menambah jumlah setoran ke saldo
                System.out.println(namaPemilik + "menyetor Rp" + jumlah + ". Saldo sekarang: Rp " + saldo); //Menampilkan jika berhasil setor uang
            } else {
                System.out.println("Jumlah setor uang harus lebih dari 0!"); // Menampilkan pesan jika jumlah tidak valid
            }
        }

        // Method untuk menarik uang dari rekening
        void tarikUang(double jumlah){
        if (jumlah > 0 && saldo >= jumlah){ // Memeriksa apakah jumlah penarikan valid dan saldo mencukupi
            saldo -= jumlah; // Mengurangi saldo dengan jumlah penarikan
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo); // Menampilkan jika berhasil menarik uang
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp" + saldo); // Menampilkan jika gagal menarik uang
        }
        }
}
