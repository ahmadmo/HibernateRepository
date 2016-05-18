package org.springframework.orm.hibernate5.repository;

import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;
import org.springframework.orm.repository.ISpecification;

import java.util.Iterator;
import java.util.List;

/**
 * @author ahmad
 */
public interface IHibernateSpecification<Entity> extends ISpecification<Entity> {

    @Override
    default boolean specified(Entity entity) {
        throw new UnsupportedOperationException();
    }

    Entity get();

    <R> R get(Class<R> returnType);

    boolean exists();

    Entity uniqueResult();

    <R> R uniqueResult(Class<R> returnType);

    Entity findOne();

    <R> R findOne(Class<R> returnType);

    int executeUpdate();

    List<Entity> list();

    <R> List<R> list(Class<R> returnType);

    Iterator iterate();

    ScrollableResults scroll();

    ScrollableResults scroll(ScrollMode scrollMode);

}
