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
        boolean menu1 = true;
        int tipoV = 0;
        Carro carro = null;
        Balsa balsa = null;
        Avion avion = null;
        do {
            menuPrincipal();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1: //Objetos y Recursividad
                    menuVehiculo();
                    opcion = scanner.nextInt(); //Ingresar Opcion

                    switch (opcion) {
                        case 1:
                            tipoVehiculo();
                            int tipo = scanner.nextInt();
                            switch (tipo) {
                                case 1: //Carro
                                    int opcom = 0;
                                    String comV = "";
                                    while (opcom != 1 && opcom != 2) {
                                        System.out.println("¿Qué tipo de combustible usa el carro?:");
                                        System.out.println("1. Diesel");
                                        System.out.println("2. Gasolina");
                                        opcom = scanner.nextInt();
                                        scanner.nextLine();

                                        switch (opcom) {
                                            case 1:
                                                comV = "Diesel";
                                                break;
                                            case 2:
                                                comV = "Gasolina";
                                                break;
                                            default:
                                                System.out.println("Por favor ingrese una opción válida (1 o 2)");
                                                break;
                                        }
                                    }

                                    System.out.print("Ingrese la Marca del Vehiculo: ");
                                    String marcaV = scanner.nextLine();

                                    System.out.print("Ingrese el Ano de lanzamiento: ");
                                    int anoV = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese la Placa del Vehiculo: ");
                                    String placaV = scanner.nextLine();

                                    System.out.print("Ingrese el nombre a registrar: ");
                                    String nombreV = scanner.nextLine();

                                    carro = new Carro(marcaV, nombreV, anoV, placaV, comV);
                                    carro.mostrarInfo();
                                    carro.setTipoCombustible(comV);
                                    tipoV = 1;
                                    break;

                                case 2: //Balsa
                                    String movBal;
                                    movimientoBalsa();
                                    int opBal = scanner.nextInt();
                                    scanner.nextLine();

                                    if (opBal == 1) {
                                        movBal = "Motor";
                                    }
                                    if (opBal == 2) {
                                        movBal = "Remo";
                                    } else {
                                        movBal = "Invalido";
                                    }

                                    System.out.print("Ingrese la marca de la Balsa: ");
                                    String marcaB = scanner.nextLine();

                                    System.out.print("Ingrese el anio de lanzamiento: ");
                                    int anoB = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese nombre a registrar: ");
                                    String nombreB = scanner.nextLine();

                                    balsa = new Balsa(marcaB, nombreB, anoB, movBal);
                                    balsa.setOpcion(movBal);
                                    balsa.mostrarInfo();
                                    tipoV = 2;
                                    break;

                                case 3: //Avion
                                    System.out.print("Ingrese la Cantidad de Pasajeros del Avion:");
                                    int pasajeros = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese la marca del Avion: ");
                                    String marcaA = scanner.nextLine();

                                    System.out.print("Ingrese el anio de lanzamiento: ");
                                    int anoA = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese nombre a registrar: ");
                                    String nombreA = scanner.nextLine();

                                    avion = new Avion(marcaA, nombreA, anoA, pasajeros);
                                    avion.mostrarInfo();
                                    tipoV = 3;
                                    break;

                                default:
                                    menu1 = true;
                                    break;
                            }
                            break;

                        case 2: //Mostrar Datos Vehiculos
                            if (tipoV == 1) {
                                carro.mostrarInfo();
                            }
                            if (tipoV == 2) {
                                balsa.mostrarInfo();
                            }
                            if (tipoV == 3) {
                                avion.mostrarInfo();
                            }
                            if (tipoV != 1 && tipoV != 2 && tipoV != 3) {
                                System.out.println("No existen datos de vehiculos ingresados, por favor ingrese uno");
                            }
                            break;

                        case 3: //Torres de Hanoi

                            Scanner sc = new Scanner(System.in);
                            int n;

                            do {
                                System.out.print("Ingrese el número de discos (mínimo 3): ");
                                n = sc.nextInt();
                                if (n < 3) {
                                    System.out.println("Debe ingresar un mínimo de 3 discos para realizar la Torre de Hanoi.");
                                }
                            } while (n < 3);

                            int[][] torres = new int[3][n];
                            TorreDeHanoi.llenarTorreInicial(torres);
                            TorreDeHanoi.imprimirTorres(torres);
                            TorreDeHanoi.resolverTorreDeHanoi(n, 0, 2, 1, torres);

                            break;

                        case 4: // Menu Principal
                            menu1 = true;
                            break;
                    }
                    break;

                case 2: //Fase 2
                    System.out.println("fase en contruccion");
                    break;

                case 3: //Fase 3
                    System.out.println("Fase en construccion :D");
                    break;

                case 4: //Salir
                    menu1 = false;
                    break;

                default:
                    System.out.println("Se ha encontrado un error, vuelva a elegir una opcion");
                    break;
            }
        } while (menu1 == true);

    }

    public static void menuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.)Fase 1 - Objetos y Recursividad");
        System.out.println("2.)Fase 2");
        System.out.println("3.)Fase 3");
        System.out.println("4.)Salir del Programa");

        System.out.print("Seleccione una Opcion: ");
    }

    public static void menuVehiculo() {
        System.out.println("FASE 1 - Objetos y Recursividad");
        System.out.println("1.)Ingresar datos de vehiculos");
        System.out.println("2.)Mostrar datos del vehiculo");
        System.out.println("3.)Crear torre de Hanoi");
        System.out.println("4.)Regresar al menu principal");
    }

    public static void tipoVehiculo() {
        System.out.println("Seleccione el vehiculo a usar: ");
        System.out.println("1. Carro");
        System.out.println("2. Balsa");
        System.out.println("3. Avion");
    }

    public static void movimientoBalsa() {
        System.out.println("Seleccione el tipo de Balsa");
        System.out.println("1. Motor");
        System.out.println("2. A remo");
    }

}
