package so.glad.om.mongodb;

import org.springframework.data.annotation.Id;
import so.glad.om.Variable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cartoon
 *         on 2015/6/9.
 */
public class AbstractDomain<ID extends Serializable> implements Variable<ID> {

    private ID id;

    private Date createdDate;

    private Date lastModifiedDate;

    @Id
    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public Date getCreatedAt() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getUpdatedAt() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
