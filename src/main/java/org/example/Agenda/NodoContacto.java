package org.example.Agenda;

// NodoContacto.java
import java.io.Serializable;

public class NodoContacto implements Serializable {
    private static final long serialVersionUID = 1L;
    private Contacto contacto;
    private NodoContacto izquierda, derecha;

    public NodoContacto(Contacto contacto) {
        this.contacto = contacto;
        izquierda = derecha = null;
    }

    public Contacto getContacto() {
        return contacto;
    }

    public NodoContacto getIzquierda() {
        return izquierda;
    }

    public void setIzquierda(NodoContacto izquierda) {
        this.izquierda = izquierda;
    }

    public NodoContacto getDerecha() {
        return derecha;
    }

    public void setDerecha(NodoContacto derecha) {
        this.derecha = derecha;
    }
}
