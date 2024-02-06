package com.acme.hotels.api.v1;

import com.acme.hotels.model.Hotel;
import com.acme.hotels.service.HotelService;
import com.acme.hotels.utils.HotelEditor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class HotelController {
    private static final String URI = "/v1/hotels";
    private final HotelService service;

    @Autowired
    HotelController(HotelService service){
        this.service = service;
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        binder.registerCustomEditor(Hotel.class, new HotelEditor(new ObjectMapper()));
    }

    @GetMapping(URI)
    List<Hotel> findAll() {
        return service.findAll();
    }
    @GetMapping(URI+"/{hotel}")
    List<Hotel> findByHotel(@PathVariable("hotel") Hotel hotel, @RequestParam List<String> fields) {
        System.out.println(hotel);
        return service.findAll(fields, hotel);
    }
}
