package so.glad.storage.hibernate;

import org.hibernate.criterion.DetachedCriteria;
import so.glad.common.dao.IDao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Cartoon on 2015/3/4.
 */
public class BaseDaoSupport<Po> extends BaseDao implements IDao<Po> {

    public DetachedCriteria createDetachedCriteria() {
        return DetachedCriteria.forClass(getEntityClass());
    }

    public DetachedCriteria createDetachedCriteria(String alias) {
        return DetachedCriteria.forClass(getEntityClass(), alias);
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Po> retrieveAll() {
        DetachedCriteria criteria = createDetachedCriteria();
        return findByCriteria(criteria);
    }

    @Override
    public void delete(Po entity) {
        getSession().delete(entity);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Po retrieve(Long id) {
        return (Po) getSession().get(getEntityClass(), id);
    }

    @Override
    @SuppressWarnings("unchecked")
    public Po retrieveLazy(Long id) {
        return (Po) getSession().load(getEntityClass(), id);
    }

    @Override
    public void create(Po t) {
        getSession().save(t);
    }

    @Override
    public void createOrUpdate(Po t) {
        getSession().saveOrUpdate(t);
    }

    @Override
    public void update(Po t) {
        getSession().update(t);
    }

    @SuppressWarnings("unchecked")
    public Class<Po> getEntityClass() {
        return (Class<Po>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

}
