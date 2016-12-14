package so.glad.om.hibernate;

import org.hibernate.*;
import org.hibernate.query.Query;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

/**
 * @author by Cartoon
 * on 2015/3/4.
 */
public class BaseDataAccessor {

    private SessionFactory sessionFactory;

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    public int executeUpdate(final DetachedQuery detachedQuery) {
        Query query = detachedQuery.getExecutableQuery(this.getSession());
        return query.executeUpdate();
    }

    public Object findUniqueResultByQuery(final DetachedQuery detachedQuery) {
        Query query = detachedQuery.getExecutableQuery(this.getSession());
        return query.uniqueResult();
    }

    @SuppressWarnings("rawtypes")
    public List findByQuery(final DetachedQuery detachedQuery) {
        Query query = detachedQuery.getExecutableQuery(this.getSession());
        return query.list();
    }

    @SuppressWarnings("unchecked")
    public Object findUniqueResultByCriteria(DetachedCriteria criteria) {
        Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
        return executableCriteria.uniqueResult();
    }

    @SuppressWarnings("rawtypes")
    public List findByCriteria(DetachedCriteria criteria) {
        Criteria executableCriteria = criteria.getExecutableCriteria(this.getSession());
        return executableCriteria.list();
    }

    public static <T> T uniqueElement(List<T> list) throws NonUniqueResultException {
        int size = list.size();
        if (size == 0)
            return null;
        T first = list.get(0);
        for (int i = 1; i < size; i++) {
            if (list.get(i) != first) {
                throw new NonUniqueResultException(list.size());
            }
        }
        return first;
    }
}
