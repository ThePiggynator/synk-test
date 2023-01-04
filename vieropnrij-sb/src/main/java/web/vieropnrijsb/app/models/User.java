package web.vieropnrijsb.app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "`USERS`")
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String role;
    private String hashedPassword;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference(value = "user")
    private List<Player> players;

    public User() {
    }

    public User(long id, String name, String email, String role, String hashedPassword) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.hashedPassword = hashedPassword;
    }

    public User(String email, String hashedPassword) {
        this.email = email;
        this.hashedPassword = hashedPassword;
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
    public String getRole() {
        return role;
    }
    public String getHashedPassword() {
        return hashedPassword;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public void setHashedPassword(String hashedPassword) {
        this.hashedPassword = hashedPassword;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
