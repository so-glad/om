package so.glad.storage;

import java.io.Serializable;

/**
 * @author Palmtale
 * on 15/5/14.
 */
public interface Domain<ID extends Serializable> extends LifeTimed {

    ID getId();
}
