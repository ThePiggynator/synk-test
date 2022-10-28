package web.vieropnrijsb.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.web.bind.annotation.*;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.models.GameDetails;
import web.vieropnrijsb.app.repositories.GamesRepositoryMock;

import java.time.LocalDate;
import java.util.*;
import java.util.logging.Filter;

@RestController
public class GamesController {

    GamesRepositoryMock gamesRepositoryMock = new GamesRepositoryMock();

    @GetMapping("/games")
    public List<Game> getTestGames() {
        return Game.getTestGames();
    }

    @GetMapping("/games/all")
    public List<Game> getExampleGames() {
        return gamesRepositoryMock.findAll();
    }

    @GetMapping("/games/{id}")
    public Game getById(@PathVariable String id) throws Exception {
        Game game = gamesRepositoryMock.findById(Long.parseLong(id));

        if (game != null){
            return game;
        }
        throw new Exception("ResourceNotFound");
    }

    @PostMapping("/games/save")
    public Game create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String status = body.get("status");
        int maxThinkTime = Integer.parseInt(body.get("maxThinkTime"));
        boolean rated =  Boolean.parseBoolean(body.get("rated"));
        LocalDate createdAt =  LocalDate.parse(body.get("createdAt"));
        String createdBy = body.get("createdBy");
        if (id == 0){
            gamesRepositoryMock.save(new Game(title, status,maxThinkTime, rated, createdAt, createdBy));
            return new Game(title, status,maxThinkTime, rated, createdAt, createdBy);
        }
        gamesRepositoryMock.save(new Game(id,title, status,maxThinkTime, rated, createdAt, createdBy));
        return new Game(id,title, status,maxThinkTime, rated, createdAt, createdBy);
    }
    @PutMapping("games/{id}")
    public Game save(@RequestBody Map<String, String> body, @PathVariable String id ) throws Exception {

        int gameId = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String status = body.get("status");
        int maxThinkTime = Integer.parseInt(body.get("maxThinkTime"));
        boolean rated =  Boolean.parseBoolean(body.get("rated"));
        LocalDate createdAt =  LocalDate.parse(body.get("createdAt"));
        String createdBy = body.get("createdBy");

        Game game = new Game(gameId,title, status,maxThinkTime, rated, createdAt, createdBy);

        if (gamesRepositoryMock.findById(gameId) == null) throw new Exception("ResourceNotFound");

        if (Integer.parseInt(id) == gameId){
            gamesRepositoryMock.save(game);
            return game;
        }
        throw new Exception("IDs do not match");
    }
    @DeleteMapping("games/{id}")
    public void delete(@PathVariable String id ){
        gamesRepositoryMock.deleteById(Long.parseLong(id));
    }

    @GetMapping("games/summary")
    public List<GameDetails> gameSummary(){
        List<Game> allGames = gamesRepositoryMock.findAll();
        List<GameDetails> gameDetails = new ArrayList<>();
        for (Game game:allGames) {
            gameDetails.add(new GameDetails(game));
        }

        return gameDetails;
    }
}