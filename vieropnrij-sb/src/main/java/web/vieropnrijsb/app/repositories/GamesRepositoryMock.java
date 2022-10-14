package web.vieropnrijsb.app.repositories;

import web.vieropnrijsb.app.models.Game;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GamesRepositoryMock implements GamesRepository {

    private List<Game> games = new ArrayList<Game>();
    private int id = 30000;

    public GamesRepositoryMock() {

        for (int i = 0; i < 7; i++) {
            this.games.add(createSampleGame(this.id));
            updateId();
        }
    }

    public static Game createSampleGame(long pId) {

        int id = (int) pId;
        String title = "Sample game: " + Math.ceil(Math.random() * 10000);
        String status = "";
        int maxThinkTime = (int) Math.floor(Math.random() * 100);
        boolean rated = false;
        Date createdAt;
        String createdBy = "Hugo Blok";

        int randomNum = (int) Math.floor(Math.random() * 4);
        switch (randomNum) {
            case 0:
                status = "NEW";
                break;
            case 1:
                status = "BROADCAST";
                break;
            case 2:
                status = "RUNNING";
                break;
            case 3:
                status = "FINISHED";
                break;
        }

        randomNum = (int) Math.floor(Math.random() * 2);
        switch (randomNum) {
            case 0:
                rated = false;
                break;
            case 1:
                rated = true;
                break;
        }
        // get a random date within 31 days
        randomNum = (int) Math.floor(Math.random() * 32);

        createdAt = new Date();
        createdAt.setDate(createdAt.getDate() - randomNum);

        return new Game(id, title, status, maxThinkTime, rated, createdAt, createdBy);
    }
    private void updateId(){
        this.id += Math.ceil(3);
    }

    @Override
    public List<Game> findAll() {
        return games;
    }
}
