package web.vieropnrijsb.app.models;

import javax.persistence.*;

@Entity
@Table
public class Player {
    @Id
    private long id;
    private String color;

    @ManyToOne
    private Game game;

    @ManyToOne
    private User user;
}
