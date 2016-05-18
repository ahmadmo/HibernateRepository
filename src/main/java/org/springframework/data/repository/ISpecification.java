package org.springframework.data.repository;

/**
 * @author ahmad
 */
@FunctionalInterface
public interface ISpecification<Entity> {

    boolean specified(Entity entity);

}
