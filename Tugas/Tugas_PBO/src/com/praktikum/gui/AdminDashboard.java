package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.data.DataStore;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class AdminDashboard {
    private VBox view;

    public AdminDashboard(MainApp mainApp) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        Label welcome = new Label("Halo, Administrator admin");

        // === Bagian Laporan Barang ===
        Label laporanLabel = new Label("Laporan Barang");
        TableView<Item> barangTable = new TableView<>();
        ObservableList<Item> items = FXCollections.observableArrayList(DataStore.reportedItems);
        barangTable.setItems(items);

        TableColumn<Item, String> namaCol = new TableColumn<>("Nama");
        namaCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<Item, String> lokasiCol = new TableColumn<>("Lokasi");
        lokasiCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLocation()));

        TableColumn<Item, String> statusCol = new TableColumn<>("Status");
        statusCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getStatus()));

        barangTable.getColumns().addAll(namaCol, lokasiCol, statusCol);
        barangTable.setPrefHeight(200);

        Button tandaiClaimed = new Button("Tandai Claimed");
        tandaiClaimed.setOnAction(e -> {
            Item selected = barangTable.getSelectionModel().getSelectedItem();
            if (selected != null && selected.getStatus().equals("Reported")) {
                selected.setStatus("Claimed");
                barangTable.refresh();
            }
        });

        VBox barangBox = new VBox(5, laporanLabel, barangTable, tandaiClaimed);

        // === Bagian Data Mahasiswa ===
        Label mahasiswaLabel = new Label("Data Mahasiswa");
        TableView<User> mahasiswaTable = new TableView<>();
        ObservableList<User> mahasiswaList = FXCollections.observableArrayList();

        for (User u : DataStore.userList) {
            if (u instanceof Mahasiswa) mahasiswaList.add(u);
        }

        mahasiswaTable.setItems(mahasiswaList);

        TableColumn<User, String> namaMhs = new TableColumn<>("Nama");
        namaMhs.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNama()));

        TableColumn<User, String> nimMhs = new TableColumn<>("NIM");
        nimMhs.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getNim()));

        mahasiswaTable.getColumns().addAll(namaMhs, nimMhs);
        mahasiswaTable.setPrefHeight(200);

        // Input Tambah Mahasiswa
        TextField namaInput = new TextField();
        namaInput.setPromptText("Nama Mahasiswa");

        TextField nimInput = new TextField();
        nimInput.setPromptText("NIM");

        Button btnTambah = new Button("Tambah");
        btnTambah.setOnAction(e -> {
            String nama = namaInput.getText().trim();
            String nim = nimInput.getText().trim();

            if (!nama.isEmpty() && !nim.isEmpty()) {
                for (User u : DataStore.userList) {
                    if (u instanceof Mahasiswa && u.getNim().equals(nim)) {
                        showAlert("Gagal", "NIM sudah terdaftar.");
                        return;
                    }
                }
                Mahasiswa mhsBaru = new Mahasiswa(nama, nim);
                DataStore.userList.add(mhsBaru);
                mahasiswaList.add(mhsBaru);

                namaInput.clear();
                nimInput.clear();
            } else {
                showAlert("Validasi", "Nama dan NIM tidak boleh kosong.");
            }
        });

        Button btnHapus = new Button("Hapus");
        btnHapus.setOnAction(e -> {
            User selected = mahasiswaTable.getSelectionModel().getSelectedItem();
            if (selected != null && selected instanceof Mahasiswa) {
                mahasiswaList.remove(selected);
                DataStore.userList.remove(selected);
            }
        });

        HBox inputMahasiswa = new HBox(5, namaInput, nimInput, btnTambah, btnHapus);
        VBox mahasiswaBox = new VBox(5, mahasiswaLabel, mahasiswaTable, inputMahasiswa);

        HBox kontenUtama = new HBox(30, barangBox, mahasiswaBox);

        Button logout = new Button("Logout");
        logout.setOnAction(e -> mainApp.showLoginPane());

        Button bebas = new Button("Bebas");
        HBox bebasBox = new HBox(5, bebas, logout);

        view.getChildren().addAll(welcome, kontenUtama, bebasBox);
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public VBox getView() {
        return view;
    }
}
