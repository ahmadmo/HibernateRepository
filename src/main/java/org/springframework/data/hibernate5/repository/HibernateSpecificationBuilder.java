package org.springframework.data.hibernate5.repository;

import java.util.function.Consumer;

/**
 * @author ahmad
 */
public abstract class HibernateSpecificationBuilder<E, O> {

    final O delegate;
    final Class<E> entityClass;

    HibernateSpecificationBuilder(O delegate, Class<E> entityClass) {
        this.delegate = delegate;
        this.entityClass = entityClass;
    }

    public abstract IHibernateSpecification<E> use(Consumer<O> action);

    public abstract IHibernateSpecification<E> end();

}
