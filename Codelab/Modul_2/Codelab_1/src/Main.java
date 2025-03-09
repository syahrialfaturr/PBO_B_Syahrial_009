public class Main {
    public static void main(String[] args){
        Hewan hewan1 = new Hewan();
        Hewan hewan2 = new Hewan();

        hewan1.nama = "Kucing";
        hewan2.nama = "Anjing";

        hewan1.jenis = "Mamalia";
        hewan2.jenis = "Mamalia";

        hewan1.suara = "Nyann~~";
        hewan2.suara = "Woof-Woof!!";

        hewan1.tampilkanInfo();
        hewan2.tampilkanInfo();

    }
}
