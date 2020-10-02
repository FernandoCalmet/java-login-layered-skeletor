package Infrastructure.DataAccess.Abstracts;

public interface IGenericRepository<T> {
    public T add(T entity);

    public T edit(T entity);

    public boolean remove(int id);

    public Iterable<T[]> getAll();

    public Iterable<T[]> getByValue(String value);
}
