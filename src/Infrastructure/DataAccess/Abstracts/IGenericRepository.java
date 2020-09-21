package Infrastructure.DataAccess.Abstracts;

/**
 *
 * @author FernandoCalmet
 * @version 2.0
 * @since 2020-01-10
 * @param <T>
 */
public interface IGenericRepository<T> {

    public T add(T entity);

    public T edit(T entity);

    public boolean remove(int id);

    public Iterable<T[]> getAll();

    public Iterable<T[]> getByValue(String value);
}
