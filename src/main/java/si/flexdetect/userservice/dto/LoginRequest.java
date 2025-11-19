package si.flexdetect.userservice.dto; // prilagodi paket po potrebi

public class LoginRequest {
    private String email;
    private String password;

    public LoginRequest() {
        // potreben prazen konstruktor za Jackson
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
