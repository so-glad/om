package so.glad.storage;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

/**
 * @author  Cartoon
 * on 2015/3/5.
 */
@MappedSuperclass
public abstract class StaticEntity implements Serializable, EventTimed {
    @Id
    @GeneratedValue
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    protected Date timestamp;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
    public int hashCode() {
        return Objects.hash(id, timestamp);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final StaticEntity other = (StaticEntity) obj;
        return Objects.equals(this.id, other.id)
                && Objects.equals(this.timestamp, other.timestamp);
    }
}
