package web.vieropnrijsb.app.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonView;
import web.vieropnrijsb.app.views.CustomView;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Entity
@Table
public class Game {
    @JsonView(CustomView.shallow.class)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @JsonView(CustomView.shallow.class)
    private String title;
    @JsonView(CustomView.summary.class)
    private String status;
    @JsonView(CustomView.summary.class)
    private int maxThinkTime;
    private boolean rated;
    private LocalDate createdAt;
    private String createdBy;

    @OneToMany(mappedBy = "game")
    @JsonManagedReference(value = "game")
    private List<Player> players = new ArrayList<>();

    public Game(int id, String title, String status, int maxThinkTime, boolean rated, LocalDate createdAt, String createdBy) {
        this.id = id;
        this.title = title;
        this.status = status;
        this.maxThinkTime = maxThinkTime;
        this.rated = rated;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public Game(int id, String title) {
        this.id = id;
        this.title = title;
    }
    public Game(int id) {
        this.id = id;
    }
    public Game() {

    }

    public Game(String title, String status, int maxThinkTime, boolean rated, LocalDate createdAt, String createdBy) {
        this.id = (int)Math.ceil(Math.random()*1000000);
        this.title = title;
        this.status = status;
        this.maxThinkTime = maxThinkTime;
        this.rated = rated;
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    static public List<Game> getTestGames(){
        return List.of(
                new Game(30001, "Test-game 1"),
                new Game(30002, "Test-game 2")
        );
    }

    public static void updateGame(Game oldGame, Game newGame){
        oldGame.setTitle(newGame.getTitle());
        oldGame.setRated(newGame.isRated());
        oldGame.setStatus(newGame.getStatus());
        oldGame.setMaxThinkTime(newGame.getMaxThinkTime());
    }

    public long getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getStatus() {
        return status;
    }
    public int getMaxThinkTime() {
        return maxThinkTime;
    }
    public boolean isRated() {
        return rated;
    }
    public LocalDate getCreatedAt() {
        return createdAt;
    }
    public String getCreatedBy() {
        return createdBy;
    }
    public List<Player> getPlayers() {
        return players;
    }

    public void setId(int id) {
        this.id = id;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public void setMaxThinkTime(int maxThinkTime) {
        this.maxThinkTime = maxThinkTime;
    }
    public void setRated(boolean rated) {
        this.rated = rated;
    }
    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
    public void setPlayers(List<Player> players) {
        this.players = players;
    }
}
