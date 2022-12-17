package web.vieropnrijsb.app.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class Player {
    @Id
    private long id;
    private String color;

    @ManyToOne
    @JsonBackReference(value = "game")
    private Game game;

    @ManyToOne
    @JsonBackReference(value = "user")
    private User user;

    public Player() {
    }

    public Player(long id, String color, Game game, User user) {
        this.id = id;
        this.color = color;
        this.game = game;
        this.user = user;
    }
    public Player(String color, Game game, User user) {
        this.color = color;
        this.game = game;
        this.user = user;
    }

    public long getId() {
        return id;
    }
    public String getColor() {
        return color;
    }
    public Game getGame() {
        return game;
    }
    public User getUser() {
        return user;
    }

    public void setId(long id) {
        this.id = id;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setGame(Game game) {
        this.game = game;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
