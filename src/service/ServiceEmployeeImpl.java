package service;

import dao.DaoEmployee;
import entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ServiceEmployeeImpl implements ServiceEmployee {

    @Autowired
    private DaoEmployee employeeDao;

    @Override
    public void add(Employee entity) {
        if (entity != null) {
            entity.setId(employeeDao.create(entity));
        }
    }

    @Override
    public void saveOrUpdate(Employee entity) {
        if (entity != null) {
            employeeDao.saveOrUpdate(entity);
        }
    }

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public Employee get(Long id) {
        return employeeDao.read(id);
    }

    @Override
    public void update(Employee entity) {

    }

    @Override
    public void remove(Employee entity) {
        if (entity != null) {
            if (employeeDao.delete(entity)) {
                System.out.println("Удаление записи " + entity.getId() + " прошло успешно.");
            } else {
                System.out.println("При удалении записи " + entity.getId() + " возникла ошибка.");
            }
        }
    }
}
