package so.glad.storage.spring;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import javax.persistence.EntityManager;
import javax.persistence.criteria.Predicate;
import java.io.Serializable;

/**
 * @author palmtale
 *         on 2015/4/7.
 */
public abstract class AbstractUserDetailRepository<U extends UserDetails, ID extends Serializable>
        extends SimpleJpaRepository<U, ID> implements UserDetailsService {

    public AbstractUserDetailRepository(Class<U> userClass, EntityManager em) {
        super(userClass, em);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return this.findOne((root, criteriaQuery, criteriaBuilder) -> {
            String[] fieldsNames = this.fieldsNames();
            Predicate[] predicateArray = new Predicate[fieldsNames.length];

            for(int i = 0; i < fieldsNames.length; ++i) {
                predicateArray[i] = criteriaBuilder.equal(root.get(fieldsNames[i]).as(String.class), username);
            }

            return criteriaQuery.where(criteriaBuilder.or(predicateArray)).getRestriction();
        });
    }

    protected String[] fieldsNames() {
        return new String[]{"username", "email", "mobile"};
    }
}

