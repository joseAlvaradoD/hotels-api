package com.acme.hotels.service;

import com.acme.hotels.model.Hotel;
import com.acme.hotels.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.mongodb.core.query.UntypedExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.springframework.data.domain.ExampleMatcher.GenericPropertyMatchers.ignoreCase;

@Service
public class HotelService {

    private final HotelRepository repository;

    @Autowired
    HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> findAll(){
        return repository.findAll();
    }
    public List<Hotel> findAll(List<String> fields, Hotel hotel){
        ExampleMatcher matcher = UntypedExampleMatcher.matchingAll().withIgnorePaths("id").withIgnoreNullValues();
        Example<Hotel> example = Example.of(hotel, matcher);
        return repository.findBy(example, q->q.project(fields).all());
    }
}
