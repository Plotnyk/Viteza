package dao;

import entity.Employee;

import java.util.List;

public interface DaoEmployee extends Dao<Employee> {
    public List<Employee> getAll();
}
