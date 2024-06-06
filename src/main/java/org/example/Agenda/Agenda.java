package org.example.Agenda;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private NodoContacto raiz;

    public void agregarContacto(Contacto contacto) {
        raiz = agregarContactoRecursivo(raiz, contacto);
    }

    private NodoContacto agregarContactoRecursivo(NodoContacto actual, Contacto contacto) {
        if (actual == null) {
            return new NodoContacto(contacto);
        }

        if (contacto.getNombre().compareTo(actual.getContacto().getNombre()) < 0) {
            actual.setIzquierdo(agregarContactoRecursivo(actual.getIzquierdo(), contacto));
        } else if (contacto.getNombre().compareTo(actual.getContacto().getNombre()) > 0) {
            actual.setDerecho(agregarContactoRecursivo(actual.getDerecho(), contacto));
        }

        return actual;
    }

    public List<Contacto> buscarContacto(String criterio) {
        List<Contacto> resultados = new ArrayList<>();
        buscarContactoRecursivo(raiz, criterio, resultados);
        return resultados;
    }

    private void buscarContactoRecursivo(NodoContacto actual, String criterio, List<Contacto> resultados) {
        if (actual == null) {
            return;
        }

            if (actual.getContacto().getNombre().equalsIgnoreCase(criterio) ||
                    String.valueOf(actual.getContacto().getTelefono()).equalsIgnoreCase(criterio) ||
                    actual.getContacto().getEmail().equalsIgnoreCase(criterio)) {
                resultados.add(actual.getContacto());
            }

            buscarContactoRecursivo(actual.getIzquierdo(), criterio, resultados);
            buscarContactoRecursivo(actual.getDerecho(), criterio, resultados);
        }

    public List<Contacto> buscar(Contacto criterio) {
        List<Contacto> resultados = new ArrayList<>();
        buscarRecursivo(raiz, criterio, resultados);
        return resultados;
    }

    private void buscarRecursivo(NodoContacto actual, Contacto criterio, List<Contacto> resultados) {
        if (actual == null) {
            return;
        }

        if ((criterio.getNombre() == null || actual.getContacto().getNombre().equalsIgnoreCase(criterio.getNombre())) &&
                (criterio.getTelefono() == null || actual.getContacto().getTelefono().equals(criterio.getTelefono())) &&
                (criterio.getEmail() == null || actual.getContacto().getEmail().equalsIgnoreCase(criterio.getEmail())) &&
                (criterio.getFechaNacimiento() == null || actual.getContacto().getFechaNacimiento().equals(criterio.getFechaNacimiento()))) {
            resultados.add(actual.getContacto());
        }

        buscarRecursivo(actual.getIzquierdo(), criterio, resultados);
        buscarRecursivo(actual.getDerecho(), criterio, resultados);
    }

    public void guardarAgenda(String rutaArchivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(raiz);
        }
    }

    public void cargarAgenda(String rutaArchivo) throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            raiz = (NodoContacto) ois.readObject();
        }
    }

    public List<Contacto> obtenerTodosLosContactos() {
        List<Contacto> contactos = new ArrayList<>();
        obtenerTodosLosContactosRecursivo(raiz, contactos);
        return contactos;
    }

    private void obtenerTodosLosContactosRecursivo(NodoContacto actual, List<Contacto> contactos) {
        if (actual == null) {
            return;
        }

        contactos.add(actual.getContacto());
        obtenerTodosLosContactosRecursivo(actual.getIzquierdo(), contactos);
        obtenerTodosLosContactosRecursivo(actual.getDerecho(), contactos);
    }
}

