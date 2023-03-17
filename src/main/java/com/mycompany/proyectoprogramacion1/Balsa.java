/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogramacion1;

/**
 *
 * @author oskto
 */
public class Balsa extends vehiculo{
    private String  opcionBalsa;
    
    public Balsa( String marca, String nombre, int ano, String opcionBalsa){
        super(marca, nombre, ano);
        this.opcionBalsa = opcionBalsa;
        
    }
    
    public String getOpcion(){
        return opcionBalsa;
    }
    
    public void setOpcion(String opcionBalsa){
        this.opcionBalsa = opcionBalsa;
    }
    
    public void mostrarInfoBalsa(){
        super.mostrarInfo();
        System.out.println("La balsa se mueve por: " + opcionBalsa);
    }
}
