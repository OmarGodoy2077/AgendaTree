package org.example.Agenda;

import java.io.Serializable;

public class NodoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Contacto contacto;
    private NodoContacto izquierdo;
    private NodoContacto derecho;

    // Constructor, getters y setters
    public NodoContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public NodoContacto getIzquierdo() {
        return izquierdo;
    }

    public void setIzquierdo(NodoContacto izquierdo) {
        this.izquierdo = izquierdo;
    }

    public NodoContacto getDerecho() {
        return derecho;
    }

    public void setDerecho(NodoContacto derecho) {
        this.derecho = derecho;
    }
}
