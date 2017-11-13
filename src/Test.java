import dao.Dao;
import dao.DaoImpl;
import entity.Employee;
import entity.User;
import enums.PositionType;
import util.HibernateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) throws ParseException {


        SimpleDateFormat fd = new SimpleDateFormat("dd.mm.yyyy");
        Dao<Employee> daoEm = new DaoImpl<>(Employee.class);
        Dao<User> daoUs = new DaoImpl<>(User.class);


        Employee employee = new Employee("test1", "test1", fd.parse("05.12.1962"), fd.parse("05.12.2011"), PositionType.ADMINISTRATOR);
        User user1 = new User("asdasd", "aasdf", fd.parse("05.12.2012"), employee);
        Employee employee2 = new Employee("test1", "test1", fd.parse("05.12.1955"), fd.parse("05.12.2012"), PositionType.CASHIER);


        daoEm.create(employee2);

        daoEm.create(employee);
        daoUs.create(user1);

        employee.toString();
        daoEm.read((long) 100);

        daoEm.getAll();

        //daoUs.getAll();

        //HibernateUtil.factory();

        HibernateUtil.factory().close();
    }
}
