import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {
    public Employee() {
    }

    @Id
    int id;
    String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
