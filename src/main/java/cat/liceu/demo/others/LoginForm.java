package cat.liceu.demo.others;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginForm {
    @NotBlank(message="Username es obligatori")
            @Size(min=2,max=10, message = "minim es 2 caracters")
    String username;
    @NotBlank(message="pass es obligatori")
    @Size(min=2,max=10, message = "minim es 2 caracters")
    String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
