/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.seniordelosanillos.Guerrero;
import com.mycompany.seniordelosanillos.Juego;
import com.mycompany.seniordelosanillos.Mago;
import com.mycompany.seniordelosanillos.Personaje;
import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Ivanna Ariza
 */
public class JuegoTest {
    Juego j;
    ArrayList<Personaje> Luz;
    ArrayList<Personaje> Oscuridad;
    
    @BeforeEach
    public void setUp() {
        j = new Juego();
        Oscuridad = new ArrayList();
        Luz = new ArrayList();
        
        j.creacion(Oscuridad, Luz);
    }
 
    
    @Test 
    public void contrincanteTest(){
        assertNotNull(j.contrincante(Oscuridad), "Error, valor nulo");
        //el valor es nulo en la variable que elige aleatoriamente el contrincante con el bando de la oscuridad
    }
    
    @Test 
    public void contrincanteTest2(){
        assertNotNull(j.contrincante(Luz), "Error, valur nulo");
        //el valor es nulo en la variable que elige aleatoriamente el contrincante con el bando de la luz
    }
    
   
}
