package ru.sapteh.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.sapteh.dao.Dao;
import ru.sapteh.model.Employee;

import java.util.List;

public class EmployeeDaoImpl implements Dao<Employee, Integer> {

    private final SessionFactory factory;

    public EmployeeDaoImpl(SessionFactory factory){
        this.factory =factory;
}

    @Override
    public Employee findById(Integer id) {
        try(Session session = factory.openSession()){
            return session.get(Employee.class, id);
        }
    }




    @Override
    public List<Employee> findAll() {
        try(Session session = factory.openSession()) {
            return session.createQuery("from Employee ", Employee.class).list();
        }
    }
    @Override
    public void save(Employee employee) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void update(Employee employee) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
        }
    }

    @Override
    public void deleteById(Employee employee) {
        try(Session session = factory.openSession()) {
            session.beginTransaction();
            session.delete(employee);
            session.getTransaction().commit();
        }
    }
}

