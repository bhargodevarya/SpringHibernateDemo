package com.example.service;

import com.example.dao.AbstractDao;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by 433132 on 7/1/2016.
 */
@Component
public class BaseService<T> implements IService<T> {

    private static Map<Class,AbstractDao> daoMap = new HashMap<>();

    public static Map<Class, AbstractDao> getDaoMap() {
        return daoMap;
    }

    private AbstractDao getDaoForModel(T t) {
        System.out.println("{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{{ value being feteched for key " + t.getClass());
        return daoMap.get(t.getClass());
    }

    @Override
    @Transactional
    public void create(T t) {
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>> map is ");
        daoMap.entrySet().stream().forEach(n -> System.out.println(n.getKey() + " value is " + n.getValue()));
        System.out.println(getDaoForModel(t));
        getDaoForModel(t).save(t);

    }

    @Override
    public void update(T t) {
        getDaoForModel(t);

    }

    @Override
    public void delete(T t) {

    }

    @Override
    public T get(T t) {
        return null;
    }
}
