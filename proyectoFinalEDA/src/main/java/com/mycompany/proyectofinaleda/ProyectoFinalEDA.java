package com.mycompany.proyectofinaleda;

import java.util.Scanner;
/**
 *
 * @author ferna
 */

public class ProyectoFinalEDA {

    public static void main(String[] args) {
        ArbolDecision juego = new ArbolDecision();
        Scanner scanner = new Scanner(System.in);

        
        //Metodos de insercion para crear arbol predeterminado
        
        
        
        
        while (true) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Construir arbol inicial");
            System.out.println("2. Jugar");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");
            String opcion = scanner.nextLine();

            switch (opcion) {
                case "1":
                    juego.construirArbolDesdeCero();
                    break;
                case "2":
                    juego.jugar();
                    break;
                case "3":
                    System.out.println("¡Gracias por jugar!");
                    return;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
        
    }
}
