package dao;

import entity.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DaoEmployeeImpl extends DaoImpl<Employee> implements DaoEmployee {


    public DaoEmployeeImpl() {
        setClazz(Employee.class);
    }

    @Override
    public List<Employee> getAll() {
        return currentSession()
                .createQuery("from entity.Employee").list();
    }

}
