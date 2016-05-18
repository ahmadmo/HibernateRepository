package org.springframework.data.hibernate5.repository;

import org.hibernate.Criteria;
import org.hibernate.ScrollMode;
import org.hibernate.ScrollableResults;

import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author ahmad
 */
final class CriteriaSpecification<Entity> implements IHibernateSpecification<Entity> {

    private final Criteria criteria;
    private final Class<Entity> entityClass;

    private CriteriaSpecification(Criteria criteria, Class<Entity> entityClass) {
        this.criteria = criteria;
        this.entityClass = entityClass;
    }

    @Override
    public Entity get() {
        return get(entityClass);
    }

    @Override
    public <R> R get(Class<R> returnType) {
        return returnType.cast(criteria.uniqueResult());
    }

    @Override
    public boolean exists() {
        return criteria.uniqueResult() != null;
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
        List list = criteria.setMaxResults(1).list();
        return list.isEmpty() ? null : returnType.cast(list.get(0));
    }

    @Override
    public int executeUpdate() {
        throw new UnsupportedOperationException();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Entity> list() {
        return criteria.list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public <R> List<R> list(Class<R> returnType) {
        return criteria.list();
    }

    @Override
    public Iterator iterate() {
        return criteria.list().iterator();
    }

    @Override
    public ScrollableResults scroll() {
        return criteria.scroll();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        return criteria.scroll(scrollMode);
    }

    static final class Builder<E> extends HibernateSpecificationBuilder<E, Criteria> {

        Builder(Criteria criteria, Class<E> entityClass) {
            super(criteria, entityClass);
        }

        @Override
        public CriteriaSpecification<E> use(Consumer<Criteria> action) {
            action.accept(new CriteriaProxy(delegate));
            return end();
        }

        @Override
        public CriteriaSpecification<E> end() {
            return new CriteriaSpecification<>(delegate, entityClass);
        }

    }

}
