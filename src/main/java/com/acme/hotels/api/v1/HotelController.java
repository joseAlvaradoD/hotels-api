package com.acme.hotels.api.v1;

import com.acme.hotels.model.Hotel;
import com.acme.hotels.service.HotelService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HotelController {
    private static final String URI = "/v1/hotels";
    private final HotelService service;

    @Autowired
    HotelController(HotelService service){
        this.service = service;
    }

    @GetMapping(URI)
    List<Hotel> findAll() {
        return service.findAll();
    }
    @GetMapping(URI+"/{hotel}")
    List<Hotel> findByHotel(@PathVariable("hotel") String json, @RequestParam List<String> fields) {
        ObjectMapper objectMapper = new ObjectMapper();
        Hotel hotel;
        System.out.println(json);
        try {
            hotel = objectMapper.readValue(json, Hotel.class);
            System.out.println(hotel);
        }catch (Exception e){
            hotel = Hotel.builder().build();
            System.out.println(e.getMessage());
        }

        return service.findAll(fields, hotel);
    }
}
