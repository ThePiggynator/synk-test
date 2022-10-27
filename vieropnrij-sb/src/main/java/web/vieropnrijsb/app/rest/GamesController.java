package web.vieropnrijsb.app.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.repositories.GamesRepositoryMock;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
public class GamesController {

    GamesRepositoryMock gamesRepositoryMock = new GamesRepositoryMock();

    @GetMapping("/games")
    public List<Game> getTestGames() {
        return Game.getTestGames();
    }

    @GetMapping("/games/examples")
    public List<Game> getExampleGames() {
        return gamesRepositoryMock.findAll();
    }

    @GetMapping("/games/{id}")
    public Game getById(@PathVariable String id) {
        return gamesRepositoryMock.findById(Long.parseLong(id));
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
}