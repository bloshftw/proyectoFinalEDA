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
    
    public void cargarArbolPredeterminado() {
        // Hojas (animales)
        Nodo perro = new Nodo("Perro", false);
        Nodo gato = new Nodo("Gato", false);
        Nodo loro = new Nodo("Loro", false);
        Nodo ballena = new Nodo("Ballena", false);
        Nodo tiburon = new Nodo("Tiburon", false);
        Nodo anguila = new Nodo("Anguila", false);
        Nodo aguila = new Nodo("Aguila", false);
        Nodo paloma = new Nodo("Paloma", false);
        Nodo pinguino = new Nodo("Pinguino", false);
        Nodo rana = new Nodo("Rana", false);
        Nodo tigre = new Nodo("Tigre", false);
        Nodo leon = new Nodo("Leon", false);
        Nodo caballo = new Nodo("Caballo", false);
        Nodo vaca = new Nodo("Vaca", false);
        Nodo murcielago = new Nodo("Murcielago", false);
        Nodo serpiente = new Nodo("Serpiente", false);

        // Subarbol domestico
        Nodo ladra = new Nodo("¿Ladra?", true);
        ladra.setIzquierda(perro);
        ladra.setDerecha(gato);

        Nodo tieneColaDomestico = new Nodo("¿Tiene cola?", true);
        tieneColaDomestico.setIzquierda(ladra);
        tieneColaDomestico.setDerecha(loro);

        Nodo esDomestico = new Nodo("¿Es un animal domestico?", true);
        esDomestico.setIzquierda(tieneColaDomestico);

        // Subarbol acuatico
        Nodo tieneAletas = new Nodo("¿Tiene aletas?", true);
        tieneAletas.setIzquierda(tiburon);
        tieneAletas.setDerecha(anguila);

        Nodo esMamiferoMarino = new Nodo("¿Es un mamifero marino?", true);
        esMamiferoMarino.setIzquierda(ballena);
        esMamiferoMarino.setDerecha(tieneAletas);

        //  Subarbol aves
        Nodo esAveRapaz = new Nodo("¿Es un ave rapaz?", true);
        esAveRapaz.setIzquierda(aguila);
        esAveRapaz.setDerecha(paloma);

        Nodo vuela = new Nodo("¿Vuela?", true);
        vuela.setIzquierda(esAveRapaz);
        vuela.setDerecha(pinguino);

        Nodo tienePlumas = new Nodo("¿Tiene plumas?", true);
        tienePlumas.setIzquierda(vuela);
        tienePlumas.setDerecha(rana); // 🐸

        // Subarbol salvajes terrestres
        Nodo viveEnLaSelva = new Nodo("¿Vive en la selva?", true);
        viveEnLaSelva.setIzquierda(tigre);
        viveEnLaSelva.setDerecha(leon);

        Nodo sePuedeMontar = new Nodo("¿Se puede montar?", true);
        sePuedeMontar.setIzquierda(caballo);
        sePuedeMontar.setDerecha(vaca);

        Nodo esCarnivoro = new Nodo("¿Es carnívoro?", true);
        esCarnivoro.setIzquierda(viveEnLaSelva);
        esCarnivoro.setDerecha(sePuedeMontar);

        Nodo esNocturno = new Nodo("¿Es nocturno?", true);
        esNocturno.setIzquierda(murcielago);
        esNocturno.setDerecha(serpiente);

        Nodo tieneColaSalvaje = new Nodo("¿Tiene cola?", true);
        tieneColaSalvaje.setIzquierda(esCarnivoro);
        tieneColaSalvaje.setDerecha(esNocturno);

        // 🌍 Subárbol completo no doméstico
        Nodo tienePlumasODemuestra = new Nodo("¿Tiene plumas?", true);
        tienePlumasODemuestra.setIzquierda(tienePlumas);         // aves y rana
        tienePlumasODemuestra.setDerecha(tieneColaSalvaje);      // salvajes terrestres

        Nodo viveEnElAgua = new Nodo("¿Vive en el agua?", true);
        viveEnElAgua.setIzquierda(esMamiferoMarino);             // ballena, tiburón, anguila
        viveEnElAgua.setDerecha(tienePlumasODemuestra);          // aves y salvajes

        // 🌳 Raíz del árbol
        esDomestico.setDerecha(viveEnElAgua);
        raiz = esDomestico;
    }


}
