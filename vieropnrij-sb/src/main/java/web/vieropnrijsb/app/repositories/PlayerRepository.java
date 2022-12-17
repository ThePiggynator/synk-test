package web.vieropnrijsb.app.repositories;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import web.vieropnrijsb.app.models.Game;
import web.vieropnrijsb.app.models.Player;
import web.vieropnrijsb.app.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository("PLAYER.JPA")
@Transactional
public class PlayerRepository implements EntityRepository<Player> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public Player save(Player player) {
        return this.entityManager.merge(player);
    }

    @Override
    public List<Player> findAll() {
        TypedQuery<Player> query =
                this.entityManager.createQuery(
                        "select p from Player p", Player.class);
        return query.getResultList();
    }

    @Override
    public Player findById(long id) {
        // DONE fix below code to have the author found by the entity manager
        return this.entityManager.find(Player.class, id);
    }


    @Override
    public Player deleteById(long id) {
        Player player = this.findById(id);
        this.entityManager.remove(findById(id));
        return player;
    }

    public boolean alreadyInGame(Game game, User user){
        return true;
    }
}






