/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ahorcadopsm;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Jugador {

    private String palabra, palabraFiltrada;
    private int intentos;

    public Jugador() {
    }

    public void empezarJuego(String nombre) {
        Scanner s = new Scanner(System.in);
        System.out.println("\n\nEscribe la palabra " + nombre);
        System.out.println("Introduzca la palabra a adivinar: ");
        this.palabra = s.nextLine();
        this.palabra = this.palabra.toLowerCase();
        while(!this.contieneSoloLetras(palabra)){
            System.out.println("No se pueden introducir números ni símbolos");
            System.out.println("Introduzca la palabra a adivinar: ");
            this.palabra = s.nextLine();
            this.palabra = this.palabra.toLowerCase();
        }
        this.palabraFiltrada = "";

        for (int i = 0; i < this.palabra.length(); i++) {
            this.palabraFiltrada = palabraFiltrada + '-';
        }
        System.out.println("---------------------------------------------------------------");
        System.out.println("La palabra a adivinar es la siguiente: \n" + palabraFiltrada);
    }

    public boolean adivinarPalabras(String nombre) {
        this.intentos = 6;
        Scanner s = new Scanner(System.in);
        ArrayList<String> letras = new ArrayList();
        System.out.println("\nIntentará adivinar la palabra " + nombre);
        while (this.intentos > 0) {
            System.out.println("Intentos restantes: " + this.intentos);
            System.out.println("Introduzca letra o palabra: ");
            String temp = s.nextLine();
            temp = temp.toLowerCase();
            while(!this.contieneSoloLetras(temp)){
                System.out.println("No se pueden introducir números ni símbolos");
                System.out.println("Introduzca letra o palabra: ");
                temp = s.nextLine();
                temp = temp.toLowerCase();
            }
            if (temp.equals(this.palabra)) {
                System.out.println("¡Has adivinado la palabra!");
                return true;
            } else if (this.palabra.contains(temp)) {
                System.out.println("La letra indicada está en la palabra");
                letras.add(temp);
                int cantidad = letras.size();
                this.palabraFiltrada = "";
                for (int i = 0; i < this.palabra.length(); i++) {
                    int veces = 1;
                    for (String aux : letras) {
                        if (String.valueOf(this.palabra.charAt(i)).equals(aux)) {
                            this.palabraFiltrada += aux;
                        } else {
                            if (veces == cantidad) {
                                this.palabraFiltrada += "-";
                            } else {
                                veces++;
                            }
                        }
                    }
                }
                System.out.println(this.palabraFiltrada);
                if (!this.palabraFiltrada.contains("-")) {
                    System.out.println("¡Has adivinado la palabra!");
                    return true;
                }
            } else {
                System.out.println("La palabra indicada o la letra es errónea");
                this.intentos--;
            }
        }

        return false;
    }
    
    private boolean contieneSoloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char c = cadena.charAt(i);
            if(!((c >= 'a' && c <= 'z'))){
                return false;
            }
        }
        return true;
    }

    //Metodos creados para la realizacion de los tests
    public String getPalabra() {
        return this.palabra;
    }

    public String getPalabraFiltrada() {
        return this.palabraFiltrada;
    }

    public void empezarJuegoTest(String palabra) {
        this.palabra = palabra.toLowerCase();
        if(!this.contieneSoloLetras(this.palabra)) {
            this.palabra = "invalida";
        }
        this.palabraFiltrada = "";

        for (int i = 0; i < this.palabra.length(); i++) {
            this.palabraFiltrada = palabraFiltrada + '-';
        }
    }

    public boolean adivinarPalabrasTest(String letra1, String letra2) {
        ArrayList<String> letras = new ArrayList();
        //String temp1 = letra1.toLowerCase();
        //String temp2 = letra1.toLowerCase();
        if(!this.contieneSoloLetras(letra1) || !this.contieneSoloLetras(letra2)) {
            return false;
        }
        letras.add(letra1);
        letras.add(letra2);
        int cantidad = letras.size();
        this.palabraFiltrada = "";
        for (int i = 0; i < this.palabra.length(); i++) {
            int veces = 1;
            for (String aux : letras) {
                if (String.valueOf(this.palabra.charAt(i)).equals(aux)) {
                    this.palabraFiltrada += aux;
                } else {
                    if (veces == cantidad) {
                        this.palabraFiltrada += "-";
                    } else {
                        veces++;
                    }
                }
            }
        }
        return true;
    }
    
    public boolean adivinarLetra(String letra1) {
        String temp1 = letra1.toLowerCase();
        if(!this.contieneSoloLetras(temp1)) {
            return false;
        }
        
        this.palabraFiltrada = "";
        for (int i = 0; i < this.palabra.length(); i++) {
                if (String.valueOf(this.palabra.charAt(i)).equals(temp1)) {
                    this.palabraFiltrada += temp1;
                } else {
                        this.palabraFiltrada += "-";
                }
        }
        return true;
    }
}
