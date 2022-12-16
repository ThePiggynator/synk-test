package web.vieropnrijsb.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.repositories.EntityRepository;
import web.vieropnrijsb.app.repositories.GamesRepositoryMock;

@SpringBootApplication
public class VieropnrijSbApplication implements CommandLineRunner {

    @Autowired
    EntityRepository<Game> gameEntityRepository;

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
    public void run(String... args) throws Exception {
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(1));
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(2));
        gameEntityRepository.save(GamesRepositoryMock.createSampleGame(3));
    }
}
