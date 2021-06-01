package alkemy.challenge.Challenge.Alkemy.model;

import java.util.Objects;

public class UserModel {
    private int id;
    private String email;
    private String password;

    public UserModel() {
    }

    public UserModel(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "userModel{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        return this.id == ((UserModel)obj).getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
