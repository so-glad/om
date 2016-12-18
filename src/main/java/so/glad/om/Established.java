package so.glad.om;

import java.io.Serializable;
import java.util.Date;

/**
 * A kind of characteristic, express some persistent object is a
 * established, immutable, record, something like log, historic event.
 *
 * @author Palmtale
 * on 15/5/14.
 */
public interface Established<ID extends Serializable> extends Identifiable<ID> {

    Date getTimestamp();

}
