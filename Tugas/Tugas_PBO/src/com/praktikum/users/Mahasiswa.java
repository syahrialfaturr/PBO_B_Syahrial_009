package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
import com.praktikum.data.DataStore;
import com.praktikum.data.Item;

import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner scanner = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String nama, String nim) {
        if (nama.equals(getNama()) && nim.equals(getNim())) {
            displayInfo();
        } else {
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

    @Override
    public void reportItem(){
        System.out.print("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.print("Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.print("Lokasi Terakhir/Ditemukan: ");
        String lokasiBarang = scanner.nextLine();

        System.out.println("==Konfirmasi==");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi Barang: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasiBarang);

        Item item = new Item(namaBarang, deskripsiBarang, lokasiBarang);
        DataStore.reportedItems.add(item);
        System.out.println("Barang berhasil dilaporkan!");
    }

    @Override
    public void viewReportedItems(){
        if (DataStore.reportedItems.isEmpty()) {
            System.out.println("Belum ada laporan barang.");
            return;
        }

        System.out.println("\n=== Daftar Barang yang Dilaporkan ===");
        Iterator<Item> iterator = DataStore.reportedItems.iterator();
        boolean laporanItem = false;

        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getStatus().equals("Reported")) {
                System.out.println("Nama Barang: " + item.getItemName());
                System.out.println("Deskripsi: " + item.getDescription());
                System.out.println("Lokasi: " + item.getLocation());
                System.out.println("-----------------------------------");
                laporanItem = true;
            }
        }

        if (!laporanItem) {
            System.out.println("Tidak ada barang dengan status 'Reported'.");
        }
    }

    @Override
    public void displayAppMenu(){
        int pilihan;
        do {
            System.out.println("\n == Menu Mahasiswa ==");
            System.out.println("1. Laporkan Barang Temuan/Hilang");
            System.out.println("2. Lihat Daftar Laporan");
            System.out.println("0. Logout");
            System.out.print("Pilih menu: ");
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        reportItem();
                        break;
                    case 2:
                        viewReportedItems();
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
