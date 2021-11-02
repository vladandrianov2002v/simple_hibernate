import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import ru.sapteh.dao.Dao;
import ru.sapteh.dao.impl.EmployeeDaoImpl;
import ru.sapteh.model.Employee;


public class Program {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Employee, Integer> employeeDao = new EmployeeDaoImpl(factory);


        Employee employee = new Employee("John", "Konnor", 500);
        Employee employee1 = new Employee("Sylvester", "Stallone", 500);
        Employee employee2 = new Employee("Arnold", "Schwarzenegger", 500);
        employeeDao.save(employee);
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        System.out.println(employeeDao.findById(1));

        System.out.println(employeeDao.findAll());

        Employee update = employeeDao.findById(1);
        update.setFirstName("Ivan");
        update.setLastName("Ivanov");
        update.setSalary(100);
        employeeDao.update(update);

        employeeDao.deleteById(employeeDao.findById(4));


    }
}
