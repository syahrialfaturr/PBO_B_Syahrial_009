public class Mahasiswa {
    String namaMhs = "Syahrial Nur Faturrahman";
    String nimMhs = "202410370110009";

    void login(String nama, String nim) {
        if (nama.equals(namaMhs) && nim.equals(nimMhs)){
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Nama: " + namaMhs);
        System.out.println("NIM: " + nimMhs);
    }
}
