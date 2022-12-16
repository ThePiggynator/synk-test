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
    private GamesRepository gamesRepository;

    @Autowired
    private EntityRepository<Game> gamesJPARepository;

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

    @PostMapping("/save")
    public Game create(@RequestBody Map<String, String> body) {
        int id = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String status = body.get("status");
        int maxThinkTime = Integer.parseInt(body.get("maxThinkTime"));
        boolean rated =  Boolean.parseBoolean(body.get("rated"));
        LocalDate createdAt =  new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        String createdBy = body.get("createdBy");
        if (id == 0){
            gamesRepository.save(new Game(title, status,maxThinkTime, rated, createdAt, createdBy));
            return new Game(title, status,maxThinkTime, rated, createdAt, createdBy);
        }
        gamesRepository.save(new Game(id,title, status,maxThinkTime, rated, createdAt, createdBy));
        return new Game(id,title, status,maxThinkTime, rated, createdAt, createdBy);
    }
    @PutMapping("/{id}")
    public Game save(@RequestBody Map<String, String> body, @PathVariable String id ) throws ResourceNotFound, PreConditionFailed{

        int gameId = Integer.parseInt(body.get("id"));
        String title = body.get("title");
        String status = body.get("status");
        int maxThinkTime = Integer.parseInt(body.get("maxThinkTime"));
        boolean rated =  Boolean.parseBoolean(body.get("rated"));
        LocalDate createdAt =  LocalDate.parse(body.get("createdAt"));
        String createdBy = body.get("createdBy");

        Game game = new Game(gameId,title, status,maxThinkTime, rated, createdAt, createdBy);

        if (gamesJPARepository.findById(gameId) == null) throw new ResourceNotFound("Resource Not Found");

        if (Integer.parseInt(id) == gameId){
            gamesJPARepository.save(game);
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