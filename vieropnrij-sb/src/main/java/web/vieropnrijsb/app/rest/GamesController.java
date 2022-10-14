package web.vieropnrijsb.app.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.repositories.GamesRepositoryMock;

import java.util.Arrays;
import java.util.List;

@RestController
public class GamesController {
    @GetMapping("/games")
    public List<Game> getTestGames(){
        return Game.getTestGames();
    }
    @GetMapping("/games/examples")
    public List<Game> getExampleGames(){
        GamesRepositoryMock test = new GamesRepositoryMock();
        return test.findAll();
    }
}
