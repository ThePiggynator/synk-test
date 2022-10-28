package web.vieropnrijsb.app.models;

public class GameDetails {
    private int id;
    private String title;
    private String status;
    private int maxThinkTime;

    public GameDetails(Game game){
        this.id = game.getId();
        this.title = game.getTitle();
        this.status = game.getStatus();
        this.maxThinkTime = game.getMaxThinkTime();
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
}
