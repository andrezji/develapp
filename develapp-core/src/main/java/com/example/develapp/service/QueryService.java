package com.example.develapp.service;

import com.example.develapp.repository.GenericSpecification;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
public class QueryService<T> {

    public GenericSpecification<T> getGenericSpecification(Map<String, Object> params, Class<T> tClass) {
        Map<String, Object> map = getFilterMapForClass(params, tClass);
        return new GenericSpecification<>(map);
    }

    public Map<String, Object> getFilterMapForClass(Map<String, Object> params, Class<T> tClass) {
        Map<String, Object> map = new HashMap<>();

        for (Field field : tClass.getDeclaredFields()) {
            String columnName;
            if (field.isAnnotationPresent(Column.class)) {
                columnName = field.getName();
                Object object = params.get(columnName);
                if (object != null) {
                    map.put(columnName, object);
                }
            }
        }
        return map;
    }


}
