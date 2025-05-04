package perpustakaan;

public class Anggota implements Peminjaman {
    private String nama;
    private String idAnggota;

    public String getNama() {
        return nama;
    }
    public String getIdAnggota() {
        return idAnggota;
    }

    public Anggota(String nama, String idAnggota) {
        this.nama = nama;
        this.idAnggota = idAnggota;
    }

    @Override
    public void pinjamBuku(String judul) {
        System.out.println(nama + " (" + idAnggota + ") meminjam buku berjudul "+ judul);
    }

    @Override
    public void pinjamBuku(String judul, int durasi) {
        System.out.println(nama + " (" + idAnggota + ") meminjam buku berjudul "+ judul + " selama " + durasi + " hari");
    }

    @Override
    public void kembalikanBuku(String judul){
        System.out.println(nama + " (" + idAnggota + ") mengembalikan buku berjudul " + judul);
    }
}

