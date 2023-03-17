/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogramacion1;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author mynor
 */
public class TorreDeHanoi {
    
     try (Scanner sc = new Scanner(System.in)) {
            int numDiscos = 0;
            do {
                System.out.print("Ingrese la cantidad de discos (debe ser mayor o igual a 3): ");
                numDiscos = sc.nextInt();
                if (numDiscos < 3) {
                    System.out.println("Debe ingresar un mínimo de 3 discos para realizar la Torre de Hanoi.");
                }
            } while (numDiscos < 3);
            
            Stack<Integer> pila1 = new Stack<Integer>();
            Stack<Integer> pila2 = new Stack<Integer>();
            Stack<Integer> pila3 = new Stack<Integer>();
            
            for (int i = numDiscos; i >= 1; i--) {
                pila1.push(i);
            }
            
            imprimirPilas(pila1, pila2, pila3);
            
            resolverTorreHanoi(numDiscos, pila1, pila3, pila2);
            
            System.out.println("Estado final de las pilas:");
            imprimirPilas(pila1, pila2, pila3);
        }
    
    
}
