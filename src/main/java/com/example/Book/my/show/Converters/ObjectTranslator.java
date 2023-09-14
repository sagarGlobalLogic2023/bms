package com.example.Book.my.show.Converters;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Component
public class ObjectTranslator {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    ObjectMapper objectMapper;

    public <T, R> R translate(T source, Class<R> targetType) {
        return modelMapper.map(source, targetType);
    }
}
