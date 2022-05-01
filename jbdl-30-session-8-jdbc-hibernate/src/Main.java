import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // try {
//            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jbdl-30"
//                    ,"root","");
        //create
//            PreparedStatement statement = connection.prepareStatement("insert into employee (`id`,`eName`) " +
//                    "values (4, 'David')");
        //update
//            PreparedStatement statement = connection.prepareStatement("update employee set eName ='John' where id=4");
//            statement.execute();
        //select
//            PreparedStatement statement = connection.prepareStatement("select * from employee");
//            ResultSet rs = statement.executeQuery();
//            while(true){
//                if(!rs.next())
//                    break;
//
//                int id = Integer.parseInt( rs.getString(1));
//
//                System.out.print(id + " ");
//
//                String s = rs.getString(2);
//                Employee employee = new Employee(id,s);// object relation mapping
//                System.out.println(employee.name);
//            }
//            connection.close();
//
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }

        Repository<Employee, Integer> repository = new CRUDRepository();
        repository.save(new Employee(1, "John"));
        Employee employee = repository.get(1);
        System.out.println(employee.getName());
        employee.name="David";
        repository.update(employee);
        employee = repository.get(1);
        System.out.println(employee.getName());

        //  }
    }
}