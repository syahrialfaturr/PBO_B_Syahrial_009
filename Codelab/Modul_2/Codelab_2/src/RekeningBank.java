public class RekeningBank {
    String nomorRekening;
    String namaPemilik;
    double saldo;

    void tampilkanInfo() {
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama pemilik: " + namaPemilik);
        System.out.println("Saldo: " + saldo);
    }

        void setorUang (double jumlah){
            if (jumlah > 0) {
                saldo += jumlah;
                System.out.println(namaPemilik + "menyetor Rp" + jumlah + ". Saldo sekarang: Rp " + saldo);
            } else {
                System.out.println("Jumlah setor uang harus lebih dari 0!");
            }
        }

        void tarikUang(double jumlah){
        if (jumlah > 0 && saldo >= jumlah){
            saldo -= jumlah;
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Berhasil) Saldo sekarang: Rp" + saldo);
        } else {
            System.out.println(namaPemilik + " menarik Rp" + jumlah + ". (Gagal, saldo tidak mencukupi) Saldo saat ini: Rp" + saldo);
        }
        }
}
