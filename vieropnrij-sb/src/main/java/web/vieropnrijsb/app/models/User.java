package web.vieropnrijsb.app.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table
public class User {
    @Id
    private long id;
    private String name;
    private String email;
    private String role;
    private String hashedPassword;

    @OneToMany
    private List<Player>players;

}
