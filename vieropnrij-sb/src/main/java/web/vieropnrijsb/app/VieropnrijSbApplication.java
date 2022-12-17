package web.vieropnrijsb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.models.Player;
import web.vieropnrijsb.app.models.User;
import web.vieropnrijsb.app.repositories.EntityRepository;
import web.vieropnrijsb.app.repositories.GamesRepositoryMock;

import javax.transaction.Transactional;

@SpringBootApplication
public class VieropnrijSbApplication implements CommandLineRunner {

    @Autowired
    EntityRepository<Game> gameEntityRepository;
    @Autowired
    EntityRepository<User> userEntityRepository;
    @Autowired
    EntityRepository<Player> playerEntityRepository;

    public static void main(String[] args) {
        SpringApplication.run(VieropnrijSbApplication.class, args);
    }


    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(1));
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(2));
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(3));

        userEntityRepository.save(new User(1, "Gerard", "gerard@gmail.com", "user", "bqwdihdqhiudqw"));
        userEntityRepository.save(new User(2, "Bas", "baslegend@gmail.com", "administrator", "ioqwfojijpoif"));
        userEntityRepository.save(new User(3, "Sjoerd", "sjoerd@gmail.com", "user", "nlmkjdvsndvni"));


        playerEntityRepository.save(new Player(1, "Green", gameEntityRepository.findById(1), userEntityRepository.findById(1)));
        playerEntityRepository.save(new Player(2, "Blue", gameEntityRepository.findById(2), userEntityRepository.findById(2)));
        playerEntityRepository.save(new Player(3, "Orange", gameEntityRepository.findById(3), userEntityRepository.findById(3)));

        gameEntityRepository.findById(1).getPlayers().add(playerEntityRepository.findById(1));
        gameEntityRepository.findById(1).getPlayers().add(playerEntityRepository.findById(2));

        gameEntityRepository.findById(2).getPlayers().add(playerEntityRepository.findById(2));
        gameEntityRepository.findById(2).getPlayers().add(playerEntityRepository.findById(3));

        gameEntityRepository.findById(3).getPlayers().add(playerEntityRepository.findById(1));
        gameEntityRepository.findById(3).getPlayers().add(playerEntityRepository.findById(3));

    }
}
