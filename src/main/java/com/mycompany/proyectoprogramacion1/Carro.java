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
public class Carro extends vehiculo{
    private String placa;
    private String tipoCom;

    //Constructor
    public Carro(String marca, String nombre, int ano, String placa, String tipoCom){
        super(marca, nombre, ano);
        this.placa = placa;
        this.tipoCom = tipoCom;
    }

    //getters
    public String getPlaca(){
        return placa;
    }
    public String getTipoComb(){
        return tipoCom;
    }

    //setters
    public void setPlaca(String placa){
        this.placa = placa;
    }

    public void setTipoCombustible(String tipoCom){
        this.tipoCom = tipoCom;
    }


    //Metodos
    public void mostrarInfoCarro(){
        super.mostrarInfo();
        System.out.println("Placa: " + placa);
        System.out.println("Tipo Combustible: " + tipoCom);
    }
}
