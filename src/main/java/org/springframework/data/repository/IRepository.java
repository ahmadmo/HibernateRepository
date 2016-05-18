package org.springframework.data.repository;

import java.io.Serializable;
import java.util.List;

/**
 * @author ahmad
 */
public interface IRepository<Entity, Identifier extends Serializable> {

    Identifier add(Entity entity);

    void remove(Entity entity);

    void update(Entity entity);

    Entity get(Identifier id);

    List<Entity> list();

    List<Entity> list(ISpecification<Entity> specification);

}
