package org.springframework.data.hibernate5.repository;

import org.hibernate.*;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.ResultTransformer;

import java.util.List;

/**
 * @author ahmad
 */
final class CriteriaProxy implements Criteria {

    private final Criteria delegate;

    CriteriaProxy(Criteria delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getAlias() {
        return delegate.getAlias();
    }

    @Override
    public Criteria setProjection(Projection projection) {
        return delegate.setProjection(projection);
    }

    @Override
    public Criteria add(Criterion criterion) {
        return delegate.add(criterion);
    }

    @Override
    public Criteria addOrder(Order order) {
        return delegate.addOrder(order);
    }

    @Override
    public Criteria setFetchMode(String associationPath, FetchMode mode) throws HibernateException {
        return delegate.setFetchMode(associationPath, mode);
    }

    @Override
    public Criteria setLockMode(LockMode lockMode) {
        return delegate.setLockMode(lockMode);
    }

    @Override
    public Criteria setLockMode(String alias, LockMode lockMode) {
        return delegate.setLockMode(alias, lockMode);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias) throws HibernateException {
        return delegate.createAlias(associationPath, alias);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType) throws HibernateException {
        return delegate.createAlias(associationPath, alias, joinType);
    }

    @Override
    @Deprecated
    public Criteria createAlias(String associationPath, String alias, int joinType) throws HibernateException {
        return delegate.createAlias(associationPath, alias, joinType);
    }

    @Override
    public Criteria createAlias(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        return delegate.createAlias(associationPath, alias, joinType, withClause);
    }

    @Override
    @Deprecated
    public Criteria createAlias(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        return delegate.createAlias(associationPath, alias, joinType, withClause);
    }

    @Override
    public Criteria createCriteria(String associationPath) throws HibernateException {
        return delegate.createCriteria(associationPath);
    }

    @Override
    public Criteria createCriteria(String associationPath, JoinType joinType) throws HibernateException {
        return delegate.createCriteria(associationPath, joinType);
    }

    @Override
    @Deprecated
    public Criteria createCriteria(String associationPath, int joinType) throws HibernateException {
        return delegate.createCriteria(associationPath, joinType);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias) throws HibernateException {
        return delegate.createCriteria(associationPath, alias);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, JoinType joinType) throws HibernateException {
        return delegate.createCriteria(associationPath, alias, joinType);
    }

    @Override
    @Deprecated
    public Criteria createCriteria(String associationPath, String alias, int joinType) throws HibernateException {
        return delegate.createCriteria(associationPath, alias, joinType);
    }

    @Override
    public Criteria createCriteria(String associationPath, String alias, JoinType joinType, Criterion withClause) throws HibernateException {
        return delegate.createCriteria(associationPath, alias, joinType, withClause);
    }

    @Override
    @Deprecated
    public Criteria createCriteria(String associationPath, String alias, int joinType, Criterion withClause) throws HibernateException {
        return delegate.createCriteria(associationPath, alias, joinType, withClause);
    }

    @Override
    public Criteria setResultTransformer(ResultTransformer resultTransformer) {
        return delegate.setResultTransformer(resultTransformer);
    }

    @Override
    public Criteria setMaxResults(int maxResults) {
        return delegate.setMaxResults(maxResults);
    }

    @Override
    public Criteria setFirstResult(int firstResult) {
        return delegate.setFirstResult(firstResult);
    }

    @Override
    public boolean isReadOnlyInitialized() {
        return delegate.isReadOnlyInitialized();
    }

    @Override
    public boolean isReadOnly() {
        return delegate.isReadOnly();
    }

    @Override
    public Criteria setReadOnly(boolean readOnly) {
        return delegate.setReadOnly(readOnly);
    }

    @Override
    public Criteria setFetchSize(int fetchSize) {
        return delegate.setFetchSize(fetchSize);
    }

    @Override
    public Criteria setTimeout(int timeout) {
        return delegate.setTimeout(timeout);
    }

    @Override
    public Criteria setCacheable(boolean cacheable) {
        return delegate.setCacheable(cacheable);
    }

    @Override
    public Criteria setCacheRegion(String cacheRegion) {
        return delegate.setCacheRegion(cacheRegion);
    }

    @Override
    public Criteria setComment(String comment) {
        return delegate.setComment(comment);
    }

    @Override
    public Criteria addQueryHint(String hint) {
        return delegate.addQueryHint(hint);
    }

    @Override
    public Criteria setFlushMode(FlushMode flushMode) {
        return delegate.setFlushMode(flushMode);
    }

    @Override
    public Criteria setCacheMode(CacheMode cacheMode) {
        return delegate.setCacheMode(cacheMode);
    }

    @Override
    public List list() throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScrollableResults scroll() throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) throws HibernateException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object uniqueResult() throws HibernateException {
        throw new UnsupportedOperationException();
    }

}
