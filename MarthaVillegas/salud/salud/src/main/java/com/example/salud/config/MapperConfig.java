package com.example.salud.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean("mapperDefault")
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
}





