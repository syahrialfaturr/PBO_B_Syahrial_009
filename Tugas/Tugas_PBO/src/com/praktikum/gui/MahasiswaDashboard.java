package com.praktikum.gui;

import com.praktikum.data.Item;
import com.praktikum.data.DataStore;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class MahasiswaDashboard {
    private VBox view;
    private ObservableList<Item> laporanList;
    private TableView<Item> tableView;

    public MahasiswaDashboard(String nama, MainApp mainApp) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        Label welcome = new Label("Selamat datang, " + nama);
        Label labelForm = new Label("Laporkan Barang Hilang/Temuan");

        TextField namaField = new TextField();
        namaField.setPromptText("Nama Barang");

        TextField deskripsiField = new TextField();
        deskripsiField.setPromptText("Deskripsi Barang");

        TextField lokasiField = new TextField();
        lokasiField.setPromptText("Lokasi Ditemukan");

        Button btnLaporkan = new Button("Laporkan");
        btnLaporkan.setOnAction(e -> {
            Item item = new Item(namaField.getText(), deskripsiField.getText(), lokasiField.getText());
            DataStore.reportedItems.add(item);
            laporanList.add(item);
            namaField.clear();
            deskripsiField.clear();
            lokasiField.clear();
        });

        HBox form = new HBox(10, namaField, deskripsiField, lokasiField, btnLaporkan);

        Label tableLabel = new Label("Daftar Laporan Anda");
        tableView = new TableView<>();
        laporanList = FXCollections.observableArrayList();

        for (Item item : DataStore.reportedItems) {
            if (item.getStatus().equals("Reported")) {
                laporanList.add(item);
            }
        }

        TableColumn<Item, String> colNama = new TableColumn<>("Nama");
        colNama.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getItemName()));

        TableColumn<Item, String> colLokasi = new TableColumn<>("Lokasi");
        colLokasi.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getLocation()));

        tableView.setItems(laporanList);
        tableView.getColumns().addAll(colNama, colLokasi);
        tableView.setPrefHeight(200);

        Button logout = new Button("Logout");
        logout.setOnAction(e -> mainApp.showLoginPane());

        view.getChildren().addAll(welcome, labelForm, form, tableLabel, tableView, logout);
    }

    public VBox getView() {
        return view;
    }
}
