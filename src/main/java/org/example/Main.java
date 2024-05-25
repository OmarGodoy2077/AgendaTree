package org.example;

import org.example.Agenda.Agenda;
import org.example.Agenda.Contacto;

public class Main {
    public static void main(String[] args) {
        Agenda agenda = new Agenda();

        // Agregar contactos
//        agenda.agregarContacto("Mario", "123456789");
//        agenda.agregarContacto("Link", "987654321");
//        agenda.agregarContacto("Peach", "456789123");
//        agenda.agregarContacto("Zelda", "789123456");
//        agenda.agregarContacto("Luigi", "321654987" );
//        agenda.agregarContacto("Bowser", "654321987");
//        agenda.agregarContacto("Toad", "321987654");
//        agenda.agregarContacto("Yoshi, ", "654987321");
//        agenda.agregarContacto("Wario", "987321654");
//        agenda.agregarContacto("Donkey Kong", "6541231");
//        agenda.agregarContacto("Diddy Kong", "6541231");
//        agenda.agregarContacto("Dixie Kong", "6541231");
//        agenda.agregarContacto("Cranky Kong", "6541231");
//        agenda.agregarContacto("Funky Kong", "6541231");
//        agenda.agregarContacto("King newt", "6541231");


        // Mostrar contactos
        System.out.println("Contactos en la agenda:");
        agenda.mostrarContactos();

        // Buscar un contacto
        System.out.println("\nBuscando el contacto de Link:");
        Contacto contacto = agenda.buscarContacto("Link");
        if (contacto != null) {
            System.out.println("Nombre: " + contacto.getNombre() + ", Teléfono: " + contacto.getTelefono());
        } else {
            System.out.println("Contacto no encontrado.");
        }

        // Eliminar un contacto
        System.out.println("\nEliminando el contacto de Peach.");
        agenda.eliminarContacto("Peach");

        System.out.println("\nEliminando el contacto de Peach.");
        agenda.eliminarContacto("Wario");

        // Mostrar contactos después de la eliminación
        System.out.println("Contactos en la agenda después de eliminar:");
        agenda.mostrarContactos();
}
    }