package so.glad.om.mongodb;

import com.google.common.base.Objects;
import org.springframework.data.annotation.Id;
import so.glad.om.Established;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Cartoon
 *         on 2015/6/9.
 */
public class AbstractStatic<ID extends Serializable> implements Established<ID> {

    private ID id;

    private Date timestamp;

    @Id
    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
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
