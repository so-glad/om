package so.glad.storage;

import java.util.Date;

/**
 * @author Cartoon
 * on 2015/3/10.
 */
public interface EventTimed {

    public Date getTimestamp();

    public void setTimestamp(Date timestamp);

}
