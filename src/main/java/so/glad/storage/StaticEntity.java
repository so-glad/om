package so.glad.storage;

import com.google.common.base.Objects;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * @author palmtale
 *         on 15/7/8.
 */
@MappedSuperclass
public class StaticEntity <ID extends Serializable> implements Static<ID> {

    @Id
    @GeneratedValue
    private ID id;

    private Date timestamp;

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public ID getId() {
        return id;
    }

    @Override
    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof StaticEntity)) {
            return false;
        }
        StaticEntity<?> that = (StaticEntity<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, timestamp);
    }
}
