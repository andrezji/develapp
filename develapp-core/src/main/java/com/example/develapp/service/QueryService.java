package com.example.develapp.service;

import com.example.develapp.repository.AbstractRepository;
import com.example.develapp.repository.GenericSpecification;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@NoArgsConstructor
@Component
public class QueryService<T> {

    private AbstractRepository<T> abstractRepository;

    public QueryService(AbstractRepository<T> abstractRepository) {
        this.abstractRepository = abstractRepository;
    }

    public Page<T> getPageFilter(Map<String, String> params, Pageable pageable, Class<T> tClass) {
        Map<String, String> map = new HashMap<>();

        for (Field field : tClass.getDeclaredFields()) {
            String columnName;
            if (field.isAnnotationPresent(Column.class)) {
                columnName = field.getName();
                String string = params.get(columnName);
                if (string != null) {
                    map.put(columnName, string);
                }
            }
        }

        GenericSpecification<T> genericSpecification = new GenericSpecification<>(map);

        return abstractRepository.findAll(genericSpecification, pageable);
    }

}
