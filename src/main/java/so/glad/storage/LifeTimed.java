package so.glad.storage;

import java.util.Date;

/**
 * @author Cartoon
 * on 2015/3/10.
 */
public interface LifeTimed {

    public Date getCreatedDate();


    public void setCreatedDate(Date createdDate);


    public Date getLastModifiedDate() ;


    public void setLastModifiedDate(Date lastModifiedDate);
}
