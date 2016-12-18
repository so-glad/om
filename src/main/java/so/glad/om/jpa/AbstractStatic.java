package so.glad.om.jpa;

import com.google.common.base.Objects;
import so.glad.om.Established;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Cartoon
 *         on 2015/6/9.
 */
@MappedSuperclass
public abstract class AbstractStatic<ID extends Serializable> implements Established<ID> {

    private ID id;

    private Date timestamp;

    @Id
    @Override
    @GeneratedValue
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    @Temporal(TemporalType.TIMESTAMP)
    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractStatic)) {
            return false;
        }
        AbstractStatic<?> that = (AbstractStatic<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, timestamp);
    }
}
