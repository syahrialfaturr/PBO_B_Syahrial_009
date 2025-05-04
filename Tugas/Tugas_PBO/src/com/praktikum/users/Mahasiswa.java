package com.praktikum.users;

import com.praktikum.actions.MahasiswaActions;
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

    @Override
    public void reportItem(){
        System.out.println("Nama Barang: ");
        String namaBarang = scanner.nextLine();
        System.out.println("Deskripsi Barang: ");
        String deskripsiBarang = scanner.nextLine();
        System.out.println("Lokasi Terakhir/Ditemukan: ");
        String lokasiBarang = scanner.nextLine();

        System.out.println("==Konfirmasi==");
        System.out.println("Nama Barang: " + namaBarang);
        System.out.println("Deskripsi Barang: " + deskripsiBarang);
        System.out.println("Lokasi: " + lokasiBarang);
    }
    @Override
    public void viewReportedItems(){
        System.out.println(">> Fitur Lihat Laporan Belum Tersedia <<");
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
           pilihan = scanner.nextInt();
           scanner.nextLine();

           if (pilihan == 1) {
               reportItem();
           }else if (pilihan == 2) {
               viewReportedItems();
           }else if (pilihan == 0) {
               System.out.println("Logout.");
           }else {
               System.out.println("Pilihan tidak valid.");
           }
       } while (pilihan != 0);
    }
}