/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.seniordelosanillos;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Ivanna Ariza
 */
public  class SeniorDeLosAnillos {

    public static void main(String[] args) {
        //creacion de los dos arrayList 
        ArrayList<Personaje> Oscuridad = new ArrayList();
        ArrayList<Personaje> Luz = new ArrayList();
        Juego j = new Juego();//inicializo la clase del juego
        boolean rep = false;
        Personaje us;
        Personaje op;
        boolean muerteOP = false, muerteUS = false;      
        
        j.presentacion();//imprimo el pergamino
        j.creacion(Oscuridad, Luz);//creo los 8 personajes en sus arrays
        if(j.EscogerBando()==1){
            do{
                if(j.personajeVivo(Luz)==true){
                    do{
                        us = j.escogerPersonaje(Luz);//usuario elige
                        if(us.getNivelVida()==0){
                            System.out.println("Elige otro personaje, ese está muerto y no puedo salir a la batalla");
                            rep = true;
                        }else{
                            rep = false;
                        }
                    }while(rep==true);
                    
                    if(j.personajeVivo(Oscuridad)==true){
                        do{
                            op = j.contrincante(Oscuridad);//enemigo aleatorio
                        }while(op.getNivelVida()==0); 
                        System.out.println("\t\t\tTu oponente es " + op.getNombre());
                        j.batalla(op,us);//se desarrolla la pelea
                    }else{
                        System.out.println("Todos tus opnentes han muerto...");
                        muerteOP = true;
                    }
                }else{
                    System.out.println("Todos tus personajes han muerto...");
                    muerteUS = true;
                }
            }while(muerteUS==false&&muerteOP==false);
            
        }else{
            do{
                if(j.personajeVivo(Oscuridad)==true){
                    do{
                        us = j.escogerPersonaje(Oscuridad);//usuario elige
                        if(us.getNivelVida()==0){
                            System.out.println("Elige otro personaje, ese está muerto y no puedo salir a la batalla");
                            rep = true;
                        }else{
                            rep = false;
                        }
                    }while(rep==true);

                    if(j.personajeVivo(Luz)==true){
                        do{
                            int x;
                            op = j.contrincante(Luz);//enemigo aleatorio
                        }while(op.getNivelVida()==0); 
                        System.out.println("\t\t\tTu oponente es " + op.getNombre());
                        j.batalla(op,us);//se desarrolla la pelea
                    }else{
                        System.out.println("Todos tus opnentes han muerto...");
                        muerteOP = true;
                    }
                }else{
                    System.out.println("Todos tus personajes han muerto...");
                    muerteUS = true;
                }
            }while(muerteUS==false&&muerteOP==false);
        }   
        j.despedida();
    }
    
}
