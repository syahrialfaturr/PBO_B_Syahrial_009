import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.util.Random;

public class Game extends Application {

    private int angkaAcak;
    private int jumlahTebakan = 0;
    private final Random random = new Random();

    private Label feedbackLabel;
    private Label percobaanLabel;
    private TextField inputField;
    private Button tombol;

    private void generateAngkaBaru() {
        angkaAcak = random.nextInt(100) + 1;
        jumlahTebakan = 0;
    }

    private void playMusic() {
        try {
            Media media = new Media(getClass().getResource("music.mp3").toExternalForm());
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE); // Musik berulang terus
            mediaPlayer.play();
        } catch (Exception e) {
            System.out.println("Gagal memutar musik: " + e.getMessage());
        }
    }


    @Override
    public void start(Stage primaryStage) {
        generateAngkaBaru();

        // Label Judul
        Label judul = new Label("🎯 Tebak Angka 1–100");
        judul.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        judul.setTextFill(Color.web("#0D47A1")); // biru tua

        // Input
        inputField = new TextField();
        inputField.setPromptText("Masukkan angka di sini");
        inputField.setMaxWidth(180);
        inputField.setFont(Font.font(14));

        // Tombol
        tombol = new Button(" 🎲 Coba Tebak!");
        tombol.setStyle("-fx-background-color: #2E7D32; -fx-text-fill: white; -fx-background-radius: 10;");
        tombol.setFont(Font.font(13));

        // Feedback dan percobaan
        feedbackLabel = new Label("");
        feedbackLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        percobaanLabel = new Label("Jumlah percobaan: 0");
        percobaanLabel.setFont(Font.font(12));

        // Event handling
        tombol.setOnAction(e -> {
            if (tombol.getText().equals("Main Lagi")) {
                generateAngkaBaru();
                tombol.setText("Coba Tebak!");
                tombol.setStyle("-fx-background-color: #2E7D32; -fx-text-fill: white; -fx-background-radius: 10;");
                feedbackLabel.setText("");
                percobaanLabel.setText("Jumlah percobaan: 0");
                inputField.clear();
                inputField.setDisable(false);
                return;
            }

            String input = inputField.getText();
            try {
                int tebakan = Integer.parseInt(input);
                jumlahTebakan++;

                if (tebakan < angkaAcak) {
                    feedbackLabel.setText("▲ Terlalu kecil!");
                    feedbackLabel.setTextFill(Color.web("#FFA000")); // orange
                } else if (tebakan > angkaAcak) {
                    feedbackLabel.setText("▲ Terlalu besar!");
                    feedbackLabel.setTextFill(Color.web("#FFA000"));
                } else {
                    feedbackLabel.setText("✓ Tebakan benar!");
                    feedbackLabel.setTextFill(Color.web("#2E7D32")); // hijau
                    tombol.setText("Main Lagi");
                    tombol.setStyle("-fx-background-color: #1565C0; -fx-text-fill: white; -fx-background-radius: 10;");
                    inputField.setDisable(true);
                }
                percobaanLabel.setText("Jumlah percobaan: " + jumlahTebakan);
            } catch (NumberFormatException ex) {
                feedbackLabel.setText("❌ Masukkan angka valid!");
                feedbackLabel.setTextFill(Color.RED);
            }

            inputField.clear();

        });


        // Layout input dan tombol (horizontal)
        HBox inputLayout = new HBox(10, inputField, tombol);
        inputLayout.setAlignment(Pos.CENTER);

        // Layout utama (vertical)
        VBox layout = new VBox(15, judul, feedbackLabel, inputLayout, percobaanLabel);
        layout.setPadding(new Insets(30));
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #E3F2FD;");

        Scene scene = new Scene(layout, 450, 250);
        primaryStage.setTitle("Tebak Angka Advance");
        primaryStage.setScene(scene);
        playMusic();
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}