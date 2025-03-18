class Pahlawan extends KarakterGame {
    public Pahlawan(String nama, int kesehatan){
        super(nama, kesehatan);
    }

    public void serang(KarakterGame target){
        System.out.println(getNama() + " menyerang " + target.getKesehatan() + " Orbital Strike!");
        target.setKesehatan(target.getKesehatan() - 20);
        System.out.println(target.getNama() + " sekarang memiliki kesehatan " + target.getKesehatan());
    }
}
