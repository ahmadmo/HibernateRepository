package org.springframework.orm.hibernate5.repository;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.orm.repository.IRepository;
import org.springframework.orm.repository.ISpecification;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author ahmad
 */
public class HibernateRepository<Entity, Identifier extends Serializable>
        extends HibernateDaoSupport
        implements IRepository<Entity, Identifier> {

    private final Class<Entity> entityClass;

    public HibernateRepository(Class<Entity> entityClass, SessionFactory sessionFactory) {
        this.entityClass = Objects.requireNonNull(entityClass);
        setSessionFactory(sessionFactory);
    }

    public Class<Entity> getEntityClass() {
        return entityClass;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Identifier add(Entity entity) {
        return (Identifier) getHibernateTemplate().save(entity);
    }

    @Override
    public void remove(Entity entity) {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void update(Entity entity) {
        getHibernateTemplate().update(entity);
    }

    @Override
    public Entity get(Identifier id) {
        return getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public List<Entity> list() {
        return getHibernateTemplate().loadAll(entityClass);
    }

    @Override
    public List<Entity> list(ISpecification<Entity> specification) {
        return list().stream().filter(specification::specified).collect(Collectors.toList());
    }

    public HibernateSpecificationBuilder<Entity, Query> query(String queryString) {
        return new QuerySpecification.Builder<>(currentSession().createQuery(queryString), entityClass);
    }

    public HibernateSpecificationBuilder<Entity, SQLQuery> sqlQuery(String queryString) {
        return new SQLQuerySpecification.Builder<>(currentSession().createSQLQuery(queryString), entityClass);
    }

    public HibernateSpecificationBuilder<Entity, Query> namedQuery(String queryName) {
        return new QuerySpecification.Builder<>(currentSession().getNamedQuery(queryName), entityClass);
    }

    public HibernateSpecificationBuilder<Entity, SQLQuery> namedNativeQuery(String queryName) {
        return new SQLQuerySpecification.Builder<>((SQLQuery) currentSession().getNamedQuery(queryName), entityClass);
    }

    public HibernateSpecificationBuilder<Entity, Criteria> criteria() {
        return new CriteriaSpecification.Builder<>(currentSession().createCriteria(entityClass), entityClass);
    }

    public HibernateSpecificationBuilder<Entity, Criteria> criteria(String alias) {
        return new CriteriaSpecification.Builder<>(currentSession().createCriteria(entityClass, alias), entityClass);
    }

}
