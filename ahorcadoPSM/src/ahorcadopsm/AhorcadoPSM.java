/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadopsm;

import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class AhorcadoPSM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Introduce el nombre del jugador 1: ");
        String nombre1 = s.nextLine();
        System.out.println("Introduce el nombre del jugador 2: ");
        String nombre2 = s.nextLine();
        
        Jugador juego = new Jugador();
        int victorias1=0, victorias2=0;
        
        juego.empezarJuego(nombre1);
        if(juego.adivinarPalabras(nombre2)){
          victorias2++; 
        }    
        
        juego.empezarJuego(nombre2);
        if(juego.adivinarPalabras(nombre1)){
          victorias1++; 
        }  
        
        juego.empezarJuego(nombre1);
        if(juego.adivinarPalabras(nombre2)){
          victorias2++; 
        }  
        
        juego.empezarJuego(nombre2);
        if(juego.adivinarPalabras(nombre1)){
          victorias1++; 
        }  
        
        juego.empezarJuego(nombre1);
        if(juego.adivinarPalabras(nombre2)){
          victorias2++; 
        }  
        
        juego.empezarJuego(nombre2);
        if(juego.adivinarPalabras(nombre1)){
          victorias1++; 
        }
        
        if(victorias1 > victorias2) {
            System.out.println("¡Ha ganado " + nombre1 + " por " + victorias1 + " a " + victorias2 + "!");
        } else if (victorias2 > victorias1){
            System.out.println("¡Ha ganado " + nombre2 + " por " + victorias2 + " a " + victorias1 + "!");
        } else {
            System.out.println("¡Empate " + victorias1 + " a " + victorias2 + "!");
        }
    }
    
}
