package so.glad.om.hibernate;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;
import so.glad.om.Established;
import so.glad.om.Variable;

import java.io.Serializable;
import java.util.Date;

/**
 * @author  Cartoon
 * @since 2015/3/5.
 */
public class EntitySupportInterceptor extends EmptyInterceptor {
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof Variable) {
            Variable variable = (Variable) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("lastModifiedDate".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    currentState[i] = lastModifyDate;
                    variable.setLastModifiedDate(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        } else if (entity instanceof Established) {
            Established established = (Established) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("timestamp".equals(propertyNames[i])) {
                    Date timestamp = new Date();
                    currentState[i] = timestamp;
                    established.setTimestamp(timestamp);
                    modified = true;
                }
            }
            return modified;
        }
        return false;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        if (entity instanceof Variable) {
            Variable VariableEntity = (Variable) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("createdDate".equals(propertyNames[i])) {
                    Date createDate = new Date();
                    state[i] = createDate;
                    VariableEntity.setCreatedDate(createDate);
                    modified = true;
                } else if ("lastModifiedDate".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    state[i] = lastModifyDate;
                    VariableEntity.setLastModifiedDate(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        }  else if (entity instanceof Established) {
            Established established = (Established) entity;
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
