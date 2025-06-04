package com.mycompany.proyectofinaleda;

import java.util.Scanner;
/**
 *
 * @author ferna
 */
public class ArbolDecision {
    
      private Nodo raiz;
    private Scanner scanner;

    public ArbolDecision() {
        scanner = new Scanner(System.in);
    }

    public void construirArbolDesdeCero() {
        System.out.println("Ingrese la pregunta raiz:");
        String contenido = scanner.nextLine();
        raiz = new Nodo(contenido, true);
        construirRecursivo(raiz);
    }

    
    private void construirRecursivo(Nodo nodo) {
        System.out.println("¿Para la respuesta positiva a la pregunta, " + nodo.getContenido() + ", ¿Es otra pregunta? (Si / No)");
        String esPreguntaSi = scanner.nextLine();
        Nodo hijoSi = crearNodoDesdeInput();
        nodo.setIzquierda(hijoSi);
        if (hijoSi.isEsPregunta()) construirRecursivo(hijoSi);

        System.out.println("Para la respuesta negativa a la pregunta, " + nodo.getContenido() + ", ¿Es otra pregunta? (Si / No):");
        String esPreguntaNo = scanner.nextLine();
        Nodo hijoNo = crearNodoDesdeInput();
        nodo.setDerecha(hijoNo);
        if (hijoNo.isEsPregunta()) construirRecursivo(hijoNo);
    }

    private Nodo crearNodoDesdeInput() {
        System.out.println("Ingrese el contenido (pregunta o animal):");
        String contenido = scanner.nextLine();
        System.out.println("¿Es una pregunta? (si/no):");
        String tipo = scanner.nextLine();
        return new Nodo(contenido, tipo.equalsIgnoreCase("si"));
    }

    public void jugar() {
        System.out.println("Instrucciones para jugar:");
        System.out.println("Piensa en un animal y la computadora intentara adivinar!!");
        System.out.println("Responda las preguntas y en caso de que ganes, podras enseñarle a la computadora para que aprenda");
        jugarDesde(raiz);
    }

    private void jugarDesde(Nodo nodo) {
        while (nodo.isEsPregunta()) {
            System.out.println(nodo.getContenido());
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("rendirse")) return;
            nodo = respuesta.equalsIgnoreCase("si") ? nodo.getIzquierda() : nodo.getDerecha();
        }

        System.out.println("¿Es un " + nodo.getContenido() + "? (si/no):");
        String acierto = scanner.nextLine();
        if (acierto.equalsIgnoreCase("si")) {
            System.out.println("¡¡He acertado!!, Gracias por jugar, podemos jugar nuevamente si quieres!!");
        } else {
            aprender(nodo);
        }
    }

    private void aprender(Nodo nodo) {
        System.out.println("¿Que animal era?");
        String animal = scanner.nextLine();
        System.out.println("Ingrese una pregunta que distinga un " + animal + " de un " + nodo.getContenido() + ":");
        String nuevaPregunta = scanner.nextLine();
        System.out.println("¿La respuesta a la nueva pregunta para " + animal + " es Si o No?:");
        String respuestaCorrecta = scanner.nextLine();

        Nodo nuevoAnimal = new Nodo(animal, false);
        Nodo antiguoAnimal = new Nodo(nodo.getContenido(), false);

        nodo.setContenido(nuevaPregunta);
        nodo.setEsPregunta(true);

        if (respuestaCorrecta.equalsIgnoreCase("si")) {
            nodo.setIzquierda(nuevoAnimal);
            nodo.setDerecha(antiguoAnimal);
        } else {
            nodo.setIzquierda(antiguoAnimal);
            nodo.setDerecha(nuevoAnimal);
        }
    } 
    
}
