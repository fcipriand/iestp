package iestp.edu.pe.config;

import iestp.edu.pe.Service.impl.EstudianteService;
import iestp.edu.pe.dto.DTODetalleMatricula;
import iestp.edu.pe.dto.DTOEstudiante;
import iestp.edu.pe.dto.DTOMatricula;
import iestp.edu.pe.modelo.DetalleMatricula;
import iestp.edu.pe.modelo.Estudiante;
import iestp.edu.pe.modelo.Matricula;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MapperConfig {


	@Bean("defaultMapper")
    public ModelMapper defaultMapper(){
        return new ModelMapper();
    }

    
}

