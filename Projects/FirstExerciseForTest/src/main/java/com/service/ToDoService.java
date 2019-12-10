package com.service;

import com.entity.ToDo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
public class ToDoService {

    @PersistenceContext
    EntityManager entityManager;

    public ToDo createToDo(ToDo todo){
        //Persist into db
        entityManager.persist(todo);
        return todo;
    }

    public ToDo updateToDo(ToDo toDo){
        entityManager.merge(toDo);
        return toDo;
    }

    public ToDo findToDoById(Long id){
        return entityManager.find(ToDo.class,id);
    }

    public List<ToDo> getTodos(){
        return entityManager.createQuery("Select t from ToDo t", ToDo.class).getResultList();
    }
}
