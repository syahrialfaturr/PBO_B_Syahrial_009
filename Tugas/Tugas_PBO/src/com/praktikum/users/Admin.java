package com.praktikum.users;

import com.praktikum.actions.AdminActions;
import com.praktikum.main.LoginSystem;
import com.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    Scanner scanner = new Scanner(System.in);
    private String username;
    private String password;
    private String usernameAdmin = "Admin009";
    private String passwordAdmin = "Password009";

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    public boolean verifyLogin(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    @Override
    public void login(String username, String password){
        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)){
            displayInfo();
        } else {
            System.out.println("Login gagal! Periksa username atau password.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Informasi Admin: ");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM: " + getNim());
        System.out.println("Username: " + username);
    }


    @Override
    public void manageItems() {
        int pilihan;
//        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
        do {
            System.out.println("\n== Kelola Barang ==");
            System.out.println("1. Lihat semua laporan");
            System.out.println("2. Tandai barang telah diammbil");
            System.out.println("0. Kembali");
            System.out.print("Masukkan pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        lihatSemuaItem();
                        break;
                    case 2:
                        tandaiItemClaimed();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan !=0);
    }

    private void lihatSemuaItem() {
        if (LoginSystem.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }
        System.out.println("\n=== Daftar Semua Barang ===");
        int index = 0;
        for (Item item : LoginSystem.reportedItems) {
            System.out.println("Index: " + index);
            System.out.println("Nama Barang: " + item.getItemName());
            System.out.println("Deskripsi: " + item.getDescription());
            System.out.println("Lokasi: " + item.getLocation());
            System.out.println("Status: " + item.getStatus());
            System.out.println("----------");
            index++;
        }
    }

    private void tandaiItemClaimed() {
        // tampilkan barang dengan status reported
        System.out.println("\n=== Barang yang belum diambil ===");
        int count = 0;
        for (int i = 0; i < LoginSystem.reportedItems.size(); i++) {
            Item item = LoginSystem.reportedItems.get(i);
            if (item.getStatus().equals("Reported")) {
                System.out.println("Index: " + i);
                System.out.println("Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("---------------");
                count++;
            }
        }
        if (count == 0) {
            System.out.println("Tidak ada barang dengan status 'Reported'");
            return;
        }

        System.out.println("Masukkan index barang yang telah diambil: ");
        try {
            int index = scanner.nextInt();
            scanner.nextLine();

            if (index >= 0 && index < LoginSystem.reportedItems.size()) {
                Item item = LoginSystem.reportedItems.get(index);
                if (item.getStatus().equals("Reported")) {
                    item.setStatus("Claimed");
                    System.out.println("Barang '" + item.getItemName() + "' telah ditandai sebagai 'Claimed'");
                } else {
                    System.out.println("Barang ini sudah dalam status 'Claimed'");
                }
            } else {
                System.out.println("Index tidak valid.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
            scanner.nextLine();
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Error: Index di luar batas array!");
        }
    }
    @Override
    public void manageUsers() {
        int pilihan;
//        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
        do {
            System.out.println("\n== Kelola Mahasiswa ==");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Hapus Mahasiswa");
            System.out.println("3. Lihat Semua Mahasiswa");
            System.out.println("0. kembali");
            System.out.println("Masukkan pilihan: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        tambahMahasiswa();
                        break;
                    case 2:
                        hapusMahasiswa();
                        break;
                    case 3:
                        lihatSemuaMahasiswa();
                        break;
                    case 0:
                        System.out.println("Kembali ke menu utama.");
                        break;
                    default:
                        System.out.println("Piilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan !=0);
    }
    private void tambahMahasiswa() {
        System.out.println("Masukkan nama mahasiswa: ");
        String nama = scanner.nextLine();
        System.out.println("Masukkan NIM mahasiswa: ");
        String nim = scanner.nextLine();

        // validasi input
        if (nama.isEmpty() || nim.isEmpty()) {
            System.out.println("Nama dan NIM tidak boleh kososng!");
            return;
        }

        // cek apakah nim sudah terdaftar
        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                System.out.println("NIM sudah terdaftar!");
                return;
            }
        }
        // Tambah mahasiswa baru
        Mahasiswa newMahasiswa = new Mahasiswa(nama, nim);
        LoginSystem.userList.add(newMahasiswa);
        System.out.println("Mahasiswa berhasil ditambahkan!");
    }

    private void hapusMahasiswa() {
        System.out.println("Masukkan NIM mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();

        boolean temukan = false;
        for (int i = 0; i < LoginSystem.userList.size(); i++) {
            User user = LoginSystem.userList.get(i);
            if (user instanceof Mahasiswa && user.getNim().equals(nim)) {
                LoginSystem.userList.remove(i);
                System.out.println("Mahasiswa dengan NIM " + nim + " berhasil dihapus!");
                temukan = true;
                break;
            }
        }
        if (!temukan) {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan!");
        }
    }

    private void lihatSemuaMahasiswa() {
        System.out.println("\n=== Daftar Mahasiswa ===");
        boolean lihatMahasiswa = false;

        for (User user : LoginSystem.userList) {
            if (user instanceof Mahasiswa) {
                System.out.println("Nama: " + user.getNama());
                System.out.println("NIM: " + user.getNim());
                System.out.println("---------------------------");
                lihatMahasiswa = true;
            }
        }

        if (!lihatMahasiswa) {
            System.out.println("Tidak ada mahasiswa yang terdaftar.");
        }
    }
    @Override
    public void displayAppMenu(){
        int pilihan;
        do {
            System.out.println("\n== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");

            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        manageItems();
                        break;
                    case 2:
                        manageUsers();
                        break;
                    case 0:
                        System.out.println("Logout.");
                        break;
                    default:
                        System.out.println("Pilihan tidak valid.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Input harus berupa angka!");
                scanner.nextLine();
                pilihan = -1;
            }
        } while (pilihan != 0);
    }
}
