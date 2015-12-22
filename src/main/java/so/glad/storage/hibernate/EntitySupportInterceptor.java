package so.glad.storage.hibernate;

import java.io.Serializable;
import java.util.Date;

import org.hibernate.CallbackException;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import so.glad.storage.EventTimed;
import so.glad.storage.LifeTimed;

/**
 * @author  Cartoon
 * on 2015/3/5.
 */
public class EntitySupportInterceptor extends EmptyInterceptor {
    public boolean onFlushDirty(Object entity, Serializable id, Object[] currentState, Object[] previousState,
                                String[] propertyNames, Type[] types) throws CallbackException {
        if (entity instanceof LifeTimed) {
            LifeTimed lifeTimedEntity = (LifeTimed) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("lastModifiedDate".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    currentState[i] = lastModifyDate;
                    lifeTimedEntity.setLastModifiedDate(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        } else if (entity instanceof EventTimed) {
            EventTimed eventTimedEntity = (EventTimed) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("timestamp".equals(propertyNames[i])) {
                    Date timestamp = new Date();
                    currentState[i] = timestamp;
                    eventTimedEntity.setTimestamp(timestamp);
                    modified = true;
                }
            }
            return modified;
        }
        return false;
    }

    public boolean onSave(Object entity, Serializable id, Object[] state, String[] propertyNames, Type[] types)
            throws CallbackException {
        if (entity instanceof LifeTimed) {
            LifeTimed lifeTimedEntity = (LifeTimed) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("createdDate".equals(propertyNames[i])) {
                    Date createDate = new Date();
                    state[i] = createDate;
                    lifeTimedEntity.setCreatedDate(createDate);
                    modified = true;
                } else if ("lastModifiedDate".equals(propertyNames[i])) {
                    Date lastModifyDate = new Date();
                    state[i] = lastModifyDate;
                    lifeTimedEntity.setLastModifiedDate(lastModifyDate);
                    modified = true;
                }
            }
            return modified;
        }  else if (entity instanceof EventTimed) {
            EventTimed eventTimedEntity = (EventTimed) entity;
            boolean modified = false;
            for (int i = 0; i < propertyNames.length; i++) {
                if ("timestamp".equals(propertyNames[i])) {
                    Date timestamp = new Date();
                    state[i] = timestamp;
                    eventTimedEntity.setTimestamp(timestamp);
                    modified = true;
                }
            }
            return modified;
        }
        return false;
    }
}
