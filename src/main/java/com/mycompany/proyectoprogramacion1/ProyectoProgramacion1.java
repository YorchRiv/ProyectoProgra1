/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoprogramacion1;

import java.util.ArrayList;
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
        ArrayList<vehiculo> listaVehiculos = new ArrayList<vehiculo>();
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

                                        if (opcom == 1) {
                                            comV = "Diesel";
                                        } else if (opcom == 2) {
                                            comV = "Gasolina";
                                        } else {
                                            comV = "Invalido";
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
                                    carro.setTipoCombustible(comV);
                                    listaVehiculos.add(carro);
                                    System.out.println("Sus datos ha sido agregados exitosamente");
                                    tipoV = 1;
                                    break;

                                case 2: //Balsa--
                                    String movBal = "";
                                    int opBal = 0;
                                    while (opBal != 1 && opBal != 2) {
                                        movimientoBalsa();
                                        opBal = scanner.nextInt();
                                        scanner.nextLine();
                                        if (opBal == 1) {
                                            movBal = "Motor";
                                        } else if (opBal == 2) {
                                            movBal = "Remo";
                                        } else {
                                            movBal = "Invalido";
                                        }

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
                                    listaVehiculos.add(balsa);
                                    System.out.println("Sus datos ha sido agregados exitosamente");
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
                                    listaVehiculos.add(avion);
                                    System.out.println("Sus datos ha sido agregados exitosamente");
                                    tipoV = 3;
                                    break;

                                default:
                                    menu1 = true;
                                    break;
                            }
                            break;

                        case 2: //Mostrar Datos Vehiculos
                            if (listaVehiculos.isEmpty()) {
                                System.out.println("No existen datos ingresados, por favor ingrese uno :)");
                            } else {
                                for (vehiculo vehiculo : listaVehiculos) {
                                    vehiculo.mostrarInfo();
                                    System.out.println("");
                                }
                            }
                            break;

                            case 3: //Torres de Hanoi

                            int n = 0;
                            Boolean opcionHanoi = true;
                            int x = 0;

                            do {
                                while (n < 3) {
                                    try {
                                        System.out.print("Ingrese la cantidad de discos (mínimo 3): ");
                                        n = scanner.nextInt();

                                        if (n < 3) {
                                            System.out.println("Debe ingresar un mínimo de 3 discos para realizar la torre.");
                                        }
                                    } catch (NumberFormatException e) {
                                        System.out.println("Debe ingresar un número entero.");
                                    }
                                }

                                TorreDeHanoi torre = new TorreDeHanoi(1, 2, 3);
                                torre.ResolverTorreDeHanoi(n, 1, 2, 3);
                                System.out.println("Quiere volver a utilizar la torre de Hanoi?");
                                System.out.println("1.si 2.No");
                                x = scanner.nextInt();
                                n = 0;
                                if (x == 2) {
                                    opcionHanoi = false;

                                };

                                 } while (opcionHanoi);
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
