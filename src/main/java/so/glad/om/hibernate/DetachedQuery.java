package so.glad.om.hibernate;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.transform.ResultTransformer;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * @author Cartoon
 * on 2015/3/4.
 */
public interface DetachedQuery {
    Query getExecutableQuery(Session session);

    DetachedQuery setMaxResults(int maxResults);

    DetachedQuery setFirstResult(int firstResult);

    DetachedQuery setReadOnly(boolean readOnly);

    DetachedQuery setCacheable(boolean cacheable);

    DetachedQuery setCacheRegion(String cacheRegion);

    DetachedQuery setTimeout(int timeout);

    DetachedQuery setFetchSize(int fetchSize);

    DetachedQuery setLockMode(String alias, LockMode lockMode);

    DetachedQuery setComment(String comment);

    DetachedQuery setFlushMode(FlushMode flushMode);

    DetachedQuery setCacheMode(CacheMode cacheMode);

    DetachedQuery setParameter(int position, Object val, Type type);

    DetachedQuery setParameter(String name, Object val, Type type);

    DetachedQuery setParameter(int position, Object val) throws HibernateException;

    DetachedQuery setParameter(String name, Object val) throws HibernateException;

    DetachedQuery setParameters(Object[] values, Type[] types) throws HibernateException;

    DetachedQuery setParameterList(String name, Collection<?> vals, Type type) throws HibernateException;

    DetachedQuery setParameterList(String name, Collection<?> vals) throws HibernateException;

    DetachedQuery setParameterList(String name, Object[] vals, Type type) throws HibernateException;

    DetachedQuery setParameterList(String name, Object[] vals) throws HibernateException;

    DetachedQuery setProperties(Object bean) throws HibernateException;

    DetachedQuery setProperties(Map<?, ?> bean) throws HibernateException;

    DetachedQuery setString(int position, String val);

    DetachedQuery setCharacter(int position, char val);

    DetachedQuery setBoolean(int position, boolean val);

    DetachedQuery setByte(int position, byte val);

    DetachedQuery setShort(int position, short val);

    DetachedQuery setInteger(int position, int val);

    DetachedQuery setLong(int position, long val);

    DetachedQuery setFloat(int position, float val);

    DetachedQuery setDouble(int position, double val);

    DetachedQuery setBinary(int position, byte[] val);

    DetachedQuery setText(int position, String val);

    DetachedQuery setSerializable(int position, Serializable val);

    DetachedQuery setLocale(int position, Locale locale);

    DetachedQuery setBigDecimal(int position, BigDecimal number);

    DetachedQuery setBigInteger(int position, BigInteger number);

    DetachedQuery setDate(int position, Date date);

    DetachedQuery setTime(int position, Date date);

    DetachedQuery setTimestamp(int position, Date date);

    DetachedQuery setCalendar(int position, Calendar calendar);

    DetachedQuery setCalendarDate(int position, Calendar calendar);

    DetachedQuery setString(String name, String val);

    DetachedQuery setCharacter(String name, char val);

    DetachedQuery setBoolean(String name, boolean val);

    DetachedQuery setByte(String name, byte val);

    DetachedQuery setShort(String name, short val);

    DetachedQuery setInteger(String name, int val);

    DetachedQuery setLong(String name, long val);

    DetachedQuery setFloat(String name, float val);

    DetachedQuery setDouble(String name, double val);

    DetachedQuery setBinary(String name, byte[] val);

    DetachedQuery setText(String name, String val);

    DetachedQuery setSerializable(String name, Serializable val);

    DetachedQuery setLocale(String name, Locale locale);

    DetachedQuery setBigDecimal(String name, BigDecimal number);

    DetachedQuery setBigInteger(String name, BigInteger number);

    DetachedQuery setDate(String name, Date date);

    DetachedQuery setTime(String name, Date date);

    DetachedQuery setTimestamp(String name, Date date);

    DetachedQuery setCalendar(String name, Calendar calendar);

    DetachedQuery setCalendarDate(String name, Calendar calendar);

    DetachedQuery setEntity(int position, Object val); // use setParameter for

    DetachedQuery setEntity(String name, Object val); // use setParameter for

    DetachedQuery setResultTransformer(ResultTransformer transformer);
}
