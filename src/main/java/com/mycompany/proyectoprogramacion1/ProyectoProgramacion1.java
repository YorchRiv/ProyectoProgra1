/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoprogramacion1;

import java.util.Scanner;

/**
 * @author Fernando Lopez 
 * @author Oscar Tobias
 * @author Jorge Mejicanos
 * @author Mynor Solis
 */
public class ProyectoProgramacion1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Esta linea es para poder ingresar datos
        menuPrincipal();
        int opcion = scanner.nextInt();

        switch (opcion) {
            case 1:
                menuVehiculo();
                opcion = scanner.nextInt(); //Ingresar Opcion

                switch(opcion)
                {
                    case 1:
                        tipoVehiculo();
                        int tipo = scanner.nextInt();
                        switch(tipo){
                            case 1:                                                    
                                String comV;
                                System.out.println("¿Que tipo de combustible usa el carro?:");
                                System.out.println("1. Diesel");
                                System.out.println("2. Gasolina");
                                int opcom = scanner.nextInt();
                                scanner.nextLine();
                                if(opcom == 1){comV = "Diesel";}
                                if(opcom == 2){comV = "Gasolina";}
                                else{comV = "Diesel";}
                        
                                System.out.print("Ingrese la Marca del Vehiculo: ");
                                String marcaV = scanner.nextLine();
                        
                                System.out.print("Ingrese el Ano de lanzamiento: ");
                                int anoV = scanner.nextInt();
                                scanner.nextLine();
                        
                                System.out.print("Ingrese la Placa del Vehiculo: ");
                                String placaV = scanner.nextLine();

                                System.out.print("Ingrese el nombre a registrar: ");
                                String nombreV = scanner.nextLine();

                                Carro carro1 = new Carro(marcaV, nombreV, anoV, placaV, comV);
                                carro1.mostrarInfo();
                                break;
                              
                            case 2:
                                movimientoBalsa();

                                break;
                                
                            case 3:
                                pasajerosAvion();

                                break;
                                
                            case 4:
                                
                                break;
                        }
                        break;
                    
                    case 2:
                        break;
                    
                    case 3:
                        
                        System.out.println("prueba de mi segundo commit");
                        break;
                    
                    case 4:
                        break;
                }
                break;

            case 2:
                System.out.println("fase en contruccion");
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
    public static void menuPrincipal(){
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.)Fase 1 - Objetos y Recursividad");
        System.out.println("2.)Fase 2");
        System.out.println("3.)Fase 3");
        System.out.println("4.)Salir del Programa");

        System.out.print("Seleccione una Opcion: ");
    }
    
    public static void menuVehiculo(){
        System.out.println("FASE 1 - Objetos y Recursividad");
        System.out.println("1.)Ingresar datos de vehiculos");
        System.out.println("2.)Mostrar datos del vehiculo");
        System.out.println("3.)Crear torre de Hanoi");
        System.out.println("4.)Regresar al menu principal");
    }
 
    public static void tipoVehiculo(){
        System.out.println("Seleccione el vehiculo a usar: ");
        System.out.println("1. Carro");
        System.out.println("2. Balsa");
        System.out.println("3. Avion");
    }
    
    public static void movimientoBalsa(){
        System.out.println("Seleccione el tipo de Balsa");
        System.out.println("1. Motor");
        System.out.println("2. A remo");
    }

    public static void pasajerosAvion(){
        System.out.println("Ingrese la Cantidad de Pasajeros del Avion:");
    }
}
