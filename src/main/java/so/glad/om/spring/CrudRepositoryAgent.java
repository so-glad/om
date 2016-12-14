package so.glad.om.spring;

import com.google.common.collect.Lists;
import org.springframework.data.repository.CrudRepository;

import java.io.Serializable;

/**
 * @author palmtale
 *         on 15/5/30.
 */
public abstract class CrudRepositoryAgent<T, I extends Serializable> implements CrudRepository<T, I>{

    private CrudRepository<? extends T, I> crudRepository;

    protected void setCrudRepository(CrudRepository<? extends T, I> crudRepository){
        this.crudRepository = crudRepository;
    }

    @Override
    public T findOne(I i) {
        return crudRepository.findOne(i);
    }

    @Override
    public boolean exists(I i) {
        return crudRepository.exists(i);
    }

    @Override
    public Iterable<T> findAll() {
        return Lists.newArrayList(crudRepository.findAll());
    }

    @Override
    public Iterable<T> findAll(Iterable<I> is) {
        return Lists.newArrayList(crudRepository.findAll(is));
    }

    @Override
    public long count() {
        return crudRepository.count();
    }

    @Override
    public void delete(I i) {
        crudRepository.delete(i);
    }

    @Override
    public void deleteAll() {
        crudRepository.deleteAll();
    }
}
