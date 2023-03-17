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
    private String placa;
    private String nombre;
    private int ano;

    //Constructor
    public vehiculo(String marca, String placa, String nombre, int ano){
        this.marca = marca;
        this.placa = placa;
        this.nombre = nombre;
        this.ano = ano;
    }

    //Getters
    public String getMarca(){
        return marca;
    }
    public String getPlaca(){
        return placa;
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
    public void setPlaca(String placa){
        this.placa = placa;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public void setAno(int ano){
        this.ano = ano;
    }
}
