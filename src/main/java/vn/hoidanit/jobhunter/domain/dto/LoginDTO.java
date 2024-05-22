package vn.hoidanit.jobhunter.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class LoginDTO {
    @NotBlank(message = "username ko dc bo trong")
    private String username;
    @NotBlank(message = "password ko duoc bo trong")
    private String password;

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
