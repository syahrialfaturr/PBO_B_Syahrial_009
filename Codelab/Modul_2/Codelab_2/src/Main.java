public class Main {
    public static void  main(String[] args) {
        RekeningBank rekening1 = new RekeningBank();
        RekeningBank rekening2 = new RekeningBank();

        rekening1.namaPemilik = "Syahrial Nur Faturrahman";
        rekening2.namaPemilik = "Farid Al Farizi";

        rekening1.nomorRekening = "202410370110009";
        rekening2.nomorRekening = "202410370110017";

        rekening1.saldo = 1000000;
        rekening2.saldo = 500000;

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();

        rekening1.setorUang(500000);
        rekening2.setorUang(200000);

        rekening1.tarikUang(500000);
        rekening2.tarikUang(800000);

        rekening1.tampilkanInfo();
        rekening2.tampilkanInfo();
    }
}
