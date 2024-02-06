package com.acme.hotels.utils;

import com.acme.hotels.model.Hotel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.micrometer.common.util.StringUtils;

import java.beans.PropertyEditorSupport;

public class HotelEditor extends PropertyEditorSupport {

    private ObjectMapper objectMapper;

    public HotelEditor(ObjectMapper objectMapper){
        this.objectMapper = objectMapper;
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException{
        if(StringUtils.isEmpty(text)){
            setValue(null);
        }else{
            Hotel hotel = new Hotel();
            try{
                hotel = objectMapper.readValue(text, Hotel.class);
            }catch (JsonProcessingException e){
                throw new IllegalArgumentException("It is not possible transform filter to hotel object. " + e.getMessage(), e);
            }
            setValue(hotel);
        }
    }
}
