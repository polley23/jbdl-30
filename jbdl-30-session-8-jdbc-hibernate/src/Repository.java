public interface Repository<T,ID> {
    void save(T obj);
    T get(ID id);

    void update(Employee employee);
}
