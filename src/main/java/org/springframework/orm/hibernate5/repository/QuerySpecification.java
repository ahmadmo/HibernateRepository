package org.springframework.orm.hibernate5.repository;

import org.hibernate.Query;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ahmad
 */
final class QuerySpecification<Entity> implements IHibernateSpecification<Entity> {

    private final Query query;
    private final Class<Entity> entityClass;

    private QuerySpecification(Query query, Class<Entity> entityClass) {
        this.query = query;
        this.entityClass = entityClass;
    }

    @Override
    public Entity get() {
        return get(entityClass);
    }

    @Override
    public <R> R get(Class<R> returnType) {
        return returnType.cast(query.uniqueResult());
    }

    @Override
    public boolean exists() {
        return query.uniqueResult() != null;
    }

    @Override
    public Entity uniqueResult() {
        return get();
    }

    @Override
    public <R> R uniqueResult(Class<R> returnType) {
        return get(returnType);
    }

    @Override
    public Entity findOne() {
        return findOne(entityClass);
    }

    @Override
    public <R> R findOne(Class<R> returnType) {
        List list = query.setMaxResults(1).list();
        return list.isEmpty() ? null : returnType.cast(list.get(0));
    }

    @Override
    public int executeUpdate() {
        return query.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> list() {
        return query.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> List<R> list(Class<R> returnType) {
        return query.list();
    }

    @Override
    public Iterator iterate() {
        return query.iterate();
    }

    @Override
    public ScrollableResults scroll() {
        return query.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return query.scroll(scrollMode);
    }

    static final class Builder<E> extends HibernateSpecificationBuilder<E, Query> {

        Builder(Query query, Class<E> entityClass) {
            super(query, entityClass);
        }

        @Override
        public QuerySpecification<E> use(Consumer<Query> action) {
            action.accept(new QueryProxy(delegate));
            return end();
        }

        @Override
        public QuerySpecification<E> end() {
            return new QuerySpecification<>(delegate, entityClass);
        }

    }

}
