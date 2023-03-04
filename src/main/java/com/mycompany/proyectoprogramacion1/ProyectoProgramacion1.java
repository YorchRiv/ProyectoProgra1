/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoprogramacion1;

import java.util.Scanner;

/**
 *
 * @author Jorge Mejicanos
 */
public class ProyectoProgramacion1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Esta linea es para poder ingresar datos

        System.out.println("MENU PRINCIPAL");
        System.out.println("1.)Fase 1 - Objetos y Recursividad");
        System.out.println("2.)Fase 2");
        System.out.println("3.)Fase 3");
        System.out.println("4.)Salir del Programa");

        System.out.print("Seleccione una Opcion: ");
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                System.out.println("FASE 1 - Objetos y Recursividad");
                System.out.println("1.)Ingresar datos de vehiculos");
                System.out.println("2.)Mostrar datos del vehiculo");
                System.out.println("3.)Crear torre de Hanoi");
                System.out.println("4.)Regresar al menu principal");
                opcion = scanner.nextInt(); //Ingresar Opcion

                switch(opcion)
                {
                    case 1:
                        break;
                    
                    case 2:
                        break;
                    
                    case 3:
                        break;
                    
                    case 4:
                        break;
                }
                break;

            case 2:
                System.out.println("Fase en construccion :D");
                break;

            case 3:
                System.out.println("Fase en construccion :D");
                break;

            case 4:
                System.out.println("Gracias por usar nuestro proyecto, Adios");
                break;

            default:
                System.out.println("Se ha encontrado un error, vuelva a elegir una opcion");
                break;
        }
    }
}
