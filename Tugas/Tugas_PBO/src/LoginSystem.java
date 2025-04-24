import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {

        Admin admin = new Admin("Syahrial", "009", "Admin009", "Password009");
        Mahasiswa mahasiswa = new Mahasiswa("Syahrial Nur Faturrahman", "202410370110009");

        int  pilihan;
        Scanner opsi = new Scanner(System.in);

        System.out.println("Pilihan login: ");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan: ");

        pilihan = opsi.nextInt();
        opsi.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan username: ");
            String username = opsi.nextLine();
            System.out.print("Masukkan password: ");
            String password = opsi.nextLine();

            admin.login(username, password);
        } else if (pilihan == 2) {
            System.out.print("Masukkan nama: ");
            String nama = opsi.nextLine();
            System.out.print("Masukkan NIM: ");
            String nim = opsi.nextLine();

            mahasiswa.login(nama, nim);
        } else {
            System.out.println("Pilihan tidak tersedia, coba lagi.");
        }
    }
}