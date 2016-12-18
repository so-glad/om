package so.glad.om.jpa;

import com.google.common.base.Objects;
import so.glad.om.Variable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Cartoon
 *         on 2015/6/9.
 */
@MappedSuperclass
public abstract class AbstractDomain<ID extends Serializable> implements Variable<ID> {

    private ID id;

    private Date createdDate;

    private Date lastModifiedDate;

    @Id
    @Override
    @GeneratedValue
    public ID getId(){
        return this.id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    @Temporal(TemporalType.TIMESTAMP)
    public Date getCreatedAt() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    @Temporal(TemporalType.TIMESTAMP)
    public Date getUpdatedAt() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractDomain)) {
            return false;
        }
        AbstractDomain<?> that = (AbstractDomain<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(createdDate, that.createdDate) &&
                Objects.equal(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, createdDate, lastModifiedDate);
    }
}
