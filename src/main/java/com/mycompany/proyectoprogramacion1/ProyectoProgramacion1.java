/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.proyectoprogramacion1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import proyectofinal.db.Aviones;
import proyectofinal.db.Carros;
import proyectofinal.db.Balsas;
import proyectofinal.db.CarrosJpaController;
import proyectofinal.db.AvionesJpaController;
import proyectofinal.db.BalsasJpaController;

/**
 * @author Fernando Lopez
 * @author Oscar Tobias
 * @author Jorge Mejicanos
 * @author Mynor Solis
 */
public class ProyectoProgramacion1 {

    public static void main(String[] args) {

        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("com.mycompany_ProyectoProgramacion1_jar_1.0-SNAPSHOTPU");
        EntityManager em = emf.createEntityManager();

        Scanner scanner = new Scanner(System.in); //Esta linea es para poder ingresar datos
        boolean menu1 = true;
        boolean menu2 = true;
        boolean menudb = true;
        boolean menudb2 = true;
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
                                                regresarArreglos = false;
                                                break;
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
                                    } while (compararIdentificador(listaVehiculos, intefiV) == false);

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
                                    do {

                                        System.out.print("El identificador es: ");
                                        intefiB = scanner.nextInt();
                                        scanner.nextLine();
                                        if (compararIdentificador(listaVehiculos, intefiB)) {
                                            System.out.println("INGRESE UN VALOR NO REPETIDO.");

                                        } else {
                                            System.out.print("Ingrese nombre a registrar: ");
                                            String nombreB = scanner.nextLine();

                                            if (listaVehiculos.size() < 10) {
                                                balsa = new Balsa(marcaB, nombreB, intefiB, anoB, movBal);
                                                balsa.setOpcion(movBal);
                                                listaVehiculos.add(balsa);
                                            } else {
                                                System.out.println("NO SE PUEDEN AGREGAR MAS VEHICULOS");
                                                regresarArreglos = false;
                                                break;
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
                                        }

                                    } while (compararIdentificador(listaVehiculos, intefiB) == false);
                                } while (regresarArreglos == true);
                                break;
                            case 3:
                                do {
                                    int intefiA = 0;
                                    System.out.print("Ingrese la Cantidad de Pasajeros del Avion:");
                                    int pasajeros = scanner.nextInt();
                                    scanner.nextLine();

                                    System.out.print("Ingrese la marca del Avion: ");
                                    String marcaA = scanner.nextLine();
                                    do {

                                        System.out.print("El identificador es: ");
                                        intefiA = scanner.nextInt();
                                        scanner.nextLine();
                                        if (compararIdentificador(listaVehiculos, intefiA)) {
                                        } else {
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
                                                regresarArreglos = false;
                                                break;
                                            }

                                            System.out.println("Desea ingresar otro avion? 1.Si 2.No");
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

                                    } while (compararIdentificador(listaVehiculos, intefiA) == false);
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
                                            System.out.println("---------------------");
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

                case 3: //Fase 3 - Base de datos
                    do {
                        System.out.println("1.) Trabajar con carros");
                        System.out.println("2.) Trabajar con balsas");
                        System.out.println("3.) Trabajar con aviones");
                        System.out.println("4.) Regresar al menu anterior");
                        System.out.print("Seleccione una opcion: ");
                        int opmen = scanner.nextInt();
                        scanner.nextLine();
                        switch (opmen) {
                            case 1:
                                System.out.println("Trabajaremos con Carros");
                                System.out.println("1.) Insertar");
                                System.out.println("2.) Consultar");
                                System.out.println("3.) Actualizar");
                                System.out.println("4.) Borrar");
                                System.out.println("5.) Volver al menu principal");
                                System.out.print("Seleccione una opcion: ");
                                opmen = scanner.nextInt();
                                switch (opmen) {
                                    case 1: //Insertar Carros
                                        System.out.println("Insertar Carro");
                                        Carros car = new Carros();

                                        int opcom = 0;
                                        while (opcom != 1 && opcom != 2) {
                                            System.out.println("¿Qué tipo de combustible usa el carro?:");
                                            System.out.println("1. Diesel");
                                            System.out.println("2. Gasolina");
                                            opcom = scanner.nextInt();
                                            scanner.nextLine();

                                            if (opcom == 1 || opcom == 2) {

                                                System.out.print("Ingrese la Marca del Vehiculo: ");
                                                String marcaV = scanner.nextLine();

                                                System.out.print("Ingrese el Año de lanzamiento: ");
                                                int anoV = scanner.nextInt();
                                                scanner.nextLine();

                                                System.out.print("Ingrese la Placa del Vehiculo: ");
                                                String placaV = scanner.nextLine();

                                                System.out.print("Ingrese el nombre a registrar: ");
                                                String nombreV = scanner.nextLine();

                                                System.out.println("");
                                                System.out.println("Resumen: ");
                                                System.out.println("Marca: " + marcaV);
                                                System.out.println("Nombre: " + nombreV);
                                                System.out.println("Anio: " + anoV);
                                                System.out.println("Placa: " + placaV);
                                                System.out.println("Tipo de Combustible: " + opcom);
                                                System.out.println("");
                                                System.out.print("Confirmar 1.)Si 2.)No: ");
                                                int opconfirmar = scanner.nextInt();

                                                switch (opconfirmar) {
                                                    case 1:
                                                        car.setTipoCombustible(opcom);
                                                        car.setMarca(marcaV);
                                                        car.setAnio(anoV);
                                                        car.setPlaca(placaV);
                                                        car.setNombre(nombreV);
                                                        try {
                                                            em.getTransaction().begin();
                                                            em.persist(car);
                                                            em.getTransaction().commit();
                                                            System.out.println("Id: " + car.getCarroID());
                                                            System.out.println("Enviado a la base de datos :D");
                                                        } catch (Exception e) {
                                                            em.getTransaction().rollback();
                                                            e.printStackTrace();
                                                            System.out.println("Ha ocurrido un error :(");
                                                        }
                                                        /*finally {
                                                            em.close();
                                                        }*/
                                                        break;

                                                    case 2:
                                                        System.out.println("Operacion Cancelada");
                                                        break;

                                                    default:
                                                        System.out.println("Operacion Cancelada");
                                                        break;
                                                }
                                            } else {
                                                System.out.println("Opción inválida, intentelo de nuevo");
                                            }
                                        }
                                        menu2 = false;
                                        break;

                                    case 2: //Leer Carros
                                        System.out.println("Seleccionar Carros");
                                        List<Carros> lstCarros = new ArrayList<>();
                                        CarrosJpaController ac = new CarrosJpaController(emf);
                                        try {
                                            lstCarros = ac.findCarrosEntities();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        /*finally {
                                            em.close();
                                        }*/

                                        if (lstCarros.isEmpty() == false) {
                                            for (Carros ca : lstCarros) {
                                                System.out.println("Id: " + ca.getCarroID());
                                                System.out.println("Marca: " + ca.getMarca());
                                                System.out.println("Nombre: " + ca.getNombre());
                                                System.out.println("Anio: " + ca.getNombre());
                                                System.out.println("Placa: " + ca.getPlaca());
                                                System.out.println("Tipo de Combustible: " + ca.getTipoCombustible());
                                                System.out.println("---------------------------");
                                            }
                                        } else {
                                            System.out.println("No hay datos para mostrar");
                                        }
                                        break;

                                    case 3: //Actualizar Carros
                                        System.out.println("Actualizar Carros");
                                        System.out.print("Ingrese el ID del carro: ");
                                        int carroID = scanner.nextInt();
                                        scanner.nextLine();

                                        CarrosJpaController ac1 = new CarrosJpaController(emf);
                                        Carros carroUp = null;

                                        try {
                                            carroUp = ac1.findCarros(carroID);

                                            if (carroUp != null) {
                                                System.out.println("Id: " + carroUp.getCarroID());
                                                System.out.println("Marca: " + carroUp.getMarca());
                                                System.out.println("Nombre: " + carroUp.getNombre());
                                                System.out.println("Año: " + carroUp.getAnio());
                                                System.out.println("Placa: " + carroUp.getPlaca());
                                                System.out.println("Tipo de Combustible: " + carroUp.getTipoCombustible());
                                                System.out.println("---------------------------");
                                                System.out.println("Desea Actualizar la información?: 1.)Si 2.)No");
                                                int opUp = scanner.nextInt();
                                                scanner.nextLine();
                                                int opcomUp = 0;
                                                if (opUp == 1) {
                                                    while (opcomUp != 1 && opcomUp != 2) {
                                                        System.out.println("¿Qué tipo de combustible usa el carro?:");
                                                        System.out.println("1. Diesel");
                                                        System.out.println("2. Gasolina");
                                                        opcomUp = scanner.nextInt();
                                                        scanner.nextLine();

                                                        if (opcomUp == 1 || opcomUp == 2) {

                                                            System.out.print("Ingrese la Marca del Vehiculo: ");
                                                            String marcaV = scanner.nextLine();

                                                            System.out.print("Ingrese el Año de lanzamiento: ");
                                                            int anoV = scanner.nextInt();
                                                            scanner.nextLine();

                                                            System.out.print("Ingrese la Placa del Vehiculo: ");
                                                            String placaV = scanner.nextLine();

                                                            System.out.print("Ingrese el nombre a registrar: ");
                                                            String nombreV = scanner.nextLine();

                                                            System.out.println("");
                                                            System.out.println("Resumen: ");
                                                            System.out.println("Marca: " + marcaV);
                                                            System.out.println("Nombre: " + nombreV);
                                                            System.out.println("Año: " + anoV);
                                                            System.out.println("Placa: " + placaV);
                                                            System.out.println("Tipo de Combustible: " + opcomUp);
                                                            System.out.println("");
                                                            System.out.print("Confirmar 1.)Si 2.)No: ");
                                                            int opconfirmar = scanner.nextInt();

                                                            switch (opconfirmar) {
                                                                case 1:
                                                                    carroUp.setTipoCombustible(opcomUp);
                                                                    carroUp.setMarca(marcaV);
                                                                    carroUp.setAnio(anoV);
                                                                    carroUp.setPlaca(placaV);
                                                                    carroUp.setNombre(nombreV);

                                                                    try {
                                                                        em.getTransaction().begin();
                                                                        em.merge(carroUp);  // Actualiza la entidad existente
                                                                        em.getTransaction().commit();
                                                                        System.out.println("Id: " + carroUp.getCarroID());
                                                                        System.out.println("Actualización enviada a la base de datos :D");
                                                                    } catch (Exception e) {
                                                                        em.getTransaction().rollback();
                                                                        e.printStackTrace();
                                                                        System.out.println("Ha ocurrido un error :(");
                                                                    }
                                                                    break;

                                                                case 2:
                                                                    System.out.println("Operacion Cancelada");
                                                                    break;

                                                                default:
                                                                    System.out.println("Operacion Cancelada");
                                                                    break;
                                                            }
                                                        } else {
                                                            System.out.println("Opción inválida, intentelo de nuevo");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Operacion Cancelada");
                                                }
                                            } else {
                                                System.out.println("No se encontró ningún carro con el carroID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        } finally {
                                            if (em != null && em.isOpen()) {
                                                em.close();
                                            }
                                        }
                                        break;

                                    case 4: //Borrar Carros
                                        System.out.println("Borrar Carros");
                                        System.out.print("Ingrese el ID del carro: ");
                                        int carroIDDl = scanner.nextInt();
                                        scanner.nextLine();

                                        CarrosJpaController ac2 = new CarrosJpaController(emf);
                                        Carros carroDl = null;

                                        try {
                                            carroDl = ac2.findCarros(carroIDDl);

                                            if (carroDl != null) {
                                                System.out.println("Id: " + carroDl.getCarroID());
                                                System.out.println("Marca: " + carroDl.getMarca());
                                                System.out.println("Nombre: " + carroDl.getNombre());
                                                System.out.println("Año: " + carroDl.getAnio());
                                                System.out.println("Placa: " + carroDl.getPlaca());
                                                System.out.println("Tipo de Combustible: " + carroDl.getTipoCombustible());
                                                System.out.println("---------------------------");
                                                System.out.println("Desea Eliminar este Registro?: 1.)Si 2.)No");
                                                int opDl = scanner.nextInt();
                                                scanner.nextLine();
                                                if (opDl == 1) {
                                                    try {
                                                        ac2.destroy(carroIDDl);
                                                        System.out.println("El carro con ID " + carroIDDl + " ha sido borrado correctamente.");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                        System.out.println("Error al intentar borrar el carro.");
                                                    }
                                                } else {
                                                    System.out.println("Operación Cancelada.");
                                                }

                                            } else {
                                                System.out.println("No se encontró ningún carro con el carroID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    /*finally {
                                            if (emf != null && emf.isOpen()) {
                                                emf.close();
                                            }
                                        }*/
                                    default:
                                        menudb = false;
                                        break;

                                    case 5:
                                        menudb = false;
                                        break;
                                }
                                break;

                            case 2: //Trabajar con balsas
                                System.out.println("Trabajaremos con Balsas");
                                System.out.println("1.) Insertar");
                                System.out.println("2.) Consultar");
                                System.out.println("3.) Actualizar");
                                System.out.println("4.) Borrar");
                                System.out.println("5.) Volver al menu principal");
                                System.out.print("Seleccione una opcion: ");
                                opmen = scanner.nextInt();
                                switch (opmen) {
                                    case 1: //insertar balsas
                                        Balsas bal = new Balsas();
                                        int intefiB = 0;
                                        String movBal = "";
                                        int opBal = 0;
                                        while (opBal != 1 && opBal != 2) {
                                            System.out.println("¿Cómo se moverá la balsa?:");
                                            System.out.println("1. Remo");
                                            System.out.println("2. Motor");
                                            opBal = scanner.nextInt();
                                            scanner.nextLine();

                                            if (opBal == 1 || opBal == 2) {
                                                System.out.print("Ingrese la Marca de la Balsa: ");
                                                String marcaB = scanner.nextLine();

                                                System.out.print("Ingrese el Año de lanzamiento: ");
                                                int anoB = scanner.nextInt();
                                                scanner.nextLine();

                                                System.out.print("Ingrese el nombre a registrar: ");
                                                String nombreB = scanner.nextLine();

                                                System.out.println("");
                                                System.out.println("Resumen: ");
                                                System.out.println("Marca: " + marcaB);
                                                System.out.println("Nombre: " + nombreB);
                                                System.out.println("Anio: " + anoB);
                                                System.out.println("Movimiento Balsa: " + opBal);
                                                System.out.println("");
                                                System.out.print("Confirmar 1.)Si 2.)No: ");
                                                int opconfirmar = scanner.nextInt();
                                                switch (opconfirmar) {
                                                    case 1:
                                                        bal.setMovimientoBalsa(opBal);
                                                        bal.setMarca(marcaB);
                                                        bal.setAnio(anoB);
                                                        bal.setNombre(nombreB);
                                                        try {
                                                            em.getTransaction().begin();
                                                            em.persist(bal);
                                                            em.getTransaction().commit();
                                                            System.out.println("Id: " + bal.getBalsaID());
                                                            System.out.println("Enviado a la base de datos :D");
                                                        } catch (Exception e) {
                                                            em.getTransaction().rollback();
                                                            e.printStackTrace();
                                                            System.out.println("Ha ocurrido un error :(");
                                                        }
                                                        /*finally {
                                                            em.close();
                                                        }*/
                                                        break;

                                                    case 2:
                                                        System.out.println("Operacion Cancelada");
                                                        break;

                                                    default:
                                                        System.out.println("Operacion Cancelada");
                                                        break;
                                                }
                                            } else {
                                                System.out.println("Opcion Invalida.");
                                            }
                                        }
                                        menu2 = false;
                                        break;

                                    case 2: //Leer Balsas
                                        System.out.println("Seleccionar Balsas");
                                        List<Balsas> lstBalsas = new ArrayList<>();
                                        BalsasJpaController aB = new BalsasJpaController(emf);
                                        try {
                                            lstBalsas = aB.findBalsasEntities();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        /*finally {
                                            em.close();
                                        }*/

                                        if (lstBalsas.isEmpty() == false) {
                                            for (Balsas ab : lstBalsas) {
                                                System.out.println("Id: " + ab.getBalsaID());
                                                System.out.println("Marca: " + ab.getMarca());
                                                System.out.println("Nombre: " + ab.getNombre());
                                                System.out.println("Anio: " + ab.getNombre());
                                                System.out.println("Movimiento Balsa: " + ab.getMovimientoBalsa());
                                                System.out.println("---------------------------");
                                            }
                                        } else {
                                            System.out.println("No hay datos para mostrar");
                                        }
                                        break;

                                    case 3: //Actualizar Balsas
                                        System.out.println("Actualizar Balsas");
                                        System.out.print("Ingrese el ID de la Balsa: ");
                                        int BalsaID = scanner.nextInt();
                                        scanner.nextLine();

                                        BalsasJpaController ab1 = new BalsasJpaController(emf);
                                        Balsas balsaUp = null;

                                        try {
                                            balsaUp = ab1.findBalsas(BalsaID);

                                            if (balsaUp != null) {
                                                System.out.println("Id: " + balsaUp.getBalsaID());
                                                System.out.println("Marca: " + balsaUp.getMarca());
                                                System.out.println("Nombre: " + balsaUp.getNombre());
                                                System.out.println("Año: " + balsaUp.getAnio());
                                                System.out.println("Moviemiento Balsa: " + balsaUp.getMovimientoBalsa());
                                                System.out.println("---------------------------");
                                                System.out.println("Desea Actualizar la información?: 1.)Si 2.)No");
                                                int opUp = scanner.nextInt();
                                                scanner.nextLine();
                                                int opbalUp = 0;
                                                if (opUp == 1) {
                                                    while (opbalUp != 1 && opbalUp != 2) {
                                                        System.out.println("¿Cómo se moverá la balsa?:");
                                                        System.out.println("1. Remo");
                                                        System.out.println("2. Motor");
                                                        opbalUp = scanner.nextInt();
                                                        scanner.nextLine();
                                                        if (opbalUp == 1 || opbalUp == 2) {

                                                            System.out.print("Ingrese la Marca de la Balsa: ");
                                                            String marcaB = scanner.nextLine();

                                                            System.out.print("Ingrese el Año de lanzamiento: ");
                                                            int anoB = scanner.nextInt();
                                                            scanner.nextLine();

                                                            System.out.print("Ingrese el nombre a registrar: ");
                                                            String nombreB = scanner.nextLine();

                                                            System.out.println("");
                                                            System.out.println("Resumen: ");
                                                            System.out.println("Marca: " + marcaB);
                                                            System.out.println("Nombre: " + nombreB);
                                                            System.out.println("Año: " + anoB);
                                                            System.out.println("Movimiento Balsa: " + opbalUp);
                                                            System.out.println("");
                                                            System.out.print("Confirmar 1.)Si 2.)No: ");
                                                            int opconfirmar = scanner.nextInt();

                                                            switch (opconfirmar) {
                                                                case 1:
                                                                    balsaUp.setMovimientoBalsa(opbalUp);
                                                                    balsaUp.setMarca(marcaB);
                                                                    balsaUp.setAnio(anoB);
                                                                    balsaUp.setNombre(nombreB);

                                                                    try {
                                                                        em.getTransaction().begin();
                                                                        em.merge(balsaUp);  // Actualiza la entidad existente
                                                                        em.getTransaction().commit();
                                                                        System.out.println("Id: " + balsaUp.getBalsaID());
                                                                        System.out.println("Actualización enviada a la base de datos :D");
                                                                    } catch (Exception e) {
                                                                        em.getTransaction().rollback();
                                                                        e.printStackTrace();
                                                                        System.out.println("Ha ocurrido un error :(");
                                                                    }
                                                                    break;

                                                                case 2:
                                                                    System.out.println("Operacion Cancelada");
                                                                    break;

                                                                default:
                                                                    System.out.println("Operacion Cancelada");
                                                                    break;
                                                            }
                                                        } else {
                                                            System.out.println("Opción inválida, intentelo de nuevo");
                                                        }
                                                    }
                                                } else {
                                                    System.out.println("Operacion Cancelada");
                                                }
                                            } else {
                                                System.out.println("No se encontró ninguna balsa con el BalsaID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        /*finally {
                                            if (em != null && em.isOpen()) {
                                                em.close();
                                            }
                                        }*/
                                        break;

                                    case 4: //Borrar Balsas
                                        System.out.println("Borrar Balsas");
                                        System.out.print("Ingrese el ID de la Balsa: ");
                                        int balsaIDDl = scanner.nextInt();
                                        scanner.nextLine();

                                        BalsasJpaController ab2 = new BalsasJpaController(emf);
                                        Balsas balsaDl = null;

                                        try {
                                            balsaDl = ab2.findBalsas(balsaIDDl);

                                            if (balsaDl != null) {
                                                System.out.println("Id: " + balsaDl.getBalsaID());
                                                System.out.println("Marca: " + balsaDl.getMarca());
                                                System.out.println("Nombre: " + balsaDl.getNombre());
                                                System.out.println("Año: " + balsaDl.getAnio());
                                                System.out.println("Movimiento Balsa: " + balsaDl.getMovimientoBalsa());
                                                System.out.println("---------------------------");
                                                System.out.println("Desea Eliminar este Registro?: 1.)Si 2.)No");
                                                int opDl = scanner.nextInt();
                                                scanner.nextLine();
                                                if (opDl == 1) {
                                                    try {
                                                        ab2.destroy(balsaIDDl);
                                                        System.out.println("La Balsa con ID " + balsaIDDl + " ha sido borrado correctamente.");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                        System.out.println("Error al intentar borrar la balsa.");
                                                    }
                                                } else {
                                                    System.out.println("Operación Cancelada.");
                                                }

                                            } else {
                                                System.out.println("No se encontró ninguna balsa con la BalsaID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    /*finally {
                                            if (emf != null && emf.isOpen()) {
                                                emf.close();
                                            }
                                        }*/
                                }
                                break;

                            case 3:
                                System.out.println("Trabajaremos con Aviones");
                                System.out.println("1.) Insertar");
                                System.out.println("2.) Consultar");
                                System.out.println("3.) Actualizar");
                                System.out.println("4.) Borrar");
                                System.out.println("5.) Volver al menu principal");
                                System.out.print("Seleccione una opcion: ");
                                opmen = scanner.nextInt();
                                switch (opmen) {
                                    case 1: //insertar aviones
                                        Aviones avi = new Aviones();
                                        System.out.println("Ingrese la cantidad de pasajeros en el Avion");
                                        int pasajeros = scanner.nextInt();
                                        scanner.nextInt();

                                        System.out.print("Ingrese la marca del Avion: ");
                                        String marcaA = scanner.nextLine();

                                        System.out.print("Ingrese el Año de lanzamiento: ");
                                        int anoA = scanner.nextInt();
                                        scanner.nextLine();

                                        System.out.print("Ingrese el nombre a registrar: ");
                                        String nombreA = scanner.nextLine();

                                        System.out.println("");
                                        System.out.println("Resumen: ");
                                        System.out.println("Marca: " + marcaA);
                                        System.out.println("Nombre: " + nombreA);
                                        System.out.println("Anio: " + anoA);
                                        System.out.println("Numero de pasajeros: " + pasajeros);
                                        System.out.println("");
                                        System.out.print("Confirmar 1.)Si 2.)No: ");
                                        int opconfirmar = scanner.nextInt();
                                        switch (opconfirmar) {
                                            case 1:
                                                avi.setCantidadPasajeros(pasajeros);
                                                avi.setMarca(marcaA);
                                                avi.setAnio(anoA);
                                                avi.setNombre(nombreA);
                                                try {
                                                    em.getTransaction().begin();
                                                    em.persist(avi);
                                                    em.getTransaction().commit();
                                                    System.out.println("Id: " + avi.getAvionesID());
                                                    System.out.println("Enviado a la base de datos :D");
                                                } catch (Exception e) {
                                                    em.getTransaction().rollback();
                                                    e.printStackTrace();
                                                    System.out.println("Ha ocurrido un error :(");
                                                }
                                                /*finally {
                                                            em.close();
                                                        }*/
                                                break;

                                            case 2:
                                                System.out.println("Operacion Cancelada");
                                                break;

                                            default:
                                                System.out.println("Operacion Cancelada");
                                                break;
                                        }
                                        menu2 = false;
                                        break;

                                    case 2: //Leer Aviones
                                        System.out.println("Seleccionar Aviones");
                                        List<Aviones> lstAviones = new ArrayList<>();
                                        AvionesJpaController aV = new AvionesJpaController(emf);
                                        try {
                                            lstAviones = aV.findAvionesEntities();
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        /*finally {
                                            em.close();
                                        }*/

                                        if (lstAviones.isEmpty() == false) {
                                            for (Aviones av : lstAviones) {
                                                System.out.println("Id: " + av.getAvionesID());
                                                System.out.println("Marca: " + av.getMarca());
                                                System.out.println("Nombre: " + av.getNombre());
                                                System.out.println("Anio: " + av.getNombre());
                                                System.out.println("Numero de pasajeros: " + av.getCantidadPasajeros());
                                                System.out.println("---------------------------");
                                            }
                                        } else {
                                            System.out.println("No hay datos para mostrar");
                                        }
                                        break;

                                    case 3: //Actualizar Aviones
                                        System.out.println("Actualizar Aviones");
                                        System.out.print("Ingrese el ID del Avion: ");
                                        int AvionID = scanner.nextInt();
                                        scanner.nextLine();

                                        AvionesJpaController av1 = new AvionesJpaController(emf);
                                        Aviones avionUp = null;

                                        try {
                                            avionUp = av1.findAviones(AvionID);

                                            if (avionUp != null) {
                                                System.out.println("ID: " + avionUp.getAvionesID());
                                                System.out.println("Marca: " + avionUp.getMarca());
                                                System.out.println("Nombre: " + avionUp.getNombre());
                                                System.out.println("Anio: " + avionUp.getAnio());
                                                System.out.println("Numero de pasajeros: " + avionUp.getCantidadPasajeros());
                                                System.out.println("------------------------------------");
                                                System.out.print("¿Desea actualizar la Informacion? 1.)Si 2.)No: ");
                                                int opUp = scanner.nextInt();
                                                scanner.nextLine();
                                                if (opUp == 1) {
                                                    System.out.println("Ingrese la cantidad de pasajeros en el Avion");
                                                    pasajeros = scanner.nextInt();
                                                    scanner.nextInt();

                                                    System.out.print("Ingrese la marca del Avion: ");
                                                    marcaA = scanner.nextLine();

                                                    System.out.print("Ingrese el Año de lanzamiento: ");
                                                    anoA = scanner.nextInt();
                                                    scanner.nextLine();

                                                    System.out.print("Ingrese el nombre a registrar: ");
                                                    nombreA = scanner.nextLine();

                                                    System.out.println("");
                                                    System.out.println("Resumen: ");
                                                    System.out.println("Marca: " + marcaA);
                                                    System.out.println("Nombre: " + nombreA);
                                                    System.out.println("Anio: " + anoA);
                                                    System.out.println("Numero de pasajeros: " + pasajeros);
                                                    System.out.println("");
                                                    System.out.print("Confirmar 1.)Si 2.)No: ");
                                                    opconfirmar = scanner.nextInt();
                                                    switch (opconfirmar) {
                                                        case 1:
                                                            avionUp.setCantidadPasajeros(pasajeros);
                                                            avionUp.setMarca(marcaA);
                                                            avionUp.setAnio(anoA);
                                                            avionUp.setNombre(nombreA);
                                                            try {
                                                                em.getTransaction().begin();
                                                                em.persist(avionUp);
                                                                em.getTransaction().commit();
                                                                System.out.println("Id: " + avionUp.getAvionesID());
                                                                System.out.println("Enviado a la base de datos :D");
                                                            } catch (Exception e) {
                                                                em.getTransaction().rollback();
                                                                e.printStackTrace();
                                                                System.out.println("Ha ocurrido un error :(");
                                                            }
                                                            /*finally {
                                                            em.close();
                                                        }*/
                                                            break;

                                                        case 2:
                                                            System.out.println("Operacion Cancelada");
                                                            break;

                                                        default:
                                                            System.out.println("Operacion Cancelada");
                                                            break;
                                                    }
                                                } else {
                                                    System.out.println("Operacion Cancelada");
                                                }

                                            } else {
                                                System.out.println("No se encontró ningun Avion con el AvionID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                        /*finally {
                                            if (em != null && em.isOpen()) {
                                                em.close();
                                            }
                                        }*/
                                        break;

                                    case 4: //Borrar Aviones
                                        System.out.println("Borrar Aviones");
                                        System.out.print("Ingrese el ID del Avion: ");
                                        int avionIDDl = scanner.nextInt();
                                        scanner.nextLine();

                                        AvionesJpaController av2 = new AvionesJpaController(emf);
                                        Aviones avionDl = null;

                                        try {
                                            avionDl = av2.findAviones(avionIDDl);

                                            if (avionDl != null) {
                                                System.out.println("Id: " + avionDl.getAvionesID());
                                                System.out.println("Marca: " + avionDl.getMarca());
                                                System.out.println("Nombre: " + avionDl.getNombre());
                                                System.out.println("Año: " + avionDl.getAnio());
                                                System.out.println("Numero de pasajeros: " + avionDl.getCantidadPasajeros());
                                                System.out.println("---------------------------");
                                                System.out.println("Desea Eliminar este Registro?: 1.)Si 2.)No");
                                                int opDl = scanner.nextInt();
                                                scanner.nextLine();
                                                if (opDl == 1) {
                                                    try {
                                                        av2.destroy(avionIDDl);
                                                        System.out.println("El Avion con ID " + avionIDDl + " ha sido borrado correctamente.");
                                                    } catch (Exception e) {
                                                        e.printStackTrace();
                                                        System.out.println("Error al intentar borrar la balsa.");
                                                    }
                                                } else {
                                                    System.out.println("Operación Cancelada.");
                                                }

                                            } else {
                                                System.out.println("No se encontró ningun avion con la AvionID especificado.");
                                            }
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    /*finally {
                                            if (emf != null && emf.isOpen()) {
                                                emf.close();
                                            }
                                        }*/
                                }
                                break;

                            case 4:
                                menu1 = true;
                                menudb = false;
                                break;
                            default:
                                System.out.println("Ha ocurrido un error");
                                menudb = false;
                                break;
                        }
                    } while (menudb == true);
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
        System.out.println("3.)Fase 3 - Bases de datos");
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
