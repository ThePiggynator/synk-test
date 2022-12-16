package web.vieropnrijsb.app.rest;

import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import web.vieropnrijsb.app.exceptions.PreConditionFailed;
import web.vieropnrijsb.app.exceptions.ResourceNotFound;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.repositories.EntityRepository;
import web.vieropnrijsb.app.repositories.GamesJPARepository;
import web.vieropnrijsb.app.repositories.GamesRepository;
import web.vieropnrijsb.app.views.CustomView;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

@RestController
@RequestMapping("/games")
@CrossOrigin("/**")
public class GamesController {

    @Autowired
    private EntityRepository<Game> gamesRepository;

//    @Autowired
//    private EntityRepository<Game> gamesJPARepository;

    @GetMapping("/test")
    public List<Game> getTestGames() {
        return Game.getTestGames();
    }

    @GetMapping("")
    public List<Game> getExampleGames() {
        return gamesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Game getById(@PathVariable String id) throws ResourceNotFound {
        Game game = gamesRepository.findById(Integer.parseInt(id));

        if (game != null){
            return game;
        }
        throw new ResourceNotFound();
    }

    @PostMapping("/")
    public Game create(@RequestBody Game game) {
        if (game.getId() == 0){
            gamesRepository.save(game);
            return game;
        }
        gamesRepository.save(game);
        return game;
    }
    @PutMapping("/{id}")
    public Game save(@RequestBody Game game, @PathVariable int id ) throws ResourceNotFound, PreConditionFailed{

        if (gamesRepository.findById(game.getId()) == null) throw new ResourceNotFound("Resource Not Found");

        if (id == game.getId()){
            gamesRepository.save(game);
            return game;
        }
        throw new PreConditionFailed("IDs do not match");
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id ){
        gamesRepository.deleteById(Integer.parseInt(id));
    }

    @JsonView(CustomView.summary.class)
    @GetMapping("/summary")
    public List<Game> gameSummary(){
        List<Game> allGames = gamesRepository.findAll();

        return allGames;
    }
}