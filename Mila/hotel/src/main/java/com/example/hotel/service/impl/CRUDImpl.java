package com.example.hotel.service.impl;

import com.example.hotel.repository.IGenericRepo;
import com.example.hotel.service.ICRUD;

import java.util.List;

public abstract class CRUDImpl<T, ID> implements ICRUD<T, ID> {

    protected abstract IGenericRepo<T, ID> getRepo();

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id)
                .orElseThrow(() -> new Exception("ID NOT FOUND: " + id));
    }

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new Exception("ID NOT FOUND: " + id));

        return getRepo().save(t);
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id)
                .orElseThrow(() -> new Exception("ID NOT FOUND: " + id));

        getRepo().deleteById(id);
    }
}
