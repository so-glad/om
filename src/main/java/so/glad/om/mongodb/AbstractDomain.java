package so.glad.om.mongodb;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
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
    @CreatedDate
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    @LastModifiedDate
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }
}
