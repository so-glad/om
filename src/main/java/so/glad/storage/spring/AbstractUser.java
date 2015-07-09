package so.glad.storage.spring;

import com.google.common.base.Objects;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import so.glad.storage.Domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 * @author palmtale
 *         on 15/7/8.
 */
@MappedSuperclass
public abstract class AbstractUser<ID extends Serializable> extends User implements Domain<ID> {

    @Id
    @GeneratedValue
    private ID id;
    @CreatedDate
    private Date createdDate;
    @LastModifiedDate
    private Date lastModifiedDate;

    public AbstractUser(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    public AbstractUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
    }

    @Override
    public ID getId() {
        return id;
    }

    public void setId(ID id) {
        this.id = id;
    }

    @Override
    public Date getCreatedDate() {
        return createdDate;
    }

    @Override
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    @Override
    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    @Override
    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getPassword() {
        return super.getPassword();
    }

    public String getUsername() {
        return super.getUsername();
    }

    public boolean isEnabled() {
        return super.isEnabled();
    }

    public boolean isAccountNonExpired() {
        return super.isAccountNonExpired();
    }

    public boolean isAccountNonLocked() {
        return super.isAccountNonLocked();
    }

    public boolean isCredentialsNonExpired() {
        return super.isCredentialsNonExpired();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractUser)) {
            return false;
        }
        AbstractUser<?> that = (AbstractUser<?>) o;
        return Objects.equal(id, that.id) &&
                Objects.equal(createdDate, that.createdDate) &&
                Objects.equal(lastModifiedDate, that.lastModifiedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id, createdDate, lastModifiedDate);
    }

}
