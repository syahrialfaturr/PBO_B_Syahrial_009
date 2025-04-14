public class Admin {
    String usernameAdmin = "Admin009";
    String passwordAdmin = "Password009";

    void login(String username, String password){
        if (username.equals(usernameAdmin) && password.equals(passwordAdmin)){
            System.out.println("Login admin berhasil!");
        } else {
            System.out.println("Login gagal! Periksa username atau password.");
        }
    }
}
