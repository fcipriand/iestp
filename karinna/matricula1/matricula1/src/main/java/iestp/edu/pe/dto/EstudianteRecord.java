package iestp.edu.pe.dto;

public record EstudianteRecord(
        Integer idEstudiante,
        String nombres,
        String apellidos,
        String dni,
        String correo,
        boolean enableEstudiante
) {
}
