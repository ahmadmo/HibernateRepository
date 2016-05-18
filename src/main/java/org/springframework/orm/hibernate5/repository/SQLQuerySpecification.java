package org.springframework.orm.hibernate5.repository;

import org.hibernate.SQLQuery;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ahmad
 */
final class SQLQuerySpecification<Entity> implements IHibernateSpecification<Entity> {

    private final SQLQuery sqlQuery;
    private final Class<Entity> entityClass;

    private SQLQuerySpecification(SQLQuery sqlQuery, Class<Entity> entityClass) {
        this.sqlQuery = sqlQuery;
        this.entityClass = entityClass;
    }

    @Override
    public Entity get() {
        return get(entityClass);
    }

    @Override
    public <R> R get(Class<R> returnType) {
        return returnType.cast(sqlQuery.uniqueResult());
    }

    @Override
    public boolean exists() {
        return sqlQuery.uniqueResult() != null;
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
        List list = sqlQuery.setMaxResults(1).list();
        return list.isEmpty() ? null : returnType.cast(list.get(0));
    }

    @Override
    public int executeUpdate() {
        return sqlQuery.executeUpdate();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> list() {
        return sqlQuery.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> List<R> list(Class<R> returnType) {
        return sqlQuery.list();
    }

    @Override
    public Iterator iterate() {
        return sqlQuery.iterate();
    }

    @Override
    public ScrollableResults scroll() {
        return sqlQuery.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return sqlQuery.scroll(scrollMode);
    }

    static final class Builder<E> extends HibernateSpecificationBuilder<E, SQLQuery> {

        Builder(SQLQuery sqlQuery, Class<E> entityClass) {
            super(sqlQuery, entityClass);
        }

        @Override
        public SQLQuerySpecification<E> use(Consumer<SQLQuery> action) {
            action.accept(new SQLQueryProxy(delegate));
            return end();
        }

        @Override
        public SQLQuerySpecification<E> end() {
            return new SQLQuerySpecification<>(delegate, entityClass);
        }

    }

}
