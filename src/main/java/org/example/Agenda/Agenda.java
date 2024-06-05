package org.example.Agenda;

// Agenda.java
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private NodoContacto raiz;

    public Agenda() {
        raiz = null;
    }

    public void agregarContacto(Contacto contacto) {
        raiz = agregarRecursivo(raiz, contacto);
    }

    private NodoContacto agregarRecursivo(NodoContacto actual, Contacto contacto) {
        if (actual == null) {
            return new NodoContacto(contacto);
        }

        if (contacto.getNombre().compareTo(actual.getContacto().getNombre()) < 0) {
            actual.setIzquierda(agregarRecursivo(actual.getIzquierda(), contacto));
        } else if (contacto.getNombre().compareTo(actual.getContacto().getNombre()) > 0) {
            actual.setDerecha(agregarRecursivo(actual.getDerecha(), contacto));
        } else {
            // el nombre ya existe
            return actual;
        }

        return actual;
    }

    public Contacto buscarContacto(String nombre) {
        return buscarRecursivo(raiz, nombre);
    }

    private Contacto buscarRecursivo(NodoContacto actual, String nombre) {
        if (actual == null) {
            return null;
        }

        if (nombre.equals(actual.getContacto().getNombre())) {
            return actual.getContacto();
        }

        return nombre.compareTo(actual.getContacto().getNombre()) < 0
                ? buscarRecursivo(actual.getIzquierda(), nombre)
                : buscarRecursivo(actual.getDerecha(), nombre);
    }

    public List<Contacto> buscar(Contacto criterios) {
        List<Contacto> resultados = new ArrayList<>();
        buscarRecursivoMultiple(raiz, criterios, resultados);
        return resultados;
    }

    private void buscarRecursivoMultiple(NodoContacto actual, Contacto criterios, List<Contacto> resultados) {
        if (actual == null) {
            return;
        }

        Contacto contacto = actual.getContacto();
        boolean coincide = (criterios.getNombre() == null || contacto.getNombre().equals(criterios.getNombre())) &&
                (criterios.getTelefono() == null || contacto.getTelefono().equals(criterios.getTelefono())) &&
                (criterios.getEmail() == null || contacto.getEmail().equals(criterios.getEmail()));

        if (coincide) {
            resultados.add(contacto);
        }

        buscarRecursivoMultiple(actual.getIzquierda(), criterios, resultados);
        buscarRecursivoMultiple(actual.getDerecha(), criterios, resultados);
    }

    public void guardar(String archivo) throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(archivo))) {
            out.writeObject(raiz);
        }
    }

    public void cargar(String archivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(archivo))) {
            raiz = (NodoContacto) in.readObject();
        }
    }
}
