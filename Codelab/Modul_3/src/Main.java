public class Main {
    public static void main(String[] args) {
        KarakterGame umum = new KarakterGame("Karakter umur", 100);
        Pahlawan brimstone = new Pahlawan("Brimstone", 150);
        Musuh viper = new Musuh("Viper", 200);

        System.out.println("--- Status Awal ---");
        System.out.println(brimstone.getNama() + " memiliki kesehatan: " + brimstone.getKesehatan());
        System.out.println(viper.getNama() + " memiliki kesehatan: " + viper.getKesehatan());

        System.out.println("--- Pertarungan Dimulai");
        brimstone.serang(viper);
        viper.serang(brimstone);
    }
}
