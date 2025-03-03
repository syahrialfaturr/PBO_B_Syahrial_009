import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        int pilihan;
        String usernameAdmin = "Admin009";
        String passwordAdmin = "Password009";
        String namaMhs = "Syahrial Nur Faturrahman";
        long nimMhs = 202410370110009L;
        String nama;
        long nim;
        String username;
        String password;

        Scanner opsi = new Scanner(System.in);
        System.out.println("Pilih login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");
        pilihan = opsi.nextInt();
        opsi.nextLine();

        if (pilihan == 1){
            System.out.print("Masukkan username: ");
            username = opsi.nextLine();

            System.out.print("Masukkan password: ");
            password = opsi.nextLine();

            if (username.equals(usernameAdmin) && password.equals(passwordAdmin)){
                System.out.println("Login admin berhasil!");
            }else {
                System.out.println("Login gagal! Periksa username atau password.");
            }


        } else if (pilihan == 2){
            System.out.print("Masukkan nama: ");
            nama = opsi.nextLine();

            System.out.print("Masukkan NIM: ");
            nim = opsi.nextLong();

            if (nama.equals(namaMhs) && nim == nimMhs){
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama: " + nama);
                System.out.println("NIM: " + nim);
            } else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        } else {
            System.out.println("Pilihan tidak tersedia, coba lagi.");
        }



    }
}
