package com.praktikum.main;

import com.praktikum.users.*;
import com.praktikum.data.Item;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;

public class LoginSystem {
    public static ArrayList<User> userList = new ArrayList<>();
    public static ArrayList<Item> reportedItems = new ArrayList<>();
    public static void main(String[] args) {
        userList.add(new Admin("Syahrial", "009", "Admin009", "Password009"));
        userList.add(new Mahasiswa("Syahrial Nur Faturrahman", "202410370110009"));

        // Tambahkan contoh laporan barang supaya admin bisa menandai
        reportedItems.add(new Item("Hp", "iphone 16", "Kantek"));
        reportedItems.add(new Item("Kunci Motor", "Vespa matic", "ICT"));


        int pilihan;
        Scanner opsi = new Scanner(System.in);
        User user;
        boolean loginBerhasil = false;

        try {
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

                // mencari admin yang cocok di userList
                for (User u : userList) {
                    if (u instanceof Admin) {
                       Admin admin = (Admin) u;
                       if (admin.verifyLogin(username, password)) {
                           user = admin;
                           user.login(username, password);
                           user.displayAppMenu();
                           loginBerhasil = true;
                           break;
                       }
                    }
                }
                if (!loginBerhasil) {
                    System.out.println("Login Admin gagal! Username atau password salah.");
                }
            } else if (pilihan == 2) {
                System.out.print("Masukkan nama: ");
                String nama = opsi.nextLine();
                System.out.print("Masukkan NIM: ");
                String nim = opsi.nextLine();

                for (User u : userList) {
                    if (u instanceof Mahasiswa) {
                       if (u.getNama().equals(nama) && u.getNim().equals(nim)) {
                           user = u;
                           user.login(nama, nim);
                           user.displayAppMenu();
                           loginBerhasil = true;
                           break;
                       }
                    }
                }
                if (!loginBerhasil) {
                    System.out.println("Login gagal! Nama atau NIM salah.");
                }
            } else {
                System.out.println("Pilihan tidak tersedia, coba lagi.");
            }
        } catch (InputMismatchException e) {
            System.out.println("Error: Input harus berupa angka!");
        } finally {
            opsi.close();
        }

    }
    }