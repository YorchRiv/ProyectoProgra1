/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogramacion1;

/**
 *
 * @author oskto
 */
public class Avion extends vehiculo{
    private int  numPasajeros;
    
    public Avion( String marca, String nombre, int ano, int numPasajeros){
        super(marca, nombre, ano);
        this.numPasajeros = numPasajeros;
        
    }
    
    public int getNumPasajeros(){
        return numPasajeros;
    }
    
    public void setNumPasajeros(int numPasajeros){
        this.numPasajeros = numPasajeros;
    }
    
    public void mostrarInfo(){
        super.mostrarInfo();
        System.out.println("El numero de pasajeros es: " + numPasajeros);
    }
    
}
