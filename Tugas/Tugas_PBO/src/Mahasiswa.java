public class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String nama, String nim) {
        if (nama.equals(getNama()) && nim.equals(getNim())) {
            displayInfo();
        }else {
            System.out.println("Login gagal! Nama atau NIM salah");
        }
    }
    @Override
    public void displayInfo() {
        System.out.println("Login Mahasiswa berhasil!");
        System.out.println("Informasi Mahasiswa: ");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
    }
}