package so.glad.storage;

/**
 * @author palmtale
 *         on 15/5/14.
 */
public interface Domain<ID> extends LifeTimed {

    ID getId();
}
