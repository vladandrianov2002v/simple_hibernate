package ru.sapteh.dao;

import ru.sapteh.model.Employee;

import java.util.List;

public interface Dao <Entity, Key>{
    Entity findById(Key key);
    List<Entity> findAll();
    void save(Entity entity);
    void update(Entity entity);
    void deleteById(Entity entity);
}
