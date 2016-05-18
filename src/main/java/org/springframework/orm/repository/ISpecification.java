package org.springframework.orm.repository;

/**
 * @author ahmad
 */
@FunctionalInterface
public interface ISpecification<Entity> {

    boolean specified(Entity entity);

}
