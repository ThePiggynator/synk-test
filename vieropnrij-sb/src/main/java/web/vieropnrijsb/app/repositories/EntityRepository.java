package web.vieropnrijsb.app.repositories;

import java.util.List;

public interface EntityRepository <E>{
    List<E> findAll();          // finds all available instances
    E findById(long id);        // finds one specific instance
    E save(E entity);           // saves the entity into the repo
    // creates a new instance if entity.id == 0
    // updates exisiting instance if entity.id != 0
    E deleteById(long id);      // deletes the instance identified by entity.getId()
    // returns the instance that has been deleted or null
}
