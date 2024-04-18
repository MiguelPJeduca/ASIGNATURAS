/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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
public class Juego {
    Scanner sc = new Scanner(System.in);
    /**
     *presentacion del juego
     */
    public void presentacion(){
        System.out.println("                                             _______________________\n" +
        "   _______________________-------------------                       `\\\n" +
        " /:--__                                                              |\n" +
        "||< > |                                   ___________________________/\n" +
        "| \\__/_________________-------------------                         |\n" +
        "|                                                                  |\n" +
        " |                     EL SEÑOR DE LOS ANILLOS                      |\n" +
        " |                                                                  |\n" +
        " |        Bienvenido al juego del señor de los anillos,             |\n" +
        "  |                                                                  |\n" +
        "  |       en esta épica batalla podrás enfrentarte a cuatro          |\n" +
        "  |                                                                  |\n" +
        "  |     de los más admirables guerreros y elegir el bando que        |\n" +
        "   |                                                                  |\n" +
        "   |                     más te convenga.                             |\n" +
        "   |                                                .                |\n" +
        "  |                                              ____________________|_\n" +
        "  |  ___________________-------------------------                      `\\\n" +
        "  |/`--_                                                                 |\n" +
        "  ||[ ]||                                            ___________________/\n" +
        "   \\===/___________________--------------------------");
    }
    
    /**
     *creacion de los personajes
     * @param Oscuridad 
     * @param Luz
     */
    public void creacion(ArrayList<Personaje> Oscuridad, ArrayList<Personaje> Luz){
        Personaje Gandalf = new Mago("Gandalf", 10,25,100);
        Personaje Aragorn = new Guerrero("Aragorn", 20, 20, 100);
        Personaje Legolas = new Guerrero("Legolas", 25,15,100);
        Personaje Gimli = new Guerrero("Gimli", 20,10,100);
        
        Personaje Saruman = new Mago("Saruman", 10,25,100);
        Personaje Balrog = new Mago("Balrog", 10,35,100);
        Personaje Lurtz = new Guerrero("Lurtz", 15,25,100);
        Personaje Orco = new Guerrero("Orco", 5, 5, 100);
        
        Luz.add(Gandalf);
        Luz.add(Aragorn);
        Luz.add(Legolas);
        Luz.add(Gimli);

        Oscuridad.add(Saruman);
        Oscuridad.add(Balrog);
        Oscuridad.add(Lurtz);
        Oscuridad.add(Orco);
    }
     
    /**
     *
     * @return bando, devuelve la eleccion del usuario
     */
    public int EscogerBando(){
        int bando = 0;
            do{
                try{
                    //menú de bando
                    System.out.println("\n\n\n\n\t\t---------------------------------------");
                    System.out.println("\t\t   A: ATAQUE, D: DEFENSA, V: VIDA\n\n"
                            + "\t\t\tTienes dos bandos:"
                            + "\n\n\t\t\t * 1 - Luz\n"
                            + "\t\t\t   Compuesto por:\n"
                            + "\t\t\t    -> 0 - Gandalf (A:25/D:10/V:100)\n"
                            + "\t\t\t    -> 1 - Aragorn (A:20/D:20/V:100)\n"
                            + "\t\t\t    -> 2 - Legolas (A:15/D:25/V:100)\n"
                            + "\t\t\t    -> 3 - Gimli (A:10/D:20/V:100)\n"
                            + "\n\t\t\t * 2 - Oscuridad\n"
                            + "\t\t\t   Compuesto por:\n"
                            + "\t\t\t    -> 0 - Saruman (A:25/D:10/V:100)\n"
                            + "\t\t\t    -> 1 - Balrog (A:35/D:10/V:100)\n"
                            + "\t\t\t    -> 2 - Lurtz (A:25/D:15/V:100)\n"
                            + "\t\t\t    -> 3 - Orco (A:5/D:5/V:100)\n"
                            + "\n\t\t\t¿Cúal eliges?");
                    System.out.print("\n\t\t ");
                    bando = sc.nextInt();//elección de bando

                    if(bando<1||bando>2){
                        //control de errores
                        System.out.println("\n\t\t Introduce bien tu respuesta.");
                    }
                    System.out.println("\t\t---------------------------------------");         
                }
                catch(InputMismatchException e){
                    //error si introduce letras o caracteres
                    e.getMessage();
                    System.out.println("Solo se aceptan dos numeros, vuelve a intentarlo");
                    sc.nextLine();//limpiar la variable sc
                }
                
            }while(bando<1 || bando>2);
            //bucle repetitivo por si se introduce mal
        return bando;
    }
    
    /**
     *
     * @param bando
     * @return p, devuelve el personaje elegido por el usuario
     */
    public Personaje escogerPersonaje(ArrayList<Personaje> bando){
        Personaje p = bando.get(0);
        int eleccion;
        boolean rep = false;//variable para repetir el bucle
        do{
            try{
                do{
                    
                    System.out.println("\t\t  ¿Que personaje quieres usar? \n\t\tintroduce solo los números dados anteriormente");
                    System.out.print("\n\t\t ");
                    eleccion = sc.nextInt();//usuario elige
                    if(eleccion<0||eleccion>3){
                        //control de errores fuera de rango
                        System.out.println("\t\t  Introduce bien tu respuesta");
                    }
                }while(eleccion<0||eleccion>3);
                System.out.println( "\t\tTu personaje elegido finalmente es " + bando.get(eleccion).getNombre());
                sc.nextLine();//para limpiar sc
                p = bando.get(eleccion);// p = personaje elegido
            }catch(InputMismatchException e){
                //control de errores con letras o caracteres
                rep = true;
                e.getMessage();
                System.out.println("\t\tIntroduce un numero valido");
                sc.nextLine();
            }
        }while(rep);//repite el bucle mientras la respuesta no sea la esperada
        return p;
    }
    
    /**
     *
     * @param contrincante
     * @return op, devuelve el oponente
     */
    public Personaje contrincante(ArrayList<Personaje> contrincante){
        Random rd = new Random();
        Personaje op;
            do{
                int r = rd.nextInt(0,3);
                op = contrincante.get(r);//oponente random
            }while(op.getNivelVida()==0);//repetir si la vida es 0
        System.out.println("\t\t\tTu oponente es " + op.getNombre());
        return op;
    }
    
    /**
     *
     * @param p
     * @return puntosAtaque, generado random
     */
    public int atacar(Personaje p){
        Random atq = new Random();
        //atq minimo = 1, maximo = nivel atq
        int puntosAtaque = atq.nextInt(1,p.getNivelAtq());
        return puntosAtaque;
    }
    
    /**
     *
     * @param p
     * @return la defensa o un cero con un 15% de probabilidad
     */
    public int defender(Personaje p){
        Random rd = new Random();
        //defensa fija:10
        int probDef = rd.nextInt(1,100);
        if(probDef<15){
            //probabilidad del 15%
            return p.getNivelDef();
        }else{
            return 0;
        }

    }
    
    /**
     *
     * @return el daño critico o cero con un 15% de probabilidad
     */
    public int probCritico(){
        Random cr = new Random();
        int critico = cr.nextInt(1,100);
        if(critico<15){
            //probabilidad del 15%
            return critico;
        }else{
            return 0;
        }
        
    }
    
    /**
     *
     * @return 10 de curacion o 0 con un 15% de probabilidad
     */
    public int recuperaVida(){
        Random cr = new Random();
        int prob = cr.nextInt(1,100);
        if(prob<15){
            //probabilidad del 15%
            return 10;
        }else{
            return 0;
        }
    }
    
    /**
     *
     * @param x
     * @return elergir, eleccion del usuario a las opciones del personaje mago
     */
    public int menuMago(Personaje x){
        int elegir = 0;
        do{
            try{
                System.out.println("Que quieres hacer:\n1 - Atacar\n2 - Defender\n3 - Curarse");
                elegir = sc.nextInt();
                if(elegir<1||elegir>3){
                    System.out.println("Incorrecto, vuelve a intentar");
                }
            }catch(InputMismatchException e){
                e.getMessage();
                System.out.println("No se aceptan esos carácteres");
                sc.nextLine();
            }
        }while(elegir<1||elegir>3);
        
        return elegir;
    }
    
    /**
     *
     * @param x
     * @return elergir, eleccion del usuario a las opciones del personaje guerrero
     */
    public int menuGuerrero(Personaje x){
        int elegir = 0;
        do{
            try{
                
                System.out.println("Que quieres hacer:\n1 - Atacar\n2 - Defender");
                elegir = sc.nextInt();
                if(elegir<1||elegir>2){
                    System.out.println("Incorrecto, vuelve a intentar");
                }
            }catch(InputMismatchException e){
                e.getMessage();
                System.out.println("No se aceptan esos carácteres");
                sc.nextLine();
            }
        }while(elegir<1||elegir>2);
        
        return elegir;  
    }
    
    /**
     *
     * @param p
     * @return m o g dependiendo si son guerreros o magos
     */
    public int EleccionContrincante(Personaje p){
        Random rd = new Random();
        if(p instanceof Guerrero){
            int g = rd.nextInt(1,2);
            return g;
        }else{
            int m = rd.nextInt(1,3);
            return m;
        }  
    }
    
    /**
     *
     * @param usuario
     * @param contrincante
     * @param eleccion
     */
    public void turnoUsuario(Personaje usuario, Personaje contrincante, int eleccion){
        int daño;
        int defU = 0;
        int defC = 0;
        boolean seDefiendeC = false;
        switch(eleccion){
            case 1:
                daño = atacar(usuario);//daño que hace el usuario
                System.out.println("¡" + usuario.getNombre() + " ha hecho un ataque de " + daño + "!");
                if(seDefiendeC==true){
                    if(defC<daño){
                        int x = daño - defC;//se resta el daño menos la defensaa
                        contrincante.setNivelVida(contrincante.getNivelVida()-x);//altualizo la vida del contrincante
                    }else{
                        System.out.println("La defensa ha bloqueado todo el daño");
                    }
                }else{
                    contrincante.setNivelVida(contrincante.getNivelVida()-daño);
                }
                break;
            case 2:
                defU = defender(usuario);//15% de posibilidad de defenderse
                System.out.println("Tu defensa ha sido de " + defU);
                break;
            case 3:
                if(recuperaVida()==10){
                    if(usuario.getNivelVida()<100){
                        System.out.println("Te has curado 10 de vida");
                        usuario.setNivelVida(usuario.getNivelVida()+10);
                        if(usuario.getNivelVida()>100){
                            usuario.setNivelVida(100);
                        }
                    }else{
                        System.out.println("Tu vida está a full");
                    }
                }else{
                    System.out.println("No te has podido curar");
                }
                break;
        }
    }
    
    /**
     *
     * @param usuario
     * @param contrincante
     */
    public void turnoMaquina(Personaje usuario, Personaje contrincante){
        int daño = 0;
        int defU = 0;
        int defC = 0;
        boolean seDefiendeU = false;
        switch(EleccionContrincante(contrincante)){
            case 1:
                daño = atacar(contrincante);
                System.out.println("Tu contrincante ha hecho un ataque de " + daño);
                if(seDefiendeU==true){
                    if(defU<daño){
                        int x = daño - defU;
                        usuario.setNivelVida(usuario.getNivelVida()-x);//altualizo la vida del contrincante
                    }else{
                        System.out.println("La defensa del enemigo ha bloqueado todo tu daño");
                    }
                }else{
                    usuario.setNivelVida(usuario.getNivelVida()-daño);
                }
                System.out.println("");
                break;
            case 2:
                defC = defender(contrincante);
                if(defC==0){
                    System.out.println("El contrincante ha intentado defenderse pero no ha podido");
                }else{
                    System.out.println("El contrincante se ha defendido");
                }
                break;
            case 3:
                if(recuperaVida()==10){
                    System.out.println("El contrincante se ha curado un 10 de vida");
                    if(contrincante.getNivelVida()< 100){
                        contrincante.setNivelVida(contrincante.getNivelVida()+10);
                        if(contrincante.getNivelVida()>100){
                            contrincante.setNivelVida(100);
                        }
                     }
                }else{
                    System.out.println("El contrincante se ha curado un 10 de vida");
                }
                break;
        }
    }
    
    /**
     *
     * @param contrincante
     * @param usuario
     */
    public void batalla(Personaje contrincante, Personaje usuario){
        boolean muerto=false;
        boolean ganador = false;
        
        int eleccion;
        
        System.out.println("\t\t**La batalla está a punto de comenzar**\n\n");
        System.out.println("Comienza " + usuario.getNombre());
        System.out.println("Vida de " + usuario.getNombre() + ": " + usuario.getNivelVida());
        System.out.println("Vida de " + contrincante.getNombre() + ": " + contrincante.getNivelVida());
            
            do{
                if(contrincante.getNivelVida()<=0||usuario.getNivelVida()<=0){
                    muerto=true;  
                }else{
                    if(usuario instanceof Guerrero){
                        //juega el usuario guerrero
                        eleccion = menuGuerrero(usuario);
                    }else{
                        //juega el usuario mago
                        eleccion = menuMago(usuario);                
                    }
                    turnoUsuario(usuario, contrincante, eleccion);

                    //juega la maquina
                    turnoMaquina(usuario, contrincante);
                    
                    
                    if(usuario.getNivelVida()<0){
                        usuario.setNivelVida(0);
                        
                    }else if(contrincante.getNivelVida()<0){
                        ganador=true;
                        contrincante.setNivelVida(0);
                    }
                    System.out.println("Vida " + usuario.getNombre() + ": " + usuario.getNivelVida());
                    System.out.println("Vida " + contrincante.getNombre() + ": " + contrincante.getNivelVida());
                }
            }while(muerto==false);
            if(ganador==true){
                System.out.println("¡Felicidades, has ganado!");
            }else{
                System.out.println("Oh no...has perdido.");
            }   
   }
    
    /**
     *
     * @param grupo
     * @return
     */
    public boolean personajeVivo(ArrayList<Personaje> grupo){
        for(int i=0; i<grupo.size(); i++){
            if(grupo.get(i).getNivelVida()>0){
                return true;
            }
        }
       return false;
   }
    
    /**
     *
     */
    public void despedida(){
        System.out.println("\n\nEl juego se ha termiando, gracias por jugar :)");
    }
    
}
