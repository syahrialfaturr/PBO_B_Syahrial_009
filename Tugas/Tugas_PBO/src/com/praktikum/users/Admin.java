package com.praktikum.users;

import com.praktikum.actions.AdminActions;
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
        System.out.println("Nama: " + super.getNama());
        System.out.println("NIM: " + super.getNim());
        System.out.println("Username: " + username);
    }


    @Override
    public void manageItems() {
        System.out.println(">> Fitur Kelola Barang Belum Tersedia <<");
    }
    @Override
    public void manageUsers() {
        System.out.println(">> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }
    @Override
    public void displayAppMenu(){
        int pilihan;
        do {
            System.out.println("== Menu Admin ==");
            System.out.println("1. Kelola Laporan Barang");
            System.out.println("2. Kelola Data Mahasiswa");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                manageItems();
            }else if (pilihan == 2) {
                manageUsers();
            }else if (pilihan == 0) {
                System.out.println("Logout.");
            }else {
                System.out.println("Pilihan tidak valid");
            }
        } while (pilihan != 0);
    }
}
