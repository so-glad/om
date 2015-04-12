package so.glad.storage;

import java.util.Date;

/**
 * Created by Cartoon on 2015/3/10.
 */
public interface EventTimed {

    public Date getTimestamp();

    public void setTimestamp(Date timestamp);

}
