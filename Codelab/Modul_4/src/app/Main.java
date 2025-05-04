package app;

import perpustakaan.Anggota;
import perpustakaan.Buku;
import perpustakaan.Fiksi;
import perpustakaan.NonFiksi;

public class Main {
    public static void main(String args []) {
        // objek buku
        Buku bukuFiksi = new Fiksi("Bumi", "Tere Liye", "Fantasi petualangan");
        Buku bukuNonFiksi = new NonFiksi("Filosofi Teras", "Henry Manampiring", "Filsafat Self Help");

        bukuFiksi.displayInfo();
        System.out.println();
        bukuNonFiksi.displayInfo();
        System.out.println();

        //Anggota perpus
        Anggota anggota1 = new Anggota("Syahrial", "B009");
        Anggota anggota2 = new Anggota("Fatur", "B010");

        System.out.println("Anggota");
        System.out.println("1. Nama: " + anggota1.getNama());
        System.out.println("     ID: " + anggota1.getIdAnggota());
        System.out.println("2. Nama: " + anggota2.getNama());
        System.out.println("     ID: " + anggota2.getIdAnggota());
        System.out.println();


        anggota1.pinjamBuku("Bumi");
        anggota2.pinjamBuku("Filosofi Teras", 10);

        System.out.println();

        //pengembalian
        anggota1.kembalikanBuku("Bumi");
        anggota2.kembalikanBuku("Filosofi Teras");
    }
}
