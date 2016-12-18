package so.glad.om;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cartoon Zhang
 * @since 2016/12/14 下午10:42
 */
public interface Variable<ID extends Serializable> extends Identifiable<ID> {

    Date getCreatedAt();

    Date getUpdatedAt();

}
