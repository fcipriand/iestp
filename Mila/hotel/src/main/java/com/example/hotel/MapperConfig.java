package com.example.hotel;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("mapperDefault")
    public ModelMapper defaultMapper() {
        return new ModelMapper();
    }
}
