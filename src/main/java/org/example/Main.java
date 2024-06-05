package org.example;
import org.example.Agenda.Agenda;
import org.example.Agenda.Contacto;

import java.io.IOException;
import java.util.List;

// Main.java
public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.agregarContacto(new Contacto("Juan", "123456789", "juan@example.com"));
        agenda.agregarContacto(new Contacto("Ana", "987654321", "ana@example.com"));
        agenda.agregarContacto(new Contacto("Luis", "555555555", "luis@example.com"));

        System.out.println(agenda.buscarContacto("Ana"));
        System.out.println(agenda.buscarContacto("Luis"));
        System.out.println(agenda.buscarContacto("Pedro"));

        // Búsqueda por múltiples criterios
        Contacto criteriosBusqueda = new Contacto("Ana", null, "ana@example.com");
        List<Contacto> resultados = agenda.buscar(criteriosBusqueda);
        System.out.println("Resultados de búsqueda por criterios: " + resultados);

        // Guardar y cargar
        try {
            agenda.guardar("agenda.dat");
            Agenda nuevaAgenda = new Agenda();
            nuevaAgenda.cargar("agenda.dat");
            System.out.println("Contactos después de cargar: " + nuevaAgenda.buscarContacto("Ana"));
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}