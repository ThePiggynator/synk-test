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

    public Player() {
    }

    public Player(long id, String color, Game game, User user) {
        this.id = id;
        this.color = color;
        this.game = game;
        this.user = user;
    }
}
