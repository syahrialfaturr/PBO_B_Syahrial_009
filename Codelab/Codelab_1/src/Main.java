import java.util.Scanner; // untuk mengambil input dari user
import java.time.LocalDate; // untuk mendapatkan tahun saat ini (java API)

public class Main {
    public static void main(String[] args) {    //methode main
        String nama;    // variabel untuk menyimpan nama dari user
        char jenisKelamin; // variabel untuk menyimpan jenis kelamin dari user
        int tahunLahir; // variabel untuk menyimpan tahun lahir dari user
        String gender; // variabel untuk menampilkan jenis kelamin

        Scanner data = new Scanner(System.in); // objek scanner untuk menerima input dari pengguna

        System.out.print("Masukkan nama: ");  // menampilkan teks untuk meminta user memasukkan nama
        nama = data.nextLine(); //kode untuk menginputkan sebuah nilai String ke dalam variabel nama

        System.out.print("Masukkan jenis kelamin (P/L): "); // menampilkan teks untuk meminta user memasukkan jenis kelamin
        jenisKelamin = data.next().charAt(0); //kode untuk menginputkan sebuah karakter ke dalam variabel jenisKelamin

        System.out.print("Masukkan tahun lahir: "); // menampilkan teks untuk meminta user memasukkan tahun lahir
        tahunLahir = data.nextInt(); //kode untuk menginputkan sebuah nilai int ke dalam variabel tahunLahir

        int tahunSekarang = LocalDate.now().getYear(); // mengambil tahun saat ini dar sistem (java API)
        int umur = tahunSekarang - tahunLahir; //Menghitung umur

        //Menentukan jenis kelamin berdasarkan input user
        if(jenisKelamin == 'L' || jenisKelamin == 'l'){ // jika user memasukkan 'L' atau 'l'
            gender = "Laki-laki"; // set variabel gender menjadi "Laki-laki
        }else if(jenisKelamin == 'P' || jenisKelamin == 'p'){ // jika pengguna memasukkan 'P' atau 'p'
            gender = "Perempuan"; // set variabel menjadi "Perempuan"
        }else { // jika input tidak sesuai
            gender = "Jenis kelamin tidak ada."; // set variabel menjadi "Jenis kelamin tidak ada."
        }

        // Menampilkan hasil data diri yang telah dimasukkan oleh user
        System.out.println("Data diri: "); // menampilkan teks sebagai header (judul) data diri
        System.out.println("Nama: " + nama); // menampilkan nama
        System.out.println("Jenis kelamin: " + gender); // menampilkan jenis kelamin
        System.out.println("Umur: " + umur); // menampilkan umur
    }





}
