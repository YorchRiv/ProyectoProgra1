/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectoprogramacion1;

/**
 *
 * @author oskto
 * @author yorchriv
 */

public class vehiculo{
    private String marca;
    private String nombre;
    private int ano;

    //Constructor
    public vehiculo(String marca, String nombre, int ano){
        this.marca = marca;
        this.nombre = nombre;
        this.ano = ano;
    }

    //Getters
    public String getMarca(){
        return marca;
    }
    public String getNombre(){
        return nombre;
    }
    public int getAno(){
        return ano;
    }

    //Setters
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    //Metodos
    public void mostrarInfo(){
        System.out.println("Marca: "+ marca);
        System.out.println("Propietario: "+ nombre);
        System.out.println("Ano Lanzamiento: "+ marca);
    }
}
