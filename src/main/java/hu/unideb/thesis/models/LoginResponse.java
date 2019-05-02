package hu.unideb.thesis.models;

import java.util.Set;

public class LoginResponse {
    private String token;
    private Set<Role> roles;

    public LoginResponse() {
    }

    public String getToken() {
    return token;
}

    public void setToken(String token) {
        this.token = token;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
}
