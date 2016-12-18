package so.glad.om;

import com.google.common.base.Objects;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 *
 *
 * @author palmtale
 *         on 15/7/8.
 */
@MappedSuperclass
public abstract class EstablishedFact<ID extends Serializable> implements Established<ID> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private ID id;

    @Temporal(TemporalType.TIMESTAMP)
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

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof EstablishedFact)) {
            return false;
        }
        EstablishedFact<?> that = (EstablishedFact<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(timestamp, that.timestamp);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, timestamp);
    }
}
