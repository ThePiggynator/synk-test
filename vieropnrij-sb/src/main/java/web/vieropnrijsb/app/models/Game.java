package web.vieropnrijsb.app.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public class Game {
    int id;
    String title;
    String status;
    int maxThinkTime;
    boolean rated;
    Date createdAt;
    String createdBy;

    public Game(int id, String title, String status, int maxThinkTime, boolean rated, Date createdAt, String createdBy) {
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

    static public List<Game> getTestGames(){
        return List.of(
                new Game(30001, "Test-game 1"),
                new Game(30002, "Test-game 2")
        );
    }

    public int getId() {
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
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

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
