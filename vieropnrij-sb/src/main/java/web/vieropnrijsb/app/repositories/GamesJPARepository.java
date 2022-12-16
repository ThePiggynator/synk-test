package web.vieropnrijsb.app.repositories;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import web.vieropnrijsb.app.models.Game;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Primary
@Repository("GAMES.JPA")
@Transactional
public class GamesJPARepository
        implements EntityRepository<Game> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Game save(Game game) {
        return this.entityManager.merge(game);
    }

    @Override
    public List<Game> findAll() {
        TypedQuery<Game> query =
                this.entityManager.createQuery(
                        "select g from Game g", Game.class);
        return query.getResultList();
    }

    @Override
    public Game findById(long id) {
        // DONE fix below code to have the author found by the entity manager
        return this.entityManager.find(Game.class, id);
    }



    @Override
    public Game deleteById(long id) {
        Game game = this.findById(id);
        TypedQuery<Game> query =
                this.entityManager.createQuery(
                        "DELETE FROM Game g WHERE g.id = "+id, Game.class);
        return game;
    }
}





