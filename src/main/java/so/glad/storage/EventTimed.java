package so.glad.storage;

import java.util.Date;

/**
 * @author Palmtale
 * on 2015/3/10.
 */
public interface EventTimed {

    Date getTimestamp();

    void setTimestamp(Date timestamp);

}
