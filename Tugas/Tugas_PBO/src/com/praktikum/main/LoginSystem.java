package com.praktikum.main;

import com.praktikum.data.DataStore;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import java.util.Scanner;

public class LoginSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Lost & Found System ===");
        System.out.println("1. Jalankan Mode CLI");
        System.out.println("2. Jalankan Mode GUI");
        System.out.print("Pilih mode: ");
        int mode = scanner.nextInt();
        scanner.nextLine(); // konsumsi newline

        if (mode == 1) {
            runCLI(scanner);
        } else if (mode == 2) {
            com.praktikum.gui.MainApp.main(args); // langsung jalankan GUI
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    private static void runCLI(Scanner scanner) {
        System.out.println("=== Login CLI ===");
        System.out.println("1. Login sebagai Admin");
        System.out.println("2. Login sebagai Mahasiswa");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Password: ");
            String password = scanner.nextLine();

            for (User u : DataStore.userList) {
                if (u instanceof Admin admin && admin.verifyLogin(username, password)) {
                    u.login(username, password);
                    u.displayAppMenu();
                    return;
                }
            }
            System.out.println("Login admin gagal.");

        } else if (pilihan == 2) {
            System.out.print("Nama: ");
            String nama = scanner.nextLine();
            System.out.print("NIM: ");
            String nim = scanner.nextLine();

            for (User u : DataStore.userList) {
                if (u instanceof Mahasiswa && u.getNama().equals(nama) && u.getNim().equals(nim)) {
                    u.login(nama, nim);
                    u.displayAppMenu();
                    return;
                }
            }
            System.out.println("Login mahasiswa gagal.");
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }
}
