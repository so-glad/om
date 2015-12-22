package so.glad.storage;

import java.io.Serializable;

/**
 * @author Palmtale
 * on 15/5/14.
 */
public interface Static<ID extends Serializable> extends EventTimed {

    ID getId();

}
