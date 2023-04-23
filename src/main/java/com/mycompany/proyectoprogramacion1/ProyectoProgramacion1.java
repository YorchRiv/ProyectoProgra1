/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoprogramacion1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
        boolean menu2 = true;
        Carro carro = null;
        Balsa balsa = null;
        Avion avion = null;
        int opcionT = 0;
        ArrayList<vehiculo> listaVehiculos = new ArrayList<vehiculo>();
        do {
            menuPrincipal();
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1: //Objetos y Recursividad
                    do {
                        menuTorre();
                        opcionT = scanner.nextInt(); //Ingresar Opcion
                        switch (opcionT) {
                            case 1:
                                int n = 0;
                                boolean hanoiT = true;
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
                                    switch (x) {
                                        case 1:
                                            hanoiT = true;
                                            break;
                                        case 2:
                                            hanoiT = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese una opción valida.");
                                            hanoiT = false;
                                            break;
                                    }
                                } while (hanoiT == true);
                                break;
                            case 2:
                                System.out.println("Regresando al menú principal...");
                                break;
                        }
                    } while (opcionT != 2);
                    break;

                case 2: //Fase 2
                    do {
                        menuArreglos();
                        boolean regresarArreglos = true;
                        int validar = 0;
                        int opArreglo = scanner.nextInt();
                        switch (opArreglo) {
                            case 1:
                                do {
                                    int opcom = 0;
                                    String comV = "";
                                    int intefiV = 0;
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

                                    do {
                                        System.out.print("El identificador es: ");
                                        intefiV = scanner.nextInt();
                                        scanner.nextLine();
                                        if (compararIdentificador(listaVehiculos, intefiV)) {
                                            System.out.println("INGRESE UN VALOR NO REPETIDO.");
                                            break;
                                        } else {

                                            System.out.print("Ingrese la Placa del Vehiculo: ");
                                            String placaV = scanner.nextLine();

                                            System.out.print("Ingrese el nombre a registrar: ");
                                            String nombreV = scanner.nextLine();
                                            if (listaVehiculos.size() < 10) {
                                                carro = new Carro(marcaV, nombreV, intefiV, anoV, placaV, comV);
                                                carro.setTipoCombustible(comV);
                                                listaVehiculos.add(carro);
                                            } else {
                                                System.out.println("NO SE PUEDEN AGREGAR MAS VEHICULOS");
                                            }
                                            System.out.println("Desea ingresar otro carro? 1.Si 2.No");
                                            validar = scanner.nextInt();
                                            switch (validar) {
                                                case 1:
                                                    regresarArreglos = true;
                                                    break;
                                                case 2:
                                                    regresarArreglos = false;
                                                    break;
                                                default:
                                                    System.out.println("Ingrese una opción valida.");
                                                    regresarArreglos = false;
                                                    break;
                                            }
                                        }
                                    } while (compararIdentificador(listaVehiculos, intefiV)== false);

                                } while (regresarArreglos == true);
                                break;
                            case 2:
                                do {
                                    int intefiB = 0;
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

                                    System.out.print("El identificador es: ");
                                    intefiB = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese nombre a registrar: ");
                                    String nombreB = scanner.nextLine();

                                    if (listaVehiculos.size() < 10) {
                                        balsa = new Balsa(marcaB, nombreB, intefiB, anoB, movBal);
                                        balsa.setOpcion(movBal);
                                        listaVehiculos.add(balsa);
                                    } else {
                                        System.out.println("NO SE PUEDEN AGREGAR MAS VEHICULOS");
                                    }

                                    System.out.println("Desea ingresar otra Balsa? 1.Si 2.No");
                                    validar = scanner.nextInt();
                                    switch (validar) {
                                        case 1:
                                            regresarArreglos = true;
                                            break;
                                        case 2:
                                            regresarArreglos = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese una opción valida.");
                                            regresarArreglos = false;
                                            break;
                                    }
                                } while (regresarArreglos == true);
                                break;
                            case 3:
                                do {
                                    System.out.print("Ingrese la Cantidad de Pasajeros del Avion:");
                                    int pasajeros = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese la marca del Avion: ");
                                    String marcaA = scanner.nextLine();

                                    System.out.print("El identificador es: ");
                                    int intefiA = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese el anio de lanzamiento: ");
                                    int anoA = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese nombre a registrar: ");
                                    String nombreA = scanner.nextLine();

                                    if (listaVehiculos.size() < 10) {
                                        avion = new Avion(marcaA, nombreA, intefiA, anoA, pasajeros);
                                        listaVehiculos.add(avion);
                                    } else {
                                        System.out.println("NO SE PUEDEN AGREGAR MAS VEHICULOS");
                                    }

                                    System.out.println("Desea ingresar otra Balsa? 1.Si 2.No");
                                    validar = scanner.nextInt();
                                    switch (validar) {
                                        case 1:
                                            regresarArreglos = true;
                                            break;
                                        case 2:
                                            regresarArreglos = false;
                                            break;
                                        default:
                                            System.out.println("Ingrese una opción valida.");
                                            regresarArreglos = false;
                                            break;
                                    }
                                } while (regresarArreglos == true);
                                break;
                            case 4:
                                do {
                                Collections.sort(listaVehiculos, (vehiculo v1, vehiculo v2) -> v1.getIdentificador() - v2.getIdentificador());
                                System.out.println("LISTA ORDENADA.");
                                regresarArreglos = false;
                                } while (regresarArreglos == true);
                                break;
                            case 5:
                            do {
                                if (listaVehiculos.isEmpty()) {
                                    System.out.println("No existen datos ingresados, por favor ingrese uno :)");
                                } else {
                                    for (vehiculo vehiculo : listaVehiculos) {
                                        vehiculo.mostrarInfo();
                                        System.out.println("---------------------");
                                    }
                                }
                                regresarArreglos = false;
                                } while (regresarArreglos == true);
                                break;
                            case 6:
                                menu2 = false;
                                break;
                        }
                    } while (menu2 == true);
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
        scanner.close();
    }

    public static void menuPrincipal() {
        System.out.println("MENU PRINCIPAL");
        System.out.println("1.)Fase 1 - Recursividad");
        System.out.println("2.)Fase 2 - Arreglos");
        System.out.println("3.)Fase 3");
        System.out.println("4.)Salir del Programa");

        System.out.print("Seleccione una Opcion: ");
    }

    public static void menuTorre() {
        System.out.println("FASE 1 Recursividad");
        System.out.println("1.)Crear torre de Hanoi");
        System.out.println("2.)Regresar al menu principal");
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

    public static void menuArreglos() {
        System.out.println("1. Agregar Carro");
        System.out.println("2. Agregar Balsa");
        System.out.println("3. Agregar Avion");
        System.out.println("4. Ordenar Arreglo");
        System.out.println("5. Mostrar Arreglo");
        System.out.println("6. Regresar");
    }

    public static boolean compararIdentificador(ArrayList<vehiculo> lista, int valor) {
        for (vehiculo vehiculo : lista) {
            if (vehiculo.getIdentificador() == valor) {
                return true;
            }
        }
        return false;
    }
}
