package so.glad.om.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import so.glad.om.EstablishedFact;
import so.glad.om.Variable;
import so.glad.om.VariableObject;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  Cartoon
 * @since 2015/3/5.
 */
public class EntitySupportInterceptor extends EmptyInterceptor {
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof VariableObject) {
            VariableObject variable = (VariableObject) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("updatedAt".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    currentState[i] = lastModifyDate;
                    variable.setUpdatedAt(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        } else if (entity instanceof EstablishedFact) {
            throw new RuntimeException("Established fact cannot be updated.");
        }
        return false;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        if (entity instanceof Variable) {
            VariableObject VariableEntity = (VariableObject) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("createdAt".equals(propertyNames[i])) {
                    Date createDate = new Date();
                    state[i] = createDate;
                    VariableEntity.setCreatedAt(createDate);
                    modified = true;
                } else if ("updatedAt".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    state[i] = lastModifyDate;
                    VariableEntity.setUpdatedAt(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        }  else if (entity instanceof EstablishedFact) {
            EstablishedFact established = (EstablishedFact) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("timestamp".equals(propertyNames[i])) {
                    Date timestamp = new Date();
                    state[i] = timestamp;
                    established.setTimestamp(timestamp);
                    modified = true;
                }
            }
            return modified;
        }
        return false;
    }
}
