package org.example;
import org.example.Agenda.Agenda;
import org.example.Agenda.Contacto;
import java.io.IOException;
import java.time.LocalDate;

public class Main {
    private static final String RUTA_ARCHIVO = "C:\\Users\\Omar Godoy\\Music\\ProyectoFinal\\agenda.dat";

    public static void main(String[] args) {
        Agenda agenda = new Agenda();


        agenda.agregarContacto(new Contacto("Alice", 123456789L, "alice@example.com", LocalDate.of(1990, 1, 1)));
        agenda.agregarContacto(new Contacto("Bob", 987654321L, "bob@example.com", LocalDate.of(1985, 5, 20)));
        agenda.agregarContacto(new Contacto("Charlie", 123456789L, "charlie@gmail.com", LocalDate.of(2000, 10, 10)));
        agenda.agregarContacto(new Contacto("Alice", 123456789L, "alice@gmail.com", LocalDate.of(1990, 1, 1)));


        try {
            agenda.guardarAgenda(RUTA_ARCHIVO);
            System.out.println("Contactos guardados correctamente en " + RUTA_ARCHIVO);
        } catch (IOException e) {
            System.err.println("Error al guardar los contactos: " + e.getMessage());
        }


        try {
            agenda.cargarAgenda(RUTA_ARCHIVO);
            System.out.println("Contactos cargados correctamente desde " + RUTA_ARCHIVO);
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al cargar los contactos: " + e.getMessage());
        }

        System.out.println("Todos los contactos cargados:");
        for (Contacto c : agenda.obtenerTodosLosContactos()) {
            System.out.println(c);
        }

        // Buscar contactos por nombre
        System.out.println("Buscar por nombre 'Alice':");
        for (Contacto c : agenda.buscarContacto("Alice")) {
            System.out.println(c);
        }


        System.out.println("Buscar por criterio múltiple (nombre 'Alice'):");
        for (Contacto c : agenda.buscar(new Contacto(null, 123456789L, null, null))) {
            System.out.println(c);
        }
    }
}
