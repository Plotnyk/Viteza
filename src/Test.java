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
        SimpleDateFormat fd = new SimpleDateFormat("dd.MM.yyyy");
        Dao<Employee> daoEm = new DaoImpl<>(Employee.class);
        Dao<User> daoUs = new DaoImpl<>(User.class);
        Employee employee = new Employee("test", "test2", fd.parse("05.12.1962"), fd.parse("05.12.2011"), PositionType.ADMINISTRATOR);
        User user1 = new User("asdasd", "aasdf", fd.parse("05.12.2012"), employee);

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
