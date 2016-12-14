package so.glad.om;

import java.io.Serializable;

/**
 * A kind of characteristic, expressed the thing/object can
 * be found retrieved by its id.
 *
 * @author Cartoon Zhang
 * @since 2016/12/14 下午10:36
 */
public interface Identifiable<ID extends Serializable> {
    ID getId();
}
