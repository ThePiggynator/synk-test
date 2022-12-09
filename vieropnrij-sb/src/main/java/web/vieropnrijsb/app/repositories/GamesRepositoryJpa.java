package web.vieropnrijsb.app.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import web.vieropnrijsb.app.models.Game;

import javax.transaction.Transactional;
import java.util.Date;

public interface GamesRepositoryJpa extends JpaRepository<Game, Integer>{

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO game [`title`, `status`, `maxThinkTime`, `rated`, `createdAt`, `createdBy`] VALUES (?1,?2, ?3, ?4, ?5, ?6)", nativeQuery = true)
    void save(String title, String status, int maxThinkTime, boolean rated, String createdAt, String createdBy);

}
