package web.vieropnrijsb.app.repositories;

import web.vieropnrijsb.app.models.Game;

import java.time.LocalDate;
import java.time.ZoneId;
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

        LocalDate createdAt2 = createdAt.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        return new Game(id, title, status, maxThinkTime, rated, createdAt2, createdBy);
    }
    private void updateId(){
        this.id += Math.ceil(3);
    }

    @Override
    public List<Game> findAll() {
        return games;
    }

    @Override
    public Game findById(long id) {

        int realId = (int) id;

        for (Game g: games) {
            if (g.getId() == realId){
                return g;
            }

        }
       return null;
    }

    @Override
    public Game deleteById(long id) {
        int realId = (int) id;

        for (Game g: games) {
            if (g.getId() == realId){
                games.remove(g);
                return g;
            }

        }
        return null;
    }

    @Override
    public Game save(Game game) {

        int id = game.getId();

        for (Game g: games) {
            if (g.getId() == id){
                Game.updateGame(g, game);
                return g;
            }
        }
        games.add(game);
        return game;
    }
}
