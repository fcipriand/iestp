package iestp.edu.pe.service.impl;

import java.lang.reflect.Method;
import java.util.List;

import iestp.edu.pe.repository.IGenericRepo;
import iestp.edu.pe.service.ICRUD;
import iestp.edu.pe.exception.ModelNotFoutException;

public abstract class CRUDimpl<T,ID> implements ICRUD<T,ID> {
    protected abstract IGenericRepo<T,ID> getRepo();

    @Override
    public T save(T t) throws Exception {
        return getRepo().save(t);
    }

    @Override
    public T update(ID id, T t) throws Exception {
        //validad el id

        //java API Reflextion
        Class<?> clazz = t.getClass();
        String className = clazz.getSimpleName();  //cliente, categoria, producto provider

        //aqui el nombre de la clase SetXY
        String methodName = "setId"+className;
        Method setIdMethod = clazz.getMethod(methodName,id.getClass());
        setIdMethod.invoke(t,id);

        getRepo().findById(id).orElseThrow(()->new ModelNotFoutException("ID NOT FOUND: " + id));
        return getRepo().save(t);
    }

    @Override
    public List<T> findAll() throws Exception {
        return getRepo().findAll();
    }

    @Override
    public T findById(ID id) throws Exception {
        return getRepo().findById(id).orElseThrow(()->new ModelNotFoutException("ID NOT FOUND: " + id));
    }

    @Override
    public void delete(ID id) throws Exception {
        getRepo().findById(id).orElseThrow(()->new ModelNotFoutException("ID NOT FOUND: " + id));
        getRepo().deleteById(id);
    }

}
