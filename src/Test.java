import entity.Employee;
import entity.User;
import enums.PositionType;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.ServiceEmployee;
import service.ServiceUser;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Test {
    public static void main(String[] args) throws ParseException {

/*
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
        */
        SimpleDateFormat fd = new SimpleDateFormat("dd.mm.yyyy");

        ApplicationContext context =
                new ClassPathXmlApplicationContext(
                        new String[]{"IoC/spring.xml"}
                );
        Employee employee = new Employee("test1", "test1", fd.parse("05.12.1962"), fd.parse("05.12.2011"), PositionType.ADMINISTRATOR);
        User user1 = new User("q", "q", fd.parse("05.12.2012"), employee);
        Employee employee2 = new Employee("test1", "test1", fd.parse("05.12.1955"), fd.parse("05.12.2012"), PositionType.CASHIER);

        ServiceEmployee service = context.getBean(ServiceEmployee.class);
        ServiceUser serviceUser = context.getBean(ServiceUser.class);


        service.saveOrUpdate(employee);
        service.add(employee2);
        serviceUser.add(user1);



        System.out.println(service.get(1L));

        System.out.println(serviceUser.get("q","q"));
        //System.out.println(service.getAll());
    }


}
