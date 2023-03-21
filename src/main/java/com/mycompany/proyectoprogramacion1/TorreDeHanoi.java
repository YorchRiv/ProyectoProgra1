package com.mycompany.proyectoprogramacion1;

class TorreDeHanoi {

    public int origen;
    public int destino;
    public int auxiliar; //Atributos

    public TorreDeHanoi(int origen, int destino, int auxiliar) { //constructor
        this.origen = origen;
        this.destino = destino;
        this.auxiliar = auxiliar;

    }

    public void ResolverTorreDeHanoi(int n, int origen, int destino, int auxiliar) { //Metodo
        if (n == 1) {
            System.out.println("Mover disco 1 de " + origen + " --> " + destino);
        } else {
            ResolverTorreDeHanoi(n - 1, origen, auxiliar, destino);
            System.out.println("Mover disco " + n + " de " + origen + " --> " + destino);
            ResolverTorreDeHanoi(n - 1, auxiliar, destino, origen);
        }

    }
}
