package com.example.salud.service.impl;

import com.example.salud.repository.IGenericRepo;
import com.example.salud.exception.ModelNotFoutException;

import java.util.List;

public abstract class CRUDImpl<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    public T save(T entity) throws Exception {
        return getRepo().save(entity);
    }

    public T update(ID id, T entity) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoutException("ID NOT FOUND: " + id));
        return getRepo().save(entity);
    }

    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    public T findById(ID id) throws Exception {
        return getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoutException("ID NOT FOUND: " + id));
    }

    public void delete(ID id) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new ModelNotFoutException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }
}
