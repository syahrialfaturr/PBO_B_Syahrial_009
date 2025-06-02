package com.praktikum.gui;

import com.praktikum.data.DataStore;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

public class LoginPane {
    private VBox view;
    private ComboBox<String> roleComboBox;
    private TextField namaField;
    private PasswordField passwordField;
    private Text infoText;

    public LoginPane(MainApp mainApp) {
        view = new VBox(10);
        view.setPadding(new Insets(20));

        Label titleLabel = new Label("Login Sistem Lost & Found");

        roleComboBox = new ComboBox<>();
        roleComboBox.getItems().addAll("Mahasiswa", "Admin");
        roleComboBox.setValue("Mahasiswa");

        namaField = new TextField();
        namaField.setPromptText("Nama / Username");

        passwordField = new PasswordField();
        passwordField.setPromptText("NIM / Password");

        Button loginButton = new Button("Login");

        infoText = new Text();

        loginButton.setOnAction(e -> {
            String role = roleComboBox.getValue();
            String nama = namaField.getText();
            String input2 = passwordField.getText();

            if (role.equals("Mahasiswa")) {
                for (User u : DataStore.userList) {
                    if (u instanceof Mahasiswa && u.getNama().equals(nama) && u.getNim().equals(input2)) {
                        mainApp.showMahasiswaDashboard(u.getNama());
                        return;
                    }
                }
            } else {
                for (User u : DataStore.userList) {
                    if (u instanceof Admin admin && admin.verifyLogin(nama, input2)) {
                        mainApp.showAdminDashboard();
                        return;
                    }
                }
            }

            infoText.setText("Login gagal, periksa kredensial.");
        });

        view.getChildren().addAll(titleLabel, roleComboBox, namaField, passwordField, loginButton, infoText);
    }

    public VBox getView() {
        return view;
    }
}
