package com.mycompany.proyectoprogramacion1;

import java.util.Scanner;

public class TorreDeHanoi {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); //Esta linea es para poder ingresar datos
        int n; //número de discos en la torre inicial
        
        do { //Validación de número de discos
            System.out.print("Ingrese el número de discos (mínimo 3): ");
            n = sc.nextInt(); //aqui se ingresa el numero de discos  
            if (n < 3) { //si el numero de discos es menor a 3, se imprime el siguiente mensaje
                System.out.println("Debe ingresar un mínimo de 3 discos para realizar la Torre de Hanoi.");
            }
        } while (n < 3); //si el numero de discos es menor a 3, se vuelve a pedir el numero de discos
        
        int[][] torres = new int[3][n]; //creación de la matriz de las torres
        llenarTorreInicial(torres); //llena la torre inicial con los discos
        imprimirTorres(torres); 
        
        resolverTorreDeHanoi(n, 0, 2, 1, torres); //resuelve la torre de hanoi
    }
    
    public static void llenarTorreInicial(int[][] torres) { //llena la torre inicial con los discos
        for (int i = 0; i < torres[0].length; i++) { //recorre la torre inicial de la matriz de las torres 
            torres[0][i] = torres[0].length - i; //llena la torre inicial con los discos de mayor a menor
        } 
    }
    
    public static void resolverTorreDeHanoi(int n, int origen, int destino, int auxiliar, int[][] torres) { //resuelve la torre de hanoi
        if (n == 1) { //si el numero de discos es 1, se mueve el disco de la torre inicial a la torre final 
            moverDisco(origen, destino, torres); //mover disco de la torre inicial a la torre final
        } else { 
            resolverTorreDeHanoi(n - 1, origen, auxiliar, destino, torres);
            moverDisco(origen, destino, torres);
            resolverTorreDeHanoi(n - 1, auxiliar, destino, origen, torres);
        }
    }
    
    public static void moverDisco(int origen, int destino, int[][] torres) {
        int disco = torres[origen][torreNoVacia(torres[origen])]; //disco que se va a mover
        torres[origen][torreNoVacia(torres[origen])] = 0; //se borra el disco de la torre inicial
        torres[destino][torreVacia(torres[destino])] = disco; //se coloca el disco en la torre final
        System.out.println("Mover disco de la torre " + (origen+1) + " --> torre " + (destino+1)); 
        imprimirTorres(torres); 
    }
    
    public static int torreVacia(int[] torre) {  
        for (int i = 0; i < torre.length; i++) { //recorre la torre final de la matriz de las torres
            if (torre[i] == 0) { //si la torre final esta vacia, se coloca el disco en la torre final
                return i; 
            }
        }
        return -1; 
    }
    
    public static int torreNoVacia(int[] torre) {
        for (int i = torre.length - 1; i >= 0; i--) {
            if (torre[i] != 0) { //si la torre inicial no esta vacia, se mueve el disco de la torre inicial a la torre final
                return i;
            }
        }
        return -1;
    }
    
    public static void imprimirTorres(int[][] torres) {
        for (int i = torres[0].length - 1; i >= 0; i--) {
            for (int j = 0; j < torres.length; j++) {
                if (torres[j][i] == 0) {
                    System.out.print("   |   ");
                } else {
                    System.out.print("  " + torres[j][i] + "  ");
                }
            }
            System.out.println();
        }
        System.out.println("---------------");
        System.out.println();
    }
}

   



