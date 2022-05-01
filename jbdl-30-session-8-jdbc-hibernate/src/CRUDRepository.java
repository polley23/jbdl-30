import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CRUDRepository implements Repository<Employee,Integer> {
    SessionFactory sessionFactory;
    void init(){
        if(sessionFactory==null){
            sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        }
    }
    @Override
    public void save(Employee obj) {
        init();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(obj);
        transaction.commit();
        session.close();
    }

    @Override
    public Employee get(Integer integer) {
        init();
        Session session = sessionFactory.openSession();
        Employee employee =session.get(Employee.class,integer);
        session.close();
        return employee ;
    }

    @Override
    public void update(Employee employee) {
        init();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(employee);
        transaction.commit();
        session.close();
    }
}
