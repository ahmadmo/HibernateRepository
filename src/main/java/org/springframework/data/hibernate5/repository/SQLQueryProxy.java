package org.springframework.data.hibernate5.repository;

import org.hibernate.LockMode;
import org.hibernate.MappingException;
import org.hibernate.SQLQuery;
import org.hibernate.engine.query.spi.sql.NativeSQLQueryReturn;
import org.hibernate.type.Type;

import java.util.Collection;
import java.util.List;

/**
 * @author ahmad
 */
final class SQLQueryProxy extends QueryProxy implements SQLQuery {

    private final SQLQuery delegate;

    SQLQueryProxy(SQLQuery delegate) {
        super(delegate);
        this.delegate = delegate;
    }

    @Override
    public Collection<String> getSynchronizedQuerySpaces() {
        return delegate.getSynchronizedQuerySpaces();
    }

    @Override
    public SQLQuery addSynchronizedQuerySpace(String querySpace) {
        return delegate.addSynchronizedQuerySpace(querySpace);
    }

    @Override
    public SQLQuery addSynchronizedEntityName(String entityName) throws MappingException {
        return delegate.addSynchronizedEntityName(entityName);
    }

    @Override
    public SQLQuery addSynchronizedEntityClass(Class entityClass) throws MappingException {
        return delegate.addSynchronizedEntityClass(entityClass);
    }

    @Override
    public SQLQuery setResultSetMapping(String name) {
        return delegate.setResultSetMapping(name);
    }

    @Override
    public boolean isCallable() {
        return delegate.isCallable();
    }

    @Override
    public List<NativeSQLQueryReturn> getQueryReturns() {
        return delegate.getQueryReturns();
    }

    @Override
    public SQLQuery addScalar(String columnAlias) {
        return delegate.addScalar(columnAlias);
    }

    @Override
    public SQLQuery addScalar(String columnAlias, Type type) {
        return delegate.addScalar(columnAlias, type);
    }

    @Override
    public RootReturn addRoot(String tableAlias, String entityName) {
        return delegate.addRoot(tableAlias, entityName);
    }

    @Override
    public RootReturn addRoot(String tableAlias, Class entityType) {
        return delegate.addRoot(tableAlias, entityType);
    }

    @Override
    public SQLQuery addEntity(String entityName) {
        return delegate.addEntity(entityName);
    }

    @Override
    public SQLQuery addEntity(String tableAlias, String entityName) {
        return delegate.addEntity(tableAlias, entityName);
    }

    @Override
    public SQLQuery addEntity(String tableAlias, String entityName, LockMode lockMode) {
        return delegate.addEntity(tableAlias, entityName, lockMode);
    }

    @Override
    public SQLQuery addEntity(Class entityType) {
        return delegate.addEntity(entityType);
    }

    @Override
    public SQLQuery addEntity(String tableAlias, Class entityType) {
        return delegate.addEntity(tableAlias, entityType);
    }

    @Override
    public SQLQuery addEntity(String tableAlias, Class entityName, LockMode lockMode) {
        return delegate.addEntity(tableAlias, entityName, lockMode);
    }

    @Override
    public FetchReturn addFetch(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return delegate.addFetch(tableAlias, ownerTableAlias, joinPropertyName);
    }

    @Override
    public SQLQuery addJoin(String tableAlias, String path) {
        return delegate.addJoin(tableAlias, path);
    }

    @Override
    public SQLQuery addJoin(String tableAlias, String ownerTableAlias, String joinPropertyName) {
        return delegate.addJoin(tableAlias, ownerTableAlias, joinPropertyName);
    }

    @Override
    public SQLQuery addJoin(String tableAlias, String path, LockMode lockMode) {
        return delegate.addJoin(tableAlias, path, lockMode);
    }

}
