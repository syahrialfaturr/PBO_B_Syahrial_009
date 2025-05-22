import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("\n==== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Baru");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Masukkan pilihan: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
                continue;
            }

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scanner.nextLine();
                    System.out.print("Masukkan stok awal: ");
                    try {
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        Barang barangBaru = new Barang(nama, stok);
                        daftarBarang.add(barangBaru);
                        System.out.println("Barang '" + nama + "' berhasil ditambahkan");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scanner.nextLine();
                    }
                    break;

                case 2:
                    System.out.println("\n--- Daftar Barang ---");
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            Barang b = daftarBarang.get(i);
                            System.out.println(i + ". Nama: " + b.getNama() + ", Stok: " + b.getStok());
                        }
                    }
                    break;

                case 3:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Tidak ada barang untuk dikurangi.");
                        break;
                    }

                    System.out.println("\n--- Daftar Barang (Pilih untuk Kurangi Stok) ---");
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        Barang b = daftarBarang.get(i);
                        System.out.println(i + ". " + b.getNama() + " (Stok: " + b.getStok() + ")");
                    }

                    try {
                        System.out.print("Masukkan nomor indeks barang: ");
                        int idx = scanner.nextInt();
                        scanner.nextLine();

                        Barang barang = daftarBarang.get(idx);

                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlahDiambil = scanner.nextInt();
                        scanner.nextLine();

                        if (jumlahDiambil > barang.getStok()) {
                            throw new StokTidakCukupException("Stok untuk '" + barang.getNama() + "' hanya tersisa " + barang.getStok());
                        }

                        barang.setStok(barang.getStok() - jumlahDiambil);
                        System.out.println("Stok barang '" + barang.getNama() + "' berhasil dikurangi. Sisa stok: " + barang.getStok());
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scanner.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks barang tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih! Program berakhir.");
                    break;

                default:
                    System.out.println("Opsi tidak valid.");
            }
        } while (pilihan != 0);

        scanner.close();
    }

}
