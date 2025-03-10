// Kelas main untuk menjalankan program
public class Main {
    public static void main(String[] args){
        // Membuat objek hewan dengan parameter nama, suara, dan jenis
       Hewan hewan1 = new Hewan("Kucing", "Nyann~~", "Mamalia");
       Hewan hewan2 = new Hewan("Anjing", "Woof-Woof!!", "Mamalia");

       //Memanggil method infoHewan() untuk menampilkan informasi hewan
        hewan1.infoHewan();
        hewan2.infoHewan();

    }
}
