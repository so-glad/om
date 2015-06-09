package so.glad.storage;

import com.google.common.base.Objects;

import javax.persistence.*;

import java.util.Date;
/**
 * @author Palmtale
 * on 2015/3/5
 *
 */
@Deprecated
@MappedSuperclass
public abstract class DomainEntity implements LifeTimed {

    private static final long serialVersionUID = 43243885420542542l;

    @Id
    @GeneratedValue
    protected Long id;

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, createdDate, lastModifiedDate);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        final DomainEntity other = (DomainEntity) obj;
        return Objects.equal(this.id, other.id)
                && Objects.equal(this.createdDate, other.createdDate)
                && Objects.equal(this.lastModifiedDate, other.lastModifiedDate);
    }
}
