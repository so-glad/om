package so.glad.om;

import java.util.List;

/**
 * @author Palmtale
 * on 2015/3/4.
 */
public interface DataAccessible<Po> {

    void create(Po entity);

    void update(Po entity);

    void createOrUpdate(Po entity);

    void delete(Po entity);

    Po retrieve(Long id);

    List<Po> retrieveAll();

    Po retrieveLazy(Long id);

}
