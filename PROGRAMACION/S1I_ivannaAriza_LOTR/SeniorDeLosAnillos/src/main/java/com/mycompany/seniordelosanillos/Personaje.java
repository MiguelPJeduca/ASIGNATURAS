/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.seniordelosanillos;

/**
 *
 * @author Ivanna Ariza
 */
public abstract class Personaje{
    //atributo
    private String nombre;
    private int nivelDef;
    private int nivelAtq;
    private int nivelVida;
    
    //constuctor
    public Personaje(String _nombre, int D, int A, int V){
        nombre = _nombre;
        nivelDef = D;
        nivelAtq = A;
        nivelVida = V;
    }
    
    //metodos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNivelDef() {
        return nivelDef;
    }

    public void setNivelDef(int nivelDef) {
        this.nivelDef = nivelDef;
    }

    public int getNivelAtq() {
        return nivelAtq;
    }

    public void setNivelAtq(int nivelAtq) {
        this.nivelAtq = nivelAtq;
    }

    public int getNivelVida() {
        return nivelVida;
    }

    public void setNivelVida(int nivelVida) {
        this.nivelVida = nivelVida;
    }

    
    
    
    
}
