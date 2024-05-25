package org.example.Agenda;

import java.time.LocalDate;

public class Contacto {
    private String nombre;
    private Long telefono;

    private String correoelectronico;

    private LocalDate fechaNacimiento;


    public String getCorreoelectronico() {
        return correoelectronico;
    }

    public void setCorreoelectronico(String correoelectronico) {
        this.correoelectronico = correoelectronico;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Contacto(String nombre, Long telefono, String correoelectronico, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correoelectronico = correoelectronico;
        this.fechaNacimiento = fechaNacimiento;


    }



    public String getNombre() {
        return nombre;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    //hacer el set para nombre
    public void setNombre(String nombre){
        this.nombre = nombre;
        }

}