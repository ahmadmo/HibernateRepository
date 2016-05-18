package org.springframework.data.hibernate5.repository;

import org.hibernate.*;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author ahmad
 */
class QueryProxy implements Query {

    private final Query delegate;

    QueryProxy(Query delegate) {
        this.delegate = delegate;
    }

    @Override
    public String getQueryString() {
        return delegate.getQueryString();
    }

    @Override
    public Integer getMaxResults() {
        return delegate.getMaxResults();
    }

    @Override
    public Query setMaxResults(int maxResults) {
        return delegate.setMaxResults(maxResults);
    }

    @Override
    public Integer getFirstResult() {
        return delegate.getFirstResult();
    }

    @Override
    public Query setFirstResult(int firstResult) {
        return delegate.setFirstResult(firstResult);
    }

    @Override
    public FlushMode getFlushMode() {
        return delegate.getFlushMode();
    }

    @Override
    public Query setFlushMode(FlushMode flushMode) {
        return delegate.setFlushMode(flushMode);
    }

    @Override
    public CacheMode getCacheMode() {
        return delegate.getCacheMode();
    }

    @Override
    public Query setCacheMode(CacheMode cacheMode) {
        return delegate.setCacheMode(cacheMode);
    }

    @Override
    public boolean isCacheable() {
        return delegate.isCacheable();
    }

    @Override
    public Query setCacheable(boolean cacheable) {
        return delegate.setCacheable(cacheable);
    }

    @Override
    public String getCacheRegion() {
        return delegate.getCacheRegion();
    }

    @Override
    public Query setCacheRegion(String cacheRegion) {
        return delegate.setCacheRegion(cacheRegion);
    }

    @Override
    public Integer getTimeout() {
        return delegate.getTimeout();
    }

    @Override
    public Query setTimeout(int timeout) {
        return delegate.setTimeout(timeout);
    }

    @Override
    public Integer getFetchSize() {
        return delegate.getFetchSize();
    }

    @Override
    public Query setFetchSize(int fetchSize) {
        return delegate.setFetchSize(fetchSize);
    }

    @Override
    public boolean isReadOnly() {
        return delegate.isReadOnly();
    }

    @Override
    public Query setReadOnly(boolean readOnly) {
        return delegate.setReadOnly(readOnly);
    }

    @Override
    public Type[] getReturnTypes() {
        return delegate.getReturnTypes();
    }

    @Override
    public LockOptions getLockOptions() {
        return delegate.getLockOptions();
    }

    @Override
    public Query setLockOptions(LockOptions lockOptions) {
        return delegate.setLockOptions(lockOptions);
    }

    @Override
    public Query setLockMode(String alias, LockMode lockMode) {
        return delegate.setLockMode(alias, lockMode);
    }

    @Override
    public String getComment() {
        return delegate.getComment();
    }

    @Override
    public Query setComment(String comment) {
        return delegate.setComment(comment);
    }

    @Override
    public Query addQueryHint(String hint) {
        return delegate.addQueryHint(hint);
    }

    @Override
    public String[] getReturnAliases() {
        return delegate.getReturnAliases();
    }

    @Override
    public String[] getNamedParameters() {
        return delegate.getNamedParameters();
    }

    @Override
    public Iterator iterate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScrollableResults scroll() {
        throw new UnsupportedOperationException();
    }

    @Override
    public ScrollableResults scroll(ScrollMode scrollMode) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List list() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Object uniqueResult() {
        throw new UnsupportedOperationException();
    }

    @Override
    public int executeUpdate() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Query setParameter(int position, Object val, Type type) {
        return delegate.setParameter(position, val, type);
    }

    @Override
    public Query setParameter(String name, Object val, Type type) {
        return delegate.setParameter(name, val, type);
    }

    @Override
    public Query setParameter(int position, Object val) {
        return delegate.setParameter(position, val);
    }

    @Override
    public Query setParameter(String name, Object val) {
        return delegate.setParameter(name, val);
    }

    @Override
    public Query setParameters(Object[] values, Type[] types) {
        return delegate.setParameters(values, types);
    }

    @Override
    public Query setParameterList(String name, Collection values, Type type) {
        return delegate.setParameterList(name, values, type);
    }

    @Override
    public Query setParameterList(String name, Collection values) {
        return delegate.setParameterList(name, values);
    }

    @Override
    public Query setParameterList(String name, Object[] values, Type type) {
        return delegate.setParameterList(name, values, type);
    }

    @Override
    public Query setParameterList(String name, Object[] values) {
        return delegate.setParameterList(name, values);
    }

    @Override
    public Query setProperties(Object bean) {
        return delegate.setProperties(bean);
    }

    @Override
    public Query setProperties(Map bean) {
        return delegate.setProperties(bean);
    }

    @Override
    public Query setString(int position, String val) {
        return delegate.setString(position, val);
    }

    @Override
    public Query setCharacter(int position, char val) {
        return delegate.setCharacter(position, val);
    }

    @Override
    public Query setBoolean(int position, boolean val) {
        return delegate.setBoolean(position, val);
    }

    @Override
    public Query setByte(int position, byte val) {
        return delegate.setByte(position, val);
    }

    @Override
    public Query setShort(int position, short val) {
        return delegate.setShort(position, val);
    }

    @Override
    public Query setInteger(int position, int val) {
        return delegate.setInteger(position, val);
    }

    @Override
    public Query setLong(int position, long val) {
        return delegate.setLong(position, val);
    }

    @Override
    public Query setFloat(int position, float val) {
        return delegate.setFloat(position, val);
    }

    @Override
    public Query setDouble(int position, double val) {
        return delegate.setDouble(position, val);
    }

    @Override
    public Query setBinary(int position, byte[] val) {
        return delegate.setBinary(position, val);
    }

    @Override
    public Query setText(int position, String val) {
        return delegate.setText(position, val);
    }

    @Override
    public Query setSerializable(int position, Serializable val) {
        return delegate.setSerializable(position, val);
    }

    @Override
    public Query setLocale(int position, Locale locale) {
        return delegate.setLocale(position, locale);
    }

    @Override
    public Query setBigDecimal(int position, BigDecimal number) {
        return delegate.setBigDecimal(position, number);
    }

    @Override
    public Query setBigInteger(int position, BigInteger number) {
        return delegate.setBigInteger(position, number);
    }

    @Override
    public Query setDate(int position, Date date) {
        return delegate.setDate(position, date);
    }

    @Override
    public Query setTime(int position, Date date) {
        return delegate.setTime(position, date);
    }

    @Override
    public Query setTimestamp(int position, Date date) {
        return delegate.setTimestamp(position, date);
    }

    @Override
    public Query setCalendar(int position, Calendar calendar) {
        return delegate.setCalendar(position, calendar);
    }

    @Override
    public Query setCalendarDate(int position, Calendar calendar) {
        return delegate.setCalendarDate(position, calendar);
    }

    @Override
    public Query setString(String name, String val) {
        return delegate.setString(name, val);
    }

    @Override
    public Query setCharacter(String name, char val) {
        return delegate.setCharacter(name, val);
    }

    @Override
    public Query setBoolean(String name, boolean val) {
        return delegate.setBoolean(name, val);
    }

    @Override
    public Query setByte(String name, byte val) {
        return delegate.setByte(name, val);
    }

    @Override
    public Query setShort(String name, short val) {
        return delegate.setShort(name, val);
    }

    @Override
    public Query setInteger(String name, int val) {
        return delegate.setInteger(name, val);
    }

    @Override
    public Query setLong(String name, long val) {
        return delegate.setLong(name, val);
    }

    @Override
    public Query setFloat(String name, float val) {
        return delegate.setFloat(name, val);
    }

    @Override
    public Query setDouble(String name, double val) {
        return delegate.setDouble(name, val);
    }

    @Override
    public Query setBinary(String name, byte[] val) {
        return delegate.setBinary(name, val);
    }

    @Override
    public Query setText(String name, String val) {
        return delegate.setText(name, val);
    }

    @Override
    public Query setSerializable(String name, Serializable val) {
        return delegate.setSerializable(name, val);
    }

    @Override
    public Query setLocale(String name, Locale locale) {
        return delegate.setLocale(name, locale);
    }

    @Override
    public Query setBigDecimal(String name, BigDecimal number) {
        return delegate.setBigDecimal(name, number);
    }

    @Override
    public Query setBigInteger(String name, BigInteger number) {
        return delegate.setBigInteger(name, number);
    }

    @Override
    public Query setDate(String name, Date date) {
        return delegate.setDate(name, date);
    }

    @Override
    public Query setTime(String name, Date date) {
        return delegate.setTime(name, date);
    }

    @Override
    public Query setTimestamp(String name, Date date) {
        return delegate.setTimestamp(name, date);
    }

    @Override
    public Query setCalendar(String name, Calendar calendar) {
        return delegate.setCalendar(name, calendar);
    }

    @Override
    public Query setCalendarDate(String name, Calendar calendar) {
        return delegate.setCalendarDate(name, calendar);
    }

    @Override
    public Query setEntity(int position, Object val) {
        return delegate.setEntity(position, val);
    }

    @Override
    public Query setEntity(String name, Object val) {
        return delegate.setEntity(name, val);
    }

    @Override
    public Query setResultTransformer(ResultTransformer transformer) {
        return delegate.setResultTransformer(transformer);
    }

}
