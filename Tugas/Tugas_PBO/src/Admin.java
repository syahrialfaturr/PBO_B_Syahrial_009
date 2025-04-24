public class Admin extends User {
    private String username;
    private String password;
    private String usernameAdmin = "Admin009";
    private String passwordAdmin = "Password009";

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.username = username;
        this.password = password;
    }

    @Override
    public void login(String username, String password){
        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)){
            displayInfo();
        } else {
            System.out.println("Login gagal! Periksa username atau password.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Informasi Admin: ");
        System.out.println("Nama: " + super.getNama());
        System.out.println("NIM: " + super.getNim());
        System.out.println("Username: " + username);
    }
}
