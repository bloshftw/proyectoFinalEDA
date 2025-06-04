package com.mycompany.proyectofinaleda;

public class Nodo {
    private String contenido;
    private boolean esPregunta;
    private Nodo izquierda;
    private Nodo derecha;

    public Nodo(String contenido, boolean esPregunta) {
        this.contenido = contenido;
        this.esPregunta = esPregunta;
    }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }
    public boolean isEsPregunta() { return esPregunta; }
    public void setEsPregunta(boolean esPregunta) { this.esPregunta = esPregunta; }
    public Nodo getIzquierda() { return izquierda; }
    public void setIzquierda(Nodo izquierda) { this.izquierda = izquierda; }
    public Nodo getDerecha() { return derecha; }
    public void setDerecha(Nodo derecha) { this.derecha = derecha; }
    
}
