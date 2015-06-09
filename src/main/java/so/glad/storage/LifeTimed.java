package so.glad.storage;

import java.util.Date;

/**
 * @author Palmtale
 * on 2015/3/10.
 */
public interface LifeTimed {

    Date getCreatedDate();


    void setCreatedDate(Date createdDate);


    Date getLastModifiedDate() ;


    void setLastModifiedDate(Date lastModifiedDate);
}
