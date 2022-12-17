package web.vieropnrijsb.app.repositories;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;
import web.vieropnrijsb.app.models.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Primary
@Repository("USER.JPA")
@Transactional
public class UserRepository implements EntityRepository<User> {

    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public User save(User user) {
        return this.entityManager.merge(user);
    }

    @Override
    public List<User> findAll() {
        TypedQuery<User> query =
                this.entityManager.createQuery(
                        "select u from User u", User.class);
        return query.getResultList();
    }

    @Override
    public User findById(long id) {
        // DONE fix below code to have the author found by the entity manager
        return this.entityManager.find(User.class, id);
    }


    @Override
    public User deleteById(long id) {
        User user = this.findById(id);
        this.entityManager.remove(findById(id));
        return user;
    }
}

