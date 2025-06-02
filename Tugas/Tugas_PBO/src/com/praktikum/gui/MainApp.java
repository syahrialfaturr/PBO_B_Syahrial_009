package com.praktikum.gui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

    private Stage primaryStage;

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        showLoginPane();
    }

    public void showLoginPane() {
        LoginPane loginPane = new LoginPane(this);
        Scene scene = new Scene(loginPane.getView(), 400, 250);
        primaryStage.setTitle("Lost & Found Kampus");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void showMahasiswaDashboard(String nama) {
        MahasiswaDashboard mahasiswaDashboard = new MahasiswaDashboard(nama, this);
        Scene scene = new Scene(mahasiswaDashboard.getView(), 600, 400);
        primaryStage.setScene(scene);
    }

    public void showAdminDashboard() {
        AdminDashboard adminDashboard = new AdminDashboard(this);
        Scene scene = new Scene(adminDashboard.getView(), 800, 500);
        primaryStage.setScene(scene);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
