package service;

import entity.Employee;
import entity.User;

import java.util.List;

public interface ServiceEmployee {
    public void saveOrUpdate(Employee entity);
    public List<Employee> getAll();
    public Employee get(Long id);
    public void add(Employee entity);
    public void update(Employee entity);
    public void remove(Employee entity);
}
